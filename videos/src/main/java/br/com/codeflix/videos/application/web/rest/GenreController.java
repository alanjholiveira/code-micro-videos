package br.com.codeflix.videos.application.web.rest;

import br.com.codeflix.videos.domain.dto.GenreDTO;
import br.com.codeflix.videos.domain.service.GenreService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@Api(value = "Manter Generos")
@RequestMapping("/v1/genres")
@RequiredArgsConstructor
public class GenreController {

    private static final String IDENTIFICADOR = "Identificador único da Genero";

    private final GenreService service;

    @GetMapping
    public ResponseEntity<List<GenreDTO>> getCategories() {
        log.debug("Requisição REST para listar Generos");
        List<GenreDTO> result = service.getAll();

        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenreDTO> getById(@PathVariable UUID id) {
        log.debug("Requisição REST para buscar Generos: {}", id);

        GenreDTO result = service.getById(id);

        return  ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<GenreDTO> save(@Valid @RequestBody GenreDTO dto) throws Exception {
        log.debug("Requisição REST para salver Genero: {}", dto);
        GenreDTO result = service.save(dto);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenreDTO> update(@Valid @PathVariable UUID id,
                                              @Valid @RequestBody GenreDTO dto) throws Exception {
        log.debug("Requisição REST para atualizar Genero: {}", dto);
        GenreDTO result = service.update(id, dto);

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@Valid @PathVariable UUID id) {
        log.debug("Requisição REST para deletar Genero: {}", id);
        service.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

package br.com.codeflix.videos.application.web.rest;

import br.com.codeflix.videos.application.mapper.GenreMapper;
import br.com.codeflix.videos.application.web.rest.request.GenreRequest;
import br.com.codeflix.videos.application.web.rest.response.GenreResponse;
import br.com.codeflix.videos.domain.entity.Genre;
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
import java.util.stream.Collectors;

@Slf4j
@RestController
@Api(value = "Manter Generos")
@RequestMapping("/v1/genres")
@RequiredArgsConstructor
public class GenreController {

    private static final String IDENTIFICADOR = "Identificador único da Genero";

    private final GenreService service;

    @GetMapping
    public ResponseEntity<List<GenreResponse>> getCategories() {
        log.debug("Requisição REST para listar Generos");
        List<GenreResponse> responses = service.getAll()
                .parallelStream()
                .map(GenreMapper::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenreResponse> getById(@PathVariable UUID id) {
        log.debug("Requisição REST para buscar Generos: {}", id);

        Genre result = service.getById(id);

        return  ResponseEntity.ok(GenreMapper.toResponse(result));
    }

    @PostMapping
    public ResponseEntity<GenreResponse> save(@Valid @RequestBody GenreRequest request) throws Exception {
        log.debug("Requisição REST para salver Genero: {}", request);
        Genre result = service.save(GenreMapper.toEntity(request));

        return new ResponseEntity<>(GenreMapper.toResponse(result), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenreResponse> update(@Valid @PathVariable UUID id,
                                              @Valid @RequestBody GenreRequest request) throws Exception {
        log.debug("Requisição REST para atualizar Genero: {}", request);
        Genre result = service.update(id, GenreMapper.toEntity(request));

        return ResponseEntity.ok(GenreMapper.toResponse(result));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable UUID id) {
        log.debug("Requisição REST para deletar Genero: {}", id);
        service.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

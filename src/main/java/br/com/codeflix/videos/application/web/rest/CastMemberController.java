package br.com.codeflix.videos.application.web.rest;

import br.com.codeflix.videos.domain.dto.CastMemberDTO;
import br.com.codeflix.videos.domain.service.CastMemberService;
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
@Api(value = "Manter Video")
@RequestMapping("/api/v1/cast_members")
@RequiredArgsConstructor
public class CastMemberController {

    private static final String IDENTIFICADOR = "Identificador único da Video";

    private final CastMemberService service;

    @GetMapping
    public ResponseEntity<List<CastMemberDTO>> getAll() {
        log.debug("Requisição REST para listar Cast Member");
        List<CastMemberDTO> result = service.getAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CastMemberDTO> getById(@PathVariable UUID id) {
        log.debug("Requisição REST buscar Cast Member: {}", id);
        CastMemberDTO result = service.getById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<CastMemberDTO> save(@Valid @RequestBody CastMemberDTO dto) {
        log.debug("Requisição REST para salvar: {}", dto);
        CastMemberDTO result = service.save(dto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CastMemberDTO> update(@Valid @PathVariable UUID id,
                                           @Valid @RequestBody CastMemberDTO dto) {
        log.debug("Requisição REST para atualizar: {}", dto);
        CastMemberDTO result = service.update(id, dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable UUID id) {
        log.debug("Requisição REST deletar: {}", id);
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

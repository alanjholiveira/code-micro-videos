package br.com.codeflix.videos.application.web.rest;

import br.com.codeflix.videos.application.mapper.CastMemberMapper;
import br.com.codeflix.videos.application.web.rest.request.CastMemberRequest;
import br.com.codeflix.videos.application.web.rest.response.CastMemberResponse;
import br.com.codeflix.videos.domain.entity.CastMember;
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
import java.util.stream.Collectors;

@Slf4j
@RestController
@Api(value = "Manter Video")
@RequestMapping("/api/v1/cast_members")
@RequiredArgsConstructor
public class CastMemberController {

    private static final String IDENTIFICADOR = "Identificador único da Video";

    private final CastMemberService service;

    @GetMapping
    public ResponseEntity<List<CastMemberResponse>> getAll() {
        log.debug("Requisição REST para listar Cast Member");
        List<CastMemberResponse> result = service.getAll()
                .parallelStream()
                .map(CastMemberMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CastMemberResponse> getById(@PathVariable UUID id) {
        log.debug("Requisição REST buscar Cast Member: {}", id);
        CastMember result = service.getById(id);
        return ResponseEntity.ok(CastMemberMapper.toResponse(result));
    }

    @PostMapping
    public ResponseEntity<CastMemberResponse> save(@Valid @RequestBody CastMemberRequest request) {
        log.debug("Requisição REST para salvar: {}", request);
        CastMember result = service.save(CastMemberMapper.toEntity(request));
        return new ResponseEntity<>(CastMemberMapper.toResponse(result), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CastMemberResponse> update(@Valid @PathVariable UUID id,
                                           @Valid @RequestBody CastMemberRequest request) {
        log.debug("Requisição REST para atualizar: {}", request);
        CastMember result = service.update(id, CastMemberMapper.toEntity(request));
        return ResponseEntity.ok(CastMemberMapper.toResponse(result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable UUID id) {
        log.debug("Requisição REST deletar: {}", id);
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

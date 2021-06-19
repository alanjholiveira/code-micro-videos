package br.com.codeflix.videos.application.web.rest;

import br.com.codeflix.videos.domain.dto.VideoDTO;
import br.com.codeflix.videos.domain.service.VideoService;
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
@RequestMapping("/api/v1/videos")
@RequiredArgsConstructor
public class VideoController {

    private static final String IDENTIFICADOR = "Identificador único da Video";

    private final VideoService service;

    @GetMapping
    public ResponseEntity<List<VideoDTO>> getAll() {
        log.debug("Requisição REST para listar video");
        List<VideoDTO> result = service.getAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VideoDTO> getById(@PathVariable UUID id) {
        log.debug("Requisição REST buscar video: {}", id);
        VideoDTO result = service.getById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<VideoDTO> save(@Valid @RequestBody VideoDTO dto) {
        log.debug("Requisição REST para salvar video: {}", dto);
        VideoDTO result = service.save(dto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VideoDTO> update(@Valid @PathVariable UUID id,
                                           @Valid @RequestBody VideoDTO dto) {
        log.debug("Requisição REST para atualizar video: {}", dto);
        VideoDTO result = service.update(id, dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable UUID id) {
        log.debug("Requisição REST deletar video: {}", id);
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

package br.com.codeflix.videos.application.web.rest;

import br.com.codeflix.videos.application.mapper.VideoMapper;
import br.com.codeflix.videos.application.web.rest.request.VideoRequest;
import br.com.codeflix.videos.application.web.rest.response.VideoResponse;
import br.com.codeflix.videos.domain.entity.Video;
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
import java.util.stream.Collectors;

@Slf4j
@RestController
@Api(value = "Manter Video")
@RequestMapping("/api/v1/videos")
@RequiredArgsConstructor
public class VideoController {

    private static final String IDENTIFICADOR = "Identificador único da Video";

    private final VideoService service;

    @GetMapping
    public ResponseEntity<List<VideoResponse>> findAll() {
        log.debug("Requisição REST para listar video");
        List<VideoResponse> result = service.findAll()
                .parallelStream()
                .map(VideoMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VideoResponse> getById(@PathVariable UUID id) {
        log.debug("Requisição REST buscar video: {}", id);
        Video result = service.getById(id);
        return ResponseEntity.ok(VideoMapper.toResponse(result));
    }

    @PostMapping
    public ResponseEntity<VideoResponse> save(@Valid @RequestBody VideoRequest request) {
        log.debug("Requisição REST para salvar video: {}", request);
        Video result = service.save(VideoMapper.toEntity(request));
        return new ResponseEntity<>(VideoMapper.toResponse(result), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VideoResponse> update(@Valid @PathVariable UUID id,
                                           @Valid @RequestBody VideoRequest request) {
        log.debug("Requisição REST para atualizar video: {}", request);
        Video result = service.update(id, VideoMapper.toEntity(request));
        return ResponseEntity.ok(VideoMapper.toResponse(result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable UUID id) {
        log.debug("Requisição REST deletar video: {}", id);
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

package br.com.codeflix.videos.domain.service;

import br.com.codeflix.videos.domain.entity.Video;
import br.com.codeflix.videos.infrastructure.exception.NotFoundException;
import br.com.codeflix.videos.infrastructure.exception.ParametrizedMessageException;
import br.com.codeflix.videos.infrastructure.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class VideoService {

    private final VideoRepository repository;

    @Transactional(readOnly = true)
    public List<Video> findAll() {
        log.debug("Requisição para listagem de Video");
        try {
            return repository.findAll();
        } catch (NotFoundException e) {
            throw new ParametrizedMessageException("Error", "Erro ao listar Video");
        }
    }

    public Video save(Video entity) {
        log.debug("Requisição salvar video");
        try {
            return repository.save(entity);

        } catch (Exception e) {
            throw new ParametrizedMessageException("Error", "Falha ao Salvar os dados");
        }

    }

    public Video update(UUID id, Video entity) {
        log.debug("Requisição atualizar video");
        return repository.findById(id)
                .map(data -> {
                    data.setTitle(entity.getTitle());
                    data.setDescription(entity.getDescription());
                    data.setDuration(entity.getDuration());
                    data.setOpened(entity.getOpened());
                    data.setYearLaunched(entity.getYearLaunched());
                    data.setRating(entity.getRating());
                    data.setUpdateAt(LocalDateTime.now());
                    return repository.save(data);
                }).orElseThrow(NotFoundException::new);
    }

    @Transactional(readOnly = true)
    public Video getById(UUID id) {
        log.debug("Requisição buscar video");
        return repository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    public void delete(UUID id) {
        log.debug("Requisição deletar video");

        Video video = repository.findById(id)
                .orElseThrow(NotFoundException::new);

        if (video.getId().equals(id)) {
            repository.deleteById(id);
        }
    }
}

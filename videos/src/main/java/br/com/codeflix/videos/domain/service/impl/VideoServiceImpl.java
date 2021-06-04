package br.com.codeflix.videos.domain.service.impl;

import br.com.codeflix.videos.domain.dto.VideoDTO;
import br.com.codeflix.videos.domain.entity.Video;
import br.com.codeflix.videos.domain.service.VideoService;
import br.com.codeflix.videos.domain.service.mapper.VideoMapper;
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
public class VideoServiceImpl implements VideoService {

    private final VideoRepository repository;
    private final VideoMapper mapper;

    @Override
    public List<VideoDTO> getAll() throws NotFoundException {
        log.debug("Requisição para listagem de Video");
        try {
            List<Video> result = repository.findAll();

            return mapper.toDto(result);
        } catch (NotFoundException e) {
            throw new NotFoundException("Erro ao listar Video");
        }
    }

    @Override
    public VideoDTO save(VideoDTO dto) throws ParametrizedMessageException {
        log.debug("Requisição salvar video");

        try {
            Video video = mapper.toEntity(dto);

            Video result = repository.save(video);

            return mapper.toDto(result);

        } catch (Exception e) {
            throw new ParametrizedMessageException("Error", "Falha ao Salvar os dados");
        }

    }

    @Override
    public VideoDTO update(UUID id, VideoDTO dto) throws ParametrizedMessageException {
        log.debug("Requisição atualizar video");

        Video result = repository.findById(id)
                .map(data -> {
                    data.setTitle(dto.getTitle());
                    data.setDescription(dto.getDescription());
                    data.setDuration(dto.getDuration());
                    data.setOpened(dto.getOpened());
                    data.setYearLaunched(dto.getYearLaunched());
                    data.setRating(dto.getRating());
                    data.setUpdateAt(LocalDateTime.now());
                    return repository.save(data);
                }).orElseThrow(() -> new NotFoundException("Registro não encontrado"));

        return mapper.toDto(result);
    }

    @Override
    public VideoDTO getById(UUID id) throws NotFoundException {
        log.debug("Requisição buscar video");

        Video result = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Registro não encontrado"));

        return mapper.toDto(result);

    }

    @Override
    public void delete(UUID id) throws ParametrizedMessageException {
        log.debug("Requisição deletar video");

        Video video = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Regitro não encontrado"));

        if (video.getId().equals(id)) {
            repository.deleteById(id);
        }
    }
}

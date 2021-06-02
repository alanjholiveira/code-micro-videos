package br.com.codeflix.videos.domain.service.impl;

import br.com.codeflix.videos.domain.dto.GenreDTO;
import br.com.codeflix.videos.domain.entity.Genre;
import br.com.codeflix.videos.domain.service.GenreService;
import br.com.codeflix.videos.domain.service.mapper.GenreMapper;
import br.com.codeflix.videos.infrastructure.exception.NotFoundException;
import br.com.codeflix.videos.infrastructure.exception.ParametrizedMessageException;
import br.com.codeflix.videos.infrastructure.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository repository;
    private final GenreMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public List<GenreDTO> getAll() throws NotFoundException {
        log.debug("Requisição para listagem de Generos");

      try {
          List<Genre> result = repository.findAll();

          return mapper.toDto(result);
      } catch (NotFoundException e) {
          throw new NotFoundException("Erro ao listar Generos");
      }

    }

    @Override
    public GenreDTO save(@Valid GenreDTO dto) throws Exception {
        try {
            Genre genre = mapper.toEntity(dto);

            Genre result = repository.save(genre);

            return mapper.toDto(result);
        } catch (Exception e) {
            throw  new ParametrizedMessageException("tes", "sd");
        }
    }

    @Override
    public GenreDTO update(@Valid UUID id, @Valid GenreDTO dto) throws Exception {
        Genre genre = mapper.toEntity(dto);

        Genre result = repository.findById(id)
                .map(record -> {
                    record.setName(genre.getName());
                    record.setIsActive(genre.getIsActive());
                    return repository.save(record);
                }).orElseThrow(() -> new NotFoundException("Registro não encontrado"));

        return mapper.toDto(result);

    }

    @Override
    @Transactional(readOnly = true)
    public GenreDTO getById(@Valid UUID id) throws NotFoundException {

        Genre result = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Regitro não encontrado"));

        return mapper.toDto(result);

    }

    @Override
    public void delete(@Valid UUID id) {
        Genre category=  repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Regitro não encontrado"));

        if (category.getId().equals(id)) {
            repository.deleteById(id);
        }
    }
}

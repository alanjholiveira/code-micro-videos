package br.com.codeflix.videos.domain.service;

import br.com.codeflix.videos.domain.entity.Genre;
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
public class GenreService {

    private final GenreRepository repository;

    @Transactional(readOnly = true)
    public List<Genre> getAll() {
        log.debug("Requisição para listagem de Generos");

      try {
          return repository.findAll();
      } catch (NotFoundException e) {
          throw new ParametrizedMessageException("Error", "Erro ao listar Generos");
      }

    }

    public Genre save(@Valid Genre entity) {
        try {
            return repository.save(entity);
        } catch (Exception e) {
            throw  new ParametrizedMessageException("tes", "sd");
        }
    }

    public Genre update(@Valid UUID id, @Valid Genre entity) {
        return repository.findById(id)
                .map(data -> {
                    data.setName(entity.getName());
                    data.setIsActive(entity.getIsActive());
                    return repository.save(data);
                }).orElseThrow(NotFoundException::new);
    }

    @Transactional(readOnly = true)
    public Genre getById(@Valid UUID id) {
        return repository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    public void delete(@Valid UUID id) {
        Genre category=  repository.findById(id)
                .orElseThrow(NotFoundException::new);

        if (category.getId().equals(id)) {
            repository.deleteById(id);
        }
    }
}

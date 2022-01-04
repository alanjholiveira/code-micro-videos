package br.com.codeflix.videos.domain.service;

import br.com.codeflix.videos.domain.entity.Category;
import br.com.codeflix.videos.infrastructure.exception.NotFoundException;
import br.com.codeflix.videos.infrastructure.exception.ParametrizedMessageException;
import br.com.codeflix.videos.infrastructure.repository.CategoryRepository;
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
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<Category> findAll() {
        log.debug("Requisição para listagem de Categorias");
        try {
          return categoryRepository.findAll();
        } catch (NotFoundException e) {
          throw new ParametrizedMessageException("Error", "Erro ao listar Categoria");
        }

    }

    public Category save(@Valid Category entity) {
        try {
            return categoryRepository.save(entity);
        } catch (Exception e) {
            throw new ParametrizedMessageException("Error", "Falha ao Salvar os dados");
        }
    }

    public Category update(@Valid UUID id, @Valid Category entity) {
        return categoryRepository.findById(id)
                .map(data -> {
                    data.setName(entity.getName());
                    data.setDescription(entity.getDescription());
                    data.setIsActive(entity.getIsActive());
                    return categoryRepository.save(data);
                }).orElseThrow(NotFoundException::new);
    }

    @Transactional(readOnly = true)
    public Category getById(@Valid UUID id) {
        return categoryRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    public void delete(@Valid UUID id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(NotFoundException::new);

        if (category.getId().equals(id)) {
            categoryRepository.deleteById(id);
        }
    }
}

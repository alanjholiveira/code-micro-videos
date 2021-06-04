package br.com.codeflix.videos.domain.service.impl;

import br.com.codeflix.videos.domain.dto.CategoryDTO;
import br.com.codeflix.videos.domain.entity.Category;
import br.com.codeflix.videos.domain.service.CategoryService;
import br.com.codeflix.videos.domain.service.mapper.CategoryMapper;
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
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    @Transactional(readOnly = true)
    public List<CategoryDTO> getCategories() throws NotFoundException {
        log.debug("Requisição para listagem de Categorias");

      try {
          List<Category> result = categoryRepository.findAll();

          return categoryMapper.toDto(result);
      } catch (NotFoundException e) {
          throw new NotFoundException("Erro ao listar Categoria");
      }

    }

    @Override
    public CategoryDTO save(@Valid CategoryDTO dto) throws ParametrizedMessageException {
        try {
            Category category = categoryMapper.toEntity(dto);

            Category result = categoryRepository.save(category);

            return categoryMapper.toDto(result);
        } catch (Exception e) {
            throw new ParametrizedMessageException("Error", "Falha ao Salvar os dados");
        }
    }

    @Override
    public CategoryDTO update(@Valid UUID id, @Valid CategoryDTO dto) throws ParametrizedMessageException {
        Category category = categoryMapper.toEntity(dto);

        Category result = categoryRepository.findById(id)
                .map(data -> {
                    data.setName(category.getName());
                    data.setDescription(category.getDescription());
                    data.setIsActive(category.getIsActive());
                    return categoryRepository.save(data);
                }).orElseThrow(() -> new NotFoundException("Registro não encontrado"));

        return categoryMapper.toDto(result);

    }

    @Override
    @Transactional(readOnly = true)
    public CategoryDTO getById(@Valid UUID id) throws NotFoundException {

        Category result = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Regitro não encontrado"));

        return categoryMapper.toDto(result);

    }

    @Override
    public void delete(@Valid UUID id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Regitro não encontrado"));

        if (category.getId().equals(id)) {
            categoryRepository.deleteById(id);
        }
    }
}

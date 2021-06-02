package br.com.codeflix.videos.domain.service;

import br.com.codeflix.videos.domain.dto.CategoryDTO;
import br.com.codeflix.videos.infrastructure.exception.NotFoundException;
import br.com.codeflix.videos.infrastructure.exception.ParametrizedMessageException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

public interface CategoryService {

//    Page<Category> getCategories(Pageable pageable);
    List<CategoryDTO> getCategories() throws NotFoundException;
    CategoryDTO save(@Valid CategoryDTO dto) throws ParametrizedMessageException;
    CategoryDTO update(@Valid UUID id, @Valid CategoryDTO dto) throws Exception;
    CategoryDTO getById(@Valid UUID id) throws NotFoundException;
    void delete(@Valid UUID id);

}

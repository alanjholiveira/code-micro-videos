package br.com.codeflix.videos.domain.service.mapper;

import org.mapstruct.Mapper;

import br.com.codeflix.videos.domain.dto.CategoryDTO;
import br.com.codeflix.videos.domain.entity.Category;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper extends EntityMapper<CategoryDTO, Category> {
}

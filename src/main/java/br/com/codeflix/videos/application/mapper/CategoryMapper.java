package br.com.codeflix.videos.application.mapper;

import br.com.codeflix.videos.application.web.rest.request.CategoryRequest;
import br.com.codeflix.videos.application.web.rest.response.CategoryResponse;
import br.com.codeflix.videos.domain.entity.Category;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CategoryMapper {

    private static final ObjectMapper mapper;

   static {
       mapper = new ObjectMapper();
   }

   public static Category toEntity(CategoryRequest request) {
       return mapper.convertValue(request, Category.class);
   }

    public static CategoryResponse toResponse(Category entity) {
        return mapper.convertValue(entity, CategoryResponse.class);
    }

}

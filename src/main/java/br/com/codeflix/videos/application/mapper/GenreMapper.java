package br.com.codeflix.videos.application.mapper;

import br.com.codeflix.videos.application.web.rest.request.GenreRequest;
import br.com.codeflix.videos.application.web.rest.response.GenreResponse;
import br.com.codeflix.videos.domain.entity.Genre;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GenreMapper {

    private static final ObjectMapper mapper;

    static {
       mapper = new ObjectMapper();
    }

   public static Genre toEntity(GenreRequest request) {
       return mapper.convertValue(request, Genre.class);
   }

    public static GenreResponse toResponse(Genre entity) {
        return mapper.convertValue(entity, GenreResponse.class);
    }

}

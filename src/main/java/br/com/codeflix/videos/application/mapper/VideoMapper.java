package br.com.codeflix.videos.application.mapper;

import br.com.codeflix.videos.application.web.rest.request.VideoRequest;
import br.com.codeflix.videos.application.web.rest.response.VideoResponse;
import br.com.codeflix.videos.domain.entity.Video;
import com.fasterxml.jackson.databind.ObjectMapper;

public class VideoMapper {

    private static final ObjectMapper mapper;

    static {
       mapper = new ObjectMapper();
    }

   public static Video toEntity(VideoRequest request) {
       return mapper.convertValue(request, Video.class);
   }

    public static VideoResponse toResponse(Video entity) {
        return mapper.convertValue(entity, VideoResponse.class);
    }

}

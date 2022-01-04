package br.com.codeflix.videos.application.mapper;

import br.com.codeflix.videos.application.web.rest.request.CastMemberRequest;
import br.com.codeflix.videos.application.web.rest.response.CastMemberResponse;
import br.com.codeflix.videos.domain.entity.CastMember;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CastMemberMapper {

    private static final ObjectMapper mapper;

    static {
       mapper = new ObjectMapper();
    }

   public static CastMember toEntity(CastMemberRequest request) {
       return mapper.convertValue(request, CastMember.class);
   }

    public static CastMemberResponse toResponse(CastMember entity) {
        return mapper.convertValue(entity, CastMemberResponse.class);
    }

}

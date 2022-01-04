package br.com.codeflix.videos.application.web.rest.response;

import br.com.codeflix.videos.infrastructure.enums.TypeDirectorActorEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CastMemberResponse extends BaseResponse {

    private String name;

    private TypeDirectorActorEnum type;
    
}

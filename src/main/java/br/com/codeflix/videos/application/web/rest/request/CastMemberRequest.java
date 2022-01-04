package br.com.codeflix.videos.application.web.rest.request;

import br.com.codeflix.videos.infrastructure.enums.TypeDirectorActorEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class CastMemberRequest {

    @NotEmpty
    @NotNull
    private String name;

    @NotNull
    private TypeDirectorActorEnum type;

}

package br.com.codeflix.videos.domain.dto;

import br.com.codeflix.videos.infrastructure.enums.TypeDirectorActorEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class CastMemberDTO extends BaseDTO {

    @NotEmpty
    @NotNull
    private String name;

    @NotNull
    private TypeDirectorActorEnum type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CastMemberDTO that = (CastMemberDTO) o;
        return Objects.equals(name, that.name) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, type);
    }
}

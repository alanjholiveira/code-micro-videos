package br.com.codeflix.videos.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class GenreDTO extends BaseDTO {

    @NotEmpty
    @NotNull
    @Size(min = 2, max = 255)
    private String name;

    @NotNull
    private Boolean isActive;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenreDTO genreDTO = (GenreDTO) o;
        return super.getId().equals(genreDTO.getId()) && name.equals(genreDTO.name)
                && Objects.equals(isActive, genreDTO.isActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getId(), name, isActive);
    }
}

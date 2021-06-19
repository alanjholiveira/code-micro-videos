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
public class CategoryDTO extends BaseDTO {

    @NotEmpty
    @NotNull
    @Size(min = 2, max = 255)
    private String name;

    @NotEmpty
    @NotNull
    private String description;

    @NotNull
    private Boolean isActive;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryDTO categoryDTO = (CategoryDTO) o;
        return super.getId().equals(categoryDTO.getId()) && name.equals(categoryDTO.name)
                && Objects.equals(isActive, categoryDTO.isActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getId(), name, isActive);
    }

}

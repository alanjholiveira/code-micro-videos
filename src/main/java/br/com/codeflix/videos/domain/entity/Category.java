package br.com.codeflix.videos.domain.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "tb_categories")
@Getter
@Setter
@NoArgsConstructor
public class Category extends BaseEntity {


    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "is_active")
    private Boolean isActive;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Category category = (Category) o;
        return getId().equals(category.getId())
                && name.equals(category.name)
                && Objects.equals(description, category.description)
                && isActive.equals(category.isActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), name, description, isActive);
    }
}

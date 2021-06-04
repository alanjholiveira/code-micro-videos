package br.com.codeflix.videos.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_categories")
@Getter
@Setter
@NoArgsConstructor
public class Category extends SoftDeleteTimeStamp {

    @Id
    @Column(columnDefinition = "BINARY(16)", name = "id_category")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

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
        Category category = (Category) o;
        return id.equals(category.id) && name.equals(category.name) && description.equals(category.description) &&
                Objects.equals(isActive, category.isActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, isActive);
    }



}

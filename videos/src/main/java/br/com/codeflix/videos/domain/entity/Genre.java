package br.com.codeflix.videos.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_genres")
@Getter
@Setter
@NoArgsConstructor
public class Genre extends SoftDeleteTimeStamp {

    @Id
    @Column(name = "genre_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "is_active")
    private Boolean isActive;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return id.equals(genre.id) && name.equals(genre.name) && Objects.equals(isActive, genre.isActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, isActive);
    }
}

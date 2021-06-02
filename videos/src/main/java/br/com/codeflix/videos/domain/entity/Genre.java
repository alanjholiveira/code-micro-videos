package br.com.codeflix.videos.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_genres")
@Getter
@Setter
@NoArgsConstructor
public class Genre {

    @Id
    @Column(columnDefinition = "BINARY(16)", name = "id_genre")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "created_at", updatable=false)
    @CreationTimestamp
    private LocalDateTime created_at;

    @Column(name = "update_at")
    @UpdateTimestamp
    private LocalDateTime update_at;

    @Column(name = "delete_at")
    private LocalDateTime delete_at;

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

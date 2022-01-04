package br.com.codeflix.videos.domain.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_genres")
@Data
public class Genre extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "is_active")
    private Boolean isActive;

//    private List<Category> categories;

}

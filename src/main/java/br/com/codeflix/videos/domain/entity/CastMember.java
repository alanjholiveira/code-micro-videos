package br.com.codeflix.videos.domain.entity;

import br.com.codeflix.videos.infrastructure.enums.TypeDirectorActorEnum;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tb_cast_members")
@Data
public class CastMember extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private TypeDirectorActorEnum type;
//    private CastMemberType type;

}

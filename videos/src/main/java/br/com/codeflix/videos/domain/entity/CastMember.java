package br.com.codeflix.videos.domain.entity;

import br.com.codeflix.videos.infrastructure.enums.TypeDirectorActorEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "tb_cast_members")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CastMember extends SoftDeleteTimeStamp {

    @Id
    @Column(columnDefinition = "BINARY(16)", name = "id_cast_member")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private TypeDirectorActorEnum type;

}

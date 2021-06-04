package br.com.codeflix.videos.domain.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "tb_videos")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Video extends SoftDeleteTimeStamp {

    @Id
    @Column(name = "id_video")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "year_launched")
    private Integer yearLaunched;

    @Column(name = "opened")
    private Boolean opened;

    @Column(name = "rating")
    private String rating;

    @Column(name = "duration")
    private Integer duration;

}

package br.com.codeflix.videos.domain.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.UUID;

@Entity
@Table(name = "tb_videos")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Video extends SoftDeleteTimeStamp {

    @Id
    @Column(name = "video_id")
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

    @Column(name = "video_file")
    private String videoFile;

    @Column(name = "thumb_file")
    private String thumbFile;

    @Column(name = "banner_file")
    private String bannerFile;

    @Column(name = "trailer_file")
    private String trailerFile;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tb_category_video", joinColumns = @JoinColumn(name = "video_id"),
    inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Collection<Category> categories;

    @JoinTable(name = "tb_genre_video", joinColumns = @JoinColumn(name = "video_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Genre> genres;

}

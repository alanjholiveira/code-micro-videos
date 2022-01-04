package br.com.codeflix.videos.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_videos")
@Data
public class Video extends BaseEntity {


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

//    @Column(name = "video_file")
//    private String videoFile;
//
//    @Column(name = "thumb_file")
//    private String thumbFile;
//
//    @Column(name = "banner_file")
//    private String bannerFile;
//
//    @Column(name = "trailer_file")
//    private String trailerFile;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "tb_category_video", joinColumns = @JoinColumn(name = "video_id"),
//    inverseJoinColumns = @JoinColumn(name = "category_id"))
//    private Collection<Category> categories;
//
//    @JoinTable(name = "tb_genre_video", joinColumns = @JoinColumn(name = "video_id"),
//            inverseJoinColumns = @JoinColumn(name = "genre_id"))
//    @ManyToMany(fetch = FetchType.LAZY)
//    private Collection<Genre> genres;

//    @OneToMany(fetch = FetchType.LAZY)
//    private List<VideFile> videFiles;

}

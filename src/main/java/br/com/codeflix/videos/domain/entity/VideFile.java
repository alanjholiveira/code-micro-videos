package br.com.codeflix.videos.domain.entity;

import lombok.Data;

import javax.persistence.Entity;

@Entity(name = "tb_video_file")
@Data
public class VideFile extends BaseEntity {

    private String title;
    private Float duration;
    private String url;

}

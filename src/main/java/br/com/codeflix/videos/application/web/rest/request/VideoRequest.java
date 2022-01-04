package br.com.codeflix.videos.application.web.rest.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class VideoRequest {

    @NotEmpty
    @NotNull
    private String title;

    private String description;

    private Integer yearLaunched;

    private Boolean opened;

    private String rating;

//    private Integer duration;
//
//    private String videoFile;
//
//    private String thumbFile;
//
//    private String bannerFile;
//
//    private String trailerFile;

//    @NotEmpty
//    @NotNull
//    private Collection<BaseDTO> categories;
//
//    @NotEmpty
//    @NotNull
//    private Collection<BaseDTO> genres;

}

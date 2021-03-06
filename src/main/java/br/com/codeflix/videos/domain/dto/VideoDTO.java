package br.com.codeflix.videos.domain.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class VideoDTO extends BaseDTO {

    @NotEmpty
    @NotNull
    private String title;

    private String description;

    private Integer yearLaunched;

    private Boolean opened;

    private String rating;

    private Integer duration;

    private String videoFile;

    private String thumbFile;

    private String bannerFile;

    private String trailerFile;

    @NotEmpty
    @NotNull
    private Collection<BaseDTO> categories;

    @NotEmpty
    @NotNull
    private Collection<BaseDTO> genres;

}

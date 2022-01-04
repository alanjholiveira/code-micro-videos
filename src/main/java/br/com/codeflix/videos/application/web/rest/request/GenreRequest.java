package br.com.codeflix.videos.application.web.rest.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class GenreRequest {

    @NotEmpty
    @NotNull
    @Size(min = 2, max = 255)
    private String name;

    @NotNull
    private Boolean isActive;

}

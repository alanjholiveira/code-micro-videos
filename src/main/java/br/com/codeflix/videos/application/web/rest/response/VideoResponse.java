package br.com.codeflix.videos.application.web.rest.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideoResponse extends BaseResponse {

    private String title;

    private String description;

    private Integer yearLaunched;

    private Boolean opened;

    private String rating;

}

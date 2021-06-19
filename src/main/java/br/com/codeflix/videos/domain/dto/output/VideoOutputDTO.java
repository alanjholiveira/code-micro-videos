package br.com.codeflix.videos.domain.dto.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class VideoOutputDTO {

    @JsonProperty(value = "resource_id")
    private String resourceId;

    @JsonProperty(value = "file_path")
    private String filePath;

}

package br.com.codeflix.videos.domain.dto.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class VideoInputDTO {

    @JsonProperty(value = "encoded_video_folder")
    private String encodedVideoFolder;

    @JsonProperty(value = "resource_id")
    private String resourceId;

    @JsonProperty(value = "file_path")
    private String filePath;

}

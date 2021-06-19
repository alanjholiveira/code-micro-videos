package br.com.codeflix.videos.domain.dto.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProcessVideoInputDTO {

    @JsonProperty(value = "job_id")
    private String jobId;
    @JsonProperty(value = "output_bucket_path")
    private String outputBucketPath;
    private String status;
    private VideoInputDTO video;
    private String error;
    @JsonProperty(value = "created_at")
    private LocalDateTime createdAt;
    @JsonProperty(value = "update_at")
    private LocalDateTime updateAt;

}

package br.com.codeflix.videos.application.web.rest.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse extends BaseResponse {

    private String name;

    private String description;

    private Boolean isActive;

}

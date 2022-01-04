package br.com.codeflix.videos.application.web.rest.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class BaseResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID id;

}

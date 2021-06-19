package br.com.codeflix.videos.domain.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class BaseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID id;

}

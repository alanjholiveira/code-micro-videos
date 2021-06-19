package br.com.codeflix.videos.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Arrays;
import java.util.List;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ParametrizedMessageException extends RuntimeException {

    private static final Long serialVersionUID = 1L;

    private final String code;
    private final String titleCode;
    private final List<String> parameter;


    public ParametrizedMessageException(String code, String titleCode, String... parameter) {
        this.code = code;
        this.titleCode = titleCode;
        this.parameter = Arrays.asList(parameter);
    }

    public ParametrizedMessageException(String code, String titleCode, Exception exception, String... parameter) {
        super(exception);
        this.code = code;
        this.titleCode = titleCode;
        this.parameter = Arrays.asList(parameter);
    }

    public String getCode() {
        return code;
    }

    public String getTitleCode() {
        return titleCode;
    }

    public List<String> getParameter() {
        return parameter;
    }

}

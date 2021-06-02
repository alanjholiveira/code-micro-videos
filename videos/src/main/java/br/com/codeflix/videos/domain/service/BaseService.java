package br.com.codeflix.videos.domain.service;

import br.com.codeflix.videos.infrastructure.exception.NotFoundException;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

public interface BaseService<D> {

    List<D> getAll() throws NotFoundException;
    D save(@Valid D dto) throws Exception;
    D update(@Valid UUID id, @Valid D dto) throws Exception;
    D getById(@Valid UUID id) throws NotFoundException;
    void delete(@Valid UUID id);

}

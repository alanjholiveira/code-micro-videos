package br.com.codeflix.videos.application.web.rest;

import br.com.codeflix.videos.application.mapper.CategoryMapper;
import br.com.codeflix.videos.application.web.rest.request.CategoryRequest;
import br.com.codeflix.videos.application.web.rest.response.CategoryResponse;
import br.com.codeflix.videos.domain.entity.Category;
import br.com.codeflix.videos.domain.service.CategoryService;
import br.com.codeflix.videos.infrastructure.exception.ParametrizedMessageException;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@RestController
@Api(value = "Manter Categoria")
@RequestMapping("/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private static final String IDENTIFICADOR = "Identificador único da Categoria";

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getCategories() {
        log.debug("Requisição REST para listar categoria");
        List<CategoryResponse> categoryResponses =  categoryService.findAll()
                .parallelStream()
                .map(CategoryMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(categoryResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getById(@PathVariable UUID id) {
        log.debug("Requisição REST para buscar categoria: {}", id);

        Category result = categoryService.getById(id);

        return  ResponseEntity.ok(CategoryMapper.toResponse(result));
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> save(@Valid @RequestBody CategoryRequest request)
            throws ParametrizedMessageException {
        log.debug("Requisição REST para salver categoria: {}", request);
        Category result = categoryService.save(CategoryMapper.toEntity(request));

        return new ResponseEntity<>(CategoryMapper.toResponse(result), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> update(@Valid @PathVariable UUID id,
                                              @Valid @RequestBody CategoryRequest request) {
        log.debug("Requisição REST para atualizar categoria: {}", request);
        Category result = categoryService.update(id, CategoryMapper.toEntity(request));

        return ResponseEntity.ok(CategoryMapper.toResponse(result));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable UUID id) {
        log.debug("Requisição REST para deletar categoria: {}", id);
        categoryService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

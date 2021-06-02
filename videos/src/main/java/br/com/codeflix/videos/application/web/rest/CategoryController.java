package br.com.codeflix.videos.application.web.rest;

import br.com.codeflix.videos.domain.dto.CategoryDTO;
import br.com.codeflix.videos.domain.entity.Category;
import br.com.codeflix.videos.domain.service.CategoryService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@Api(value = "Manter Categoria")
@RequestMapping("/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private static final String IDENTIFICADOR = "Identificador único da Categoria";

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getCategories() {
        log.debug("Requisição REST para listar categoria");
        List<CategoryDTO> result = categoryService.getCategories();

        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getById(@PathVariable UUID id) {
        log.debug("Requisição REST para buscar categoria: {}", id);

        CategoryDTO result = categoryService.getById(id);

        return  ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> save(@Valid @RequestBody CategoryDTO dto) throws Exception {
        log.debug("Requisição REST para salver categoria: {}", dto);
        CategoryDTO result = categoryService.save(dto);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> update(@Valid @PathVariable UUID id,
                                              @Valid @RequestBody CategoryDTO dto) throws Exception {
        log.debug("Requisição REST para atualizar categoria: {}", dto);
        CategoryDTO result = categoryService.update(id, dto);

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@Valid @PathVariable UUID id) {
        log.debug("Requisição REST para deletar categoria: {}", id);
        categoryService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

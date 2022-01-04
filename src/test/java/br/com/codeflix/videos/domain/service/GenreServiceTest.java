package br.com.codeflix.videos.domain.service;

import br.com.codeflix.videos.domain.entity.Genre;
import br.com.codeflix.videos.infrastructure.exception.NotFoundException;
import br.com.codeflix.videos.infrastructure.repository.GenreRepository;
import br.com.codeflix.videos.infrastructure.util.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class GenreServiceTest {

    @MockBean
    private GenreRepository repository;

    @Autowired
    private GenreService service;

    private List<Genre> genres;
    private Genre entity1;

    @BeforeEach
    void setUp() {
        entity1 = new Genre();
        entity1.setId(TestUtil.ID);
        entity1.setName(TestUtil.NAME);
        entity1.setIsActive(TestUtil.IS_ACTIVE_TRUE);

        genres = new ArrayList<>();
        genres.addAll(Arrays.asList(entity1, entity1));
    }

    @Test
    @DisplayName("Test findAll")
    void testGetAll() {
        when(repository.findAll()).thenReturn(genres);

        List<Genre> list = service.getAll();

        Assertions.assertEquals(list.size(), 2);
    }

    @Test
    @DisplayName("Test findById Success")
    void testGetById() {
        when(repository.findById(entity1.getId())).thenReturn(Optional.of(entity1));

        Genre result = service.getById(entity1.getId());

        Assertions.assertNotNull(result);
        Assertions.assertNotSame(result, entity1);
        Assertions.assertEquals(result, entity1);
    }

    @Test
    @DisplayName("Test findById Not Found")
    void testGetByIdNotFound() throws NotFoundException {
        Mockito.doReturn(Optional.empty()).when(repository).findById(TestUtil.ID);
        AtomicReference<Genre> result = new AtomicReference<>();

        Exception exception = Assertions.assertThrows(NotFoundException.class, () ->
            result.set(service.getById(entity1.getId()))
        );

        Assertions.assertEquals("Regitro não encontrado", exception.getMessage());
        Assertions.assertNull(result.get());

    }

    @Test
    @DisplayName("Test save Category")
    void testSave() throws Exception {
        when(repository.save(entity1)).thenReturn(entity1);

        Genre result = service.save(entity1);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result, entity1);
        Assertions.assertNotSame(result, entity1);
        Assertions.assertEquals(36, result.getId().toString().length());
    }

    @Test
    @DisplayName("Test Update Category")
    void testUpdate() throws Exception {
        when(repository.save(entity1)).thenReturn(entity1);
        when(repository.findById(entity1.getId())).thenReturn(Optional.of(entity1));

        Genre result = service.update(entity1.getId(), entity1);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result, entity1);
        Assertions.assertNotSame(result, entity1);
    }

    @Test
    @DisplayName("Test update Not Found row")
    void testUpdateNotFound() throws NotFoundException {
        when(repository.save(entity1)).thenReturn(entity1);
        when(repository.findById(entity1.getId())).thenReturn(Optional.of(entity1));

        AtomicReference<Genre> result = new AtomicReference<>();

        Exception exception = Assertions.assertThrows(NotFoundException.class, () ->
                result.set(service.update(TestUtil.ID2, entity1))
        );

        Assertions.assertEquals("Registro não encontrado", exception.getMessage());
        Assertions.assertNull(result.get());

    }

    @Test
    void testDelete() {
        when(repository.save(entity1)).thenReturn(entity1);
        when(repository.findById(entity1.getId())).thenReturn(Optional.of(entity1));

        service.delete(TestUtil.ID);

        verify(repository).deleteById(TestUtil.ID);

    }


}

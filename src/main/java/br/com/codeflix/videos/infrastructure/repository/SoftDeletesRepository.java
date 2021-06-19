package br.com.codeflix.videos.infrastructure.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 *
 * @param <T>
 *            the class of the entity
 * @param <I>
 *            the ID class of the entity
 *
 *            NoRepositoryBean interface for the soft delete functionality
 */

@NoRepositoryBean
public interface SoftDeletesRepository<T, I extends Serializable> extends PagingAndSortingRepository<T, I> {

    Iterable<T> findAllActive();

    Iterable<T> findAllActive(Sort sort);

    Page<T> findAllActive(Pageable pageable);

    Iterable<T> findAllActive(Iterable<I> ids);

    T findOneActive(I id);

    @Modifying
    void softDelete(I id);

    @Modifying
    void softDelete(T entity);

    @Modifying
    void softDelete(Iterable<? extends T> entities);

    @Modifying
    void softDeleteAll();

    @Modifying
    void scheduleSoftDelete(I id, LocalDateTime localDateTime);

    @Modifying
    void scheduleSoftDelete(T entity, LocalDateTime localDateTime);

    long countActive();

    boolean existsActive(I id);

}

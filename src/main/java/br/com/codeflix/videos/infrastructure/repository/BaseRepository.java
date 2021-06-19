package br.com.codeflix.videos.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<T, I> extends JpaRepository<T, I> {

    @Query("SELECT e FROM #{#entityName} e WHERE e.deleteAt IS NOT NULL AND e.id = ?1")
    T findInactiveById(I id);

    @Query("SELECT e FROM #{#entityName} e WHERE e.deleteAt IS NOT NULL")
    List<T> findAllInactive();

    @Modifying(clearAutomatically = true)
    @Query("UPDATE #{#entityName} e SET e.deleteAt = '' WHERE e.id = ?1")
    void deleteRestoreById(I id);

    @Override
    @Query("SELECT e FROM #{#entityName} e WHERE e.deleteAt IS NULL")
    List<T> findAll();

    @Override
    @Query("SELECT e FROM #{#entityName} e WHERE e.deleteAt IS NULL AND e.id = ?1")
    Optional<T> findById(I i);

    @Override
    @Modifying(clearAutomatically = true)
    @Query("UPDATE #{#entityName} e SET e.deleteAt = CURRENT_TIMESTAMP WHERE e.id = ?1")
    void deleteById(I id);

}

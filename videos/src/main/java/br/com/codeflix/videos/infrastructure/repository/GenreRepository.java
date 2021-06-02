package br.com.codeflix.videos.infrastructure.repository;

import br.com.codeflix.videos.domain.entity.Genre;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GenreRepository extends BaseRepository<Genre, UUID> {
}

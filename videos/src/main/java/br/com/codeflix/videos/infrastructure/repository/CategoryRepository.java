package br.com.codeflix.videos.infrastructure.repository;

import br.com.codeflix.videos.domain.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryRepository extends BaseRepository<Category, UUID> {
}

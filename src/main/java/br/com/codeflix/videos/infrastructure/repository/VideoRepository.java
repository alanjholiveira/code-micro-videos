package br.com.codeflix.videos.infrastructure.repository;

import br.com.codeflix.videos.domain.entity.Video;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VideoRepository extends BaseRepository<Video, UUID> {
}

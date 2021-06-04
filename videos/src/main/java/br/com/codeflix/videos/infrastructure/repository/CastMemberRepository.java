package br.com.codeflix.videos.infrastructure.repository;

import br.com.codeflix.videos.domain.entity.CastMember;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CastMemberRepository extends BaseRepository<CastMember, UUID> {
}

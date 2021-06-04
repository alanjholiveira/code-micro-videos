package br.com.codeflix.videos.domain.service.mapper;

import br.com.codeflix.videos.domain.dto.CastMemberDTO;
import br.com.codeflix.videos.domain.entity.CastMember;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CastMemberMapper extends EntityMapper<CastMemberDTO, CastMember> {
}

package br.com.codeflix.videos.domain.service.mapper;

import br.com.codeflix.videos.domain.dto.VideoDTO;
import br.com.codeflix.videos.domain.entity.Video;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VideoMapper extends EntityMapper<VideoDTO, Video> {
}

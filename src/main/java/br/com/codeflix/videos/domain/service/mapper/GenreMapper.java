package br.com.codeflix.videos.domain.service.mapper;

import br.com.codeflix.videos.domain.dto.GenreDTO;
import br.com.codeflix.videos.domain.entity.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GenreMapper extends EntityMapper<GenreDTO, Genre> {
}

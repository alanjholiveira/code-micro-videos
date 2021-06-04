package br.com.codeflix.videos.domain.service.impl;

import br.com.codeflix.videos.domain.dto.CastMemberDTO;
import br.com.codeflix.videos.domain.entity.CastMember;
import br.com.codeflix.videos.domain.service.CastMemberService;
import br.com.codeflix.videos.domain.service.mapper.CastMemberMapper;
import br.com.codeflix.videos.infrastructure.exception.NotFoundException;
import br.com.codeflix.videos.infrastructure.exception.ParametrizedMessageException;
import br.com.codeflix.videos.infrastructure.repository.CastMemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CastMemberServiceImpl implements CastMemberService {

    private final CastMemberRepository repository;
    private final CastMemberMapper mapper;
    
    @Override
    public List<CastMemberDTO> getAll() throws NotFoundException {
        log.debug("Requisição para listagem de Cast Member");
        try {
            List<CastMember> result = repository.findAll();

            return mapper.toDto(result);
        } catch (NotFoundException e) {
            throw new NotFoundException("Erro ao listar Cast Member");
        }
    }

    @Override
    public CastMemberDTO save(CastMemberDTO dto) throws ParametrizedMessageException {
        log.debug("Requisição salvar Cast Member");

        try {
            CastMember castMember = mapper.toEntity(dto);

            CastMember result = repository.save(castMember);

            return mapper.toDto(result);

        } catch (Exception e) {
            throw new ParametrizedMessageException("Error", "Falha ao Salvar os dados");
        }
    }

    @Override
    public CastMemberDTO update(UUID id, CastMemberDTO dto) throws ParametrizedMessageException {
        log.debug("Requisição atualizar Cast Member");

        CastMember result = repository.findById(id)
                .map(data -> {
                    data.setName(dto.getName());
                    data.setType(dto.getType());
                    data.setUpdateAt(LocalDateTime.now());
                    return repository.save(data);
                }).orElseThrow(() -> new NotFoundException("Registro não encontrado"));

        return mapper.toDto(result);
    }

    @Override
    public CastMemberDTO getById(UUID id) throws NotFoundException {
        log.debug("Requisição buscar Cast Member");

        CastMember result = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Registro não encontrado"));

        return mapper.toDto(result);
    }

    @Override
    public void delete(UUID id) {
        log.debug("Requisição deletar Cast Member");

        CastMember castMember = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Regitro não encontrado"));

        if (castMember.getId().equals(id)) {
            repository.deleteById(id);
        }
    }
}

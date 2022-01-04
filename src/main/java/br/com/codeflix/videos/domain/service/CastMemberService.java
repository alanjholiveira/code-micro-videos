package br.com.codeflix.videos.domain.service;

import br.com.codeflix.videos.domain.entity.CastMember;
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
public class CastMemberService {

    private final CastMemberRepository repository;

    @Transactional(readOnly = true)
    public List<CastMember> getAll() {
        log.debug("Requisição para listagem de Cast Member");
        try {
            return repository.findAll();
        } catch (NotFoundException e) {
            throw new ParametrizedMessageException("Error", "Erro ao listar Cast Member");
        }
    }

    public CastMember save(CastMember entity) {
        log.debug("Requisição salvar Cast Member");
        try {
            return repository.save(entity);
        } catch (Exception e) {
            throw new ParametrizedMessageException("Error", "Falha ao Salvar os dados");
        }
    }

    public CastMember update(UUID id, CastMember entity) {
        log.debug("Requisição atualizar Cast Member");
        return repository.findById(id)
                .map(data -> {
                    data.setName(entity.getName());
                    data.setType(entity.getType());
                    data.setUpdateAt(LocalDateTime.now());
                    return repository.save(data);
                }).orElseThrow(NotFoundException::new);
    }

    @Transactional(readOnly = true)
    public CastMember getById(UUID id) {
        log.debug("Requisição buscar Cast Member");
        return repository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    public void delete(UUID id) {
        log.debug("Requisição deletar Cast Member");

        CastMember castMember = repository.findById(id)
                .orElseThrow(NotFoundException::new);

        if (castMember.getId().equals(id)) {
            repository.deleteById(id);
        }
    }
}

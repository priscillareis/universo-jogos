package com.projeto.universojogos.adapter.outbound;

import com.projeto.universojogos.adapter.persistence.entity.PlataformaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlataformaRepository extends JpaRepository<PlataformaEntity, Long> {
    Optional<PlataformaEntity> findFirstByNomeContains(String nome);
}

package com.projeto.universojogos.adapter.outbound;

import com.projeto.universojogos.adapter.persistence.entity.DesenvolvedoraEntity;
import com.projeto.universojogos.core.domain.Desenvolvedora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DesenvolvedoraRepository extends JpaRepository<DesenvolvedoraEntity, Long> {
}

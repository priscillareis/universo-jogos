package com.projeto.universojogos.adapter.outbound;

import com.projeto.universojogos.adapter.persistence.entity.PlataformaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PlataformaRepository extends JpaRepository<PlataformaEntity, Integer> {
}

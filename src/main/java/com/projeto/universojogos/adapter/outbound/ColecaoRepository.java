package com.projeto.universojogos.adapter.outbound;

import com.projeto.universojogos.adapter.persistence.entity.ColecaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColecaoRepository extends JpaRepository<ColecaoEntity, Long> {
}

package com.projeto.universojogos.adapter.outbound;

import com.projeto.universojogos.adapter.persistence.entity.ConsoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsoleRepository extends JpaRepository<ConsoleEntity, Integer> {
}

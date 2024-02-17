package com.projeto.universojogos.adapter.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "consoles")
public class ConsoleEntity {
    @Id
    @Column(name="id_console", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @Column(name="ano_lancamento")
    private String anoLancamento;
    @ManyToOne(targetEntity = PlataformaEntity.class)
    private PlataformaEntity plataforma;
}

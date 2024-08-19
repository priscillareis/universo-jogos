package com.projeto.universojogos.adapter.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "games")
public class GameEntity {
    @Id
    @Column(name="id_game", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="nome", nullable = false)
    private String nome;

    @Column(name="ano_lancamento")
    private String anoLancamento;

    @Column(name="data_aquisicao")
    private Date dataAquisicao;

    @Column(name="valor_aquisicao")
    private BigDecimal valorAquisicao;

    @ManyToOne(targetEntity = ConsoleEntity.class)
    @JoinColumn(name="id_console", nullable = false)
    private ConsoleEntity console;

    @ManyToOne(targetEntity = DesenvolvedoraEntity.class)
    @JoinColumn(name="id_desenvolvedora")
    private DesenvolvedoraEntity desenvolvedora;
}

package com.projeto.universojogos.adapter.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "registroGames")
public class RegistroGameEntity {

    @Id
    @Column(name="id_registro_game", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="data_inicio")
    private Date dataInicio;

    @Column(name="data_fim")
    private Date dataFim;

    @ManyToOne(targetEntity = GameEntity.class)
    @JoinColumn(name="id_game", nullable = false)
    private GameEntity game;

    @ManyToOne(targetEntity = JogadorEntity.class)
    @JoinColumn(name="id_jogador", nullable = false)
    private JogadorEntity jogador;

    @Column(name="horas_jogada")
    private BigDecimal horasJogadas;

    @Column(name="todas_conquistas")
    private Boolean todasConquistas;
}

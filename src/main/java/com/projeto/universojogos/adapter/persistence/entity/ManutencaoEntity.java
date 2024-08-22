package com.projeto.universojogos.adapter.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "manutencoes")
public class ManutencaoEntity {
    @Id
    @Column(name="id_manutencao", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="data")
    private Date data;

    @ManyToOne(targetEntity = ColecaoEntity.class)
    @JoinColumn(name="id_colecao", nullable = false)
    private ColecaoEntity colecao;
}

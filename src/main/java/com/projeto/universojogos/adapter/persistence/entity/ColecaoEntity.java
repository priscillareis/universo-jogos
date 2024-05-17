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
@Entity(name = "colecoes")
public class ColecaoEntity {
    @Id
    @Column(name="id_colecao", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="data_aquisicao")
    private Date dataAquisicao;

    @Column(name="valor_aquisicao")
    private BigDecimal valorAquisicao;

    @ManyToOne(targetEntity = ConsoleEntity.class)
    @JoinColumn(name="id_console", nullable = false)
    private ConsoleEntity console;
}

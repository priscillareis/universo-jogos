package com.projeto.universojogos.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Colecao {
    private int id;

    private Date dataAquisicao;

    private BigDecimal valorAquisicao;

    private Console console;
}

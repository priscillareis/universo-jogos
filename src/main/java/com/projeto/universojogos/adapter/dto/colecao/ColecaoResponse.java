package com.projeto.universojogos.adapter.dto.colecao;

import com.projeto.universojogos.adapter.dto.console.ConsoleRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ColecaoResponse {
    private int id;

    private Date dataAquisicao;

    private BigDecimal valorAquisicao;

    private ConsoleRequest console;
}

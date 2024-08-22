package com.projeto.universojogos.adapter.dto.manutencao;

import com.projeto.universojogos.adapter.dto.colecao.ColecaoResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ManutencaoResponse {
    private int id;

    private String data;

    private ColecaoResponse colecao;
}

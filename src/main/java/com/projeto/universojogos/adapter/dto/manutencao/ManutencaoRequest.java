package com.projeto.universojogos.adapter.dto.manutencao;

import com.projeto.universojogos.adapter.config.validation.ValidacaoAtualizacao;
import com.projeto.universojogos.adapter.config.validation.ValidacaoCadastro;
import com.projeto.universojogos.adapter.config.validation.ValidacaoConsulta;
import com.projeto.universojogos.adapter.config.validation.mensagens.MensagensValidacao;
import com.projeto.universojogos.adapter.dto.colecao.ColecaoRequest;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class ManutencaoRequest {
    @Min(value = 1,groups =  {ValidacaoConsulta.class, ValidacaoAtualizacao.class},
            message = MensagensValidacao.ID_OBRIGATORIO)
    private int id;

    private String data;

    @NotNull(groups = {ValidacaoCadastro.class}, message = MensagensValidacao.COLECAO_OBRIGATORIO)
    private ColecaoRequest colecao;

}

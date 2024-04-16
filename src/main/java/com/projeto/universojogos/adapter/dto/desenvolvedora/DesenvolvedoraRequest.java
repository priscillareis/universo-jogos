package com.projeto.universojogos.adapter.dto.desenvolvedora;

import com.projeto.universojogos.adapter.config.validation.*;
import com.projeto.universojogos.adapter.config.validation.mensagens.MensagensValidacao;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class DesenvolvedoraRequest {
    @Min(value = 1,groups =  {ValidacaoConsulta.class, ValidacaoAtualizacao.class},
            message = MensagensValidacao.ID_OBRIGATORIO)
    private int id;
    @NotBlank(groups = {ValidacaoCadastro.class, ValidacaoAtualizacao.class},
            message = MensagensValidacao.NOME_OBRIGATORIO)
    private String nome;
}

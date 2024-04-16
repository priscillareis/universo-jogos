package com.projeto.universojogos.adapter.dto.console;

import com.projeto.universojogos.adapter.config.validation.*;
import com.projeto.universojogos.adapter.config.validation.mensagens.MensagensValidacao;
import com.projeto.universojogos.adapter.dto.plataforma.PlataformaRequest;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ConsoleRequest {
    @Min(value = 1,groups =  {ValidacaoConsulta.class, ValidacaoAtualizacao.class},
            message = MensagensValidacao.ID_OBRIGATORIO)
    private int id;

    @NotBlank(groups = {ValidacaoCadastro.class}, message = MensagensValidacao.NOME_OBRIGATORIO)
    private String nome;

    @Pattern(regexp="^([0-9]{0})|([0-9]{4})$",
            groups = {ValidacaoConsulta.class, ValidacaoAtualizacao.class, ValidacaoCadastro.class},
            message = MensagensValidacao.ANO_INVALIDO)
    private String anoLancamento;

    @NotNull(groups = {ValidacaoCadastro.class}, message=MensagensValidacao.PLATAFORMA_OBRIGATORIO)
    private PlataformaRequest plataforma;
}

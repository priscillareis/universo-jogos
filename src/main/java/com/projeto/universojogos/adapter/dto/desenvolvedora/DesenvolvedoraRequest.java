package com.projeto.universojogos.adapter.dto.desenvolvedora;

import com.projeto.universojogos.adapter.config.validation.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DesenvolvedoraRequest {
    @NotNull(groups =  {ValidacaoConsulta.class, ValidacaoAtualizacao.class}, message = "ID é obrigatório")
    private int id;
    @NotBlank(groups = {ValidacaoCadastro.class, ValidacaoAtualizacao.class},
            message = "Nome da desenvolvedora é obrigatório")
    private String nome;
}

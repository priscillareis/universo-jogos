package com.projeto.universojogos.adapter.dto.game;

import com.projeto.universojogos.adapter.config.validation.ValidacaoCadastro;
import com.projeto.universojogos.adapter.dto.console.ConsoleRequest;
import com.projeto.universojogos.adapter.dto.desenvolvedora.DesenvolvedoraRequest;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameRequest {
    private int id;

    @NotBlank(groups = {ValidacaoCadastro.class},
            message = "Nome do game é obrigatório")
    private String nome;

    @Max(value = 4)
    private String anoLancamento;

    @NotNull(groups = {ValidacaoCadastro.class},
            message="Console do game é obrigatório")
    private ConsoleRequest console;

    private DesenvolvedoraRequest desenvolvedora;
}

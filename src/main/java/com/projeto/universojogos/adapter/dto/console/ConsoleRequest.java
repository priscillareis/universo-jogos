package com.projeto.universojogos.adapter.dto.console;

import com.projeto.universojogos.adapter.config.validation.ValidacaoCadastro;
import com.projeto.universojogos.adapter.dto.plataforma.PlataformaRequest;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConsoleRequest {
    private int id;

    @NotBlank(groups = {ValidacaoCadastro.class},
              message = "Nome do console é obrigatório")
    private String nome;

    @Max(value = 4)
    private String anoLancamento;

    @NotNull(groups = {ValidacaoCadastro.class},
              message="Plataforma do console é obrigatório")
    private PlataformaRequest plataforma;
}

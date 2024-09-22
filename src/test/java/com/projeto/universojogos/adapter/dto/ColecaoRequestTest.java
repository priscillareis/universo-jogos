package com.projeto.universojogos.adapter.dto;

import com.projeto.universojogos.adapter.config.validation.ValidacaoAtualizacao;
import com.projeto.universojogos.adapter.config.validation.ValidacaoCadastro;
import com.projeto.universojogos.adapter.config.validation.ValidacaoConsulta;
import com.projeto.universojogos.adapter.dto.colecao.ColecaoRequest;
import com.projeto.universojogos.adapter.dto.console.ConsoleRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ColecaoRequestTest {

    private static Validator validator;

    private static final ConsoleRequest consolePlay1 = new ConsoleRequest().setId(1);
    private static final ConsoleRequest consoleXbox360 = new ConsoleRequest().setId(2);
    private static final ConsoleRequest consoleNintendoWii = new ConsoleRequest().setId(3);

    @BeforeAll
    public static void setupValidatorInstance() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @DisplayName("Adapter * Deve validar as requests da ColecaoRequest")
    @ParameterizedTest(name = "{4}")
    @MethodSource("getColecaoRequest")
    public void validacaoObjetoConsoleRequest(ColecaoRequest colecaoRequest, int quantidadeErrosEsperados,
                                              Class classe, List<String> camposViolados, String cenario){
        Set<ConstraintViolation<ColecaoRequest>> violations =  validator.validate(colecaoRequest,
                classe);

        if(camposViolados.isEmpty()){
            assertAll(
                    () -> assertNotNull(colecaoRequest),
                    () -> assertThat(violations.size()).isEqualTo(quantidadeErrosEsperados)
            );
        }else{
            assertThat(violations.size()).isEqualTo(quantidadeErrosEsperados);

            violations.forEach(violation ->
                    assertTrue(camposViolados.contains(violation.getPropertyPath().toString())));
        }
    }

    public static Collection<Object[]> getColecaoRequest(){
        return Arrays.asList(new Object[][]{
                {new ColecaoRequest(1, "01/01/2020", BigDecimal.valueOf(300), consolePlay1), 0,
                        ValidacaoCadastro.class, List.of(), "Deve criar a request com sucesso"},
                {new ColecaoRequest(6, "",null, null), 1,
                        ValidacaoCadastro.class, List.of("console"),
                        "Deve ter violações ao tentar criar request de cadastro sem console"},
                {new ColecaoRequest(2, null,null, consoleXbox360), 0,
                        ValidacaoCadastro.class, List.of( ),
                        "Deve criar a request com sucesso, sem data aquisicao e valor aquisicao"},

                {new ColecaoRequest(7, null,null,null), 0,
                        ValidacaoConsulta.class, List.of(), "Deve criar a request de consulta com sucesso"},
                {new ColecaoRequest(0, null,null,consoleNintendoWii), 1,
                        ValidacaoConsulta.class, List.of("id"),
                        "Deve ter violações ao tentar criar request de consulta sem id"},

                {new ColecaoRequest(11, "10/01/2020",BigDecimal.valueOf(300),consoleXbox360), 0,
                        ValidacaoAtualizacao.class, List.of(), "Deve criar a request de atualizar com sucesso"},
        });

    }
}

package com.projeto.universojogos.adapter.dto;

import com.projeto.universojogos.adapter.config.validation.*;
import com.projeto.universojogos.adapter.dto.console.ConsoleRequest;
import com.projeto.universojogos.adapter.dto.plataforma.PlataformaRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ConsoleRequestTest {
    private static Validator validator;

    private static final PlataformaRequest plataformaSony = new PlataformaRequest().setId(1);
    private static final PlataformaRequest plataformaXbox = new PlataformaRequest().setId(2);
    private static final PlataformaRequest plataformaNintendo = new PlataformaRequest().setId(3);

    @BeforeAll
    public static void setupValidatorInstance() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @DisplayName("Adapter * Deve validar as requests da ConsoleRequest")
    @ParameterizedTest(name = "{4}")
    @MethodSource("getConsoleRequest")
    public void validacaoObjetoConsoleRequest(ConsoleRequest consoleRequest, int quantidadeErrosEsperados,
                                              Class classe, List<String> camposViolados, String cenario){
        Set<ConstraintViolation<ConsoleRequest>> violations =  validator.validate(consoleRequest,
                classe);

        if(camposViolados.isEmpty()){
            assertAll(
                    () -> assertNotNull(consoleRequest),
                    () -> assertThat(violations.size()).isEqualTo(quantidadeErrosEsperados)
            );
        }else{
            assertThat(violations.size()).isEqualTo(quantidadeErrosEsperados);

            violations.forEach(violation ->
                    assertTrue(camposViolados.contains(violation.getPropertyPath().toString())));
        }
    }

    public static Collection<Object[]> getConsoleRequest(){
        return Arrays.asList(new Object[][]{
                {new ConsoleRequest(1, "Play1", "1997", plataformaSony), 0,
                        ValidacaoCadastro.class, List.of(), "Deve criar a request com sucesso"},
                {new ConsoleRequest(6, "","", null), 2,
                        ValidacaoCadastro.class, List.of("nome", "plataforma"),
                        "Deve ter violações ao tentar criar request de cadastro sem nome, plataforma"},
                {new ConsoleRequest(2, "Play 1","", null), 1,
                        ValidacaoCadastro.class, List.of( "plataforma"),
                        "Deve ter violações ao tentar criar request de cadastro sem plataforma"},
                {new ConsoleRequest(3, "","", plataformaSony), 1,
                        ValidacaoCadastro.class, List.of("nome"),
                        "Deve ter violações ao tentar criar request de cadastro sem nome"},

                {new ConsoleRequest(7, "","",null), 0,
                        ValidacaoConsulta.class, List.of(), "Deve criar a request de consulta com sucesso"},
                {new ConsoleRequest(0, "","",plataformaXbox), 1,
                        ValidacaoConsulta.class, List.of("id"),
                        "Deve ter violações ao tentar criar request de consulta sem id"},

                {new ConsoleRequest(11, "Switch","",plataformaNintendo), 0,
                        ValidacaoAtualizacao.class, List.of(), "Deve criar a request de atualizar com sucesso"},
                {new ConsoleRequest().setId(11).setNome("Switch").setAnoLancamento("1")
                        .setPlataforma(plataformaNintendo),
                        1, ValidacaoAtualizacao.class, List.of("anoLancamento"),
                        "Deve ter violações ao tentar criar request de atualizacao com ano lancamento invalido"},
        });

    }
}

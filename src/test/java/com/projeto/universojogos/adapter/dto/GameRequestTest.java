package com.projeto.universojogos.adapter.dto;

import com.projeto.universojogos.adapter.config.validation.*;
import com.projeto.universojogos.adapter.dto.console.ConsoleRequest;
import com.projeto.universojogos.adapter.dto.desenvolvedora.DesenvolvedoraRequest;
import com.projeto.universojogos.adapter.dto.game.GameRequest;
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
public class GameRequestTest {
    private static Validator validator;

    private static final ConsoleRequest consolePlay1 = new ConsoleRequest().setId(1);
    private static final ConsoleRequest consoleXbox360 = new ConsoleRequest().setId(2);
    private static final ConsoleRequest consoleNintendoWii = new ConsoleRequest().setId(3);
    private static final DesenvolvedoraRequest desenvolvedoraFreak = new DesenvolvedoraRequest().setId(1);
    private static final DesenvolvedoraRequest desenvolvedoraMonica = new DesenvolvedoraRequest().setId(2);

    @BeforeAll
    public static void setupValidatorInstance() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @DisplayName("Adapter * Deve validar as requests da ConsoleRequest")
    @ParameterizedTest(name = "{4}")
    @MethodSource("getConsoleRequest")
    public void validacaoObjetoConsoleRequest(GameRequest gameRequest, int quantidadeErrosEsperados,
                                              Class classe, List<String> camposViolados, String cenario){
        Set<ConstraintViolation<GameRequest>> violations =  validator.validate(gameRequest,
                classe);

        if(camposViolados.isEmpty()){
            assertAll(
                    () -> assertNotNull(gameRequest),
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
                {new GameRequest(1, "God of War", "2014", null,null,consolePlay1,desenvolvedoraMonica), 0,
                        ValidacaoCadastro.class, List.of(), "Deve criar a request com sucesso"},
                {new GameRequest(6, "","", null,null,null, null), 2,
                        ValidacaoCadastro.class, List.of("nome", "console"),
                        "Deve ter violações ao tentar criar request de cadastro sem nome, console"},
                {new GameRequest(2, "God of War","", null,null,null, null), 1,
                        ValidacaoCadastro.class, List.of( "console"),
                        "Deve ter violações ao tentar criar request de cadastro sem console"},
                {new GameRequest(3, "","",null,null, consolePlay1,desenvolvedoraMonica), 1,
                        ValidacaoCadastro.class, List.of("nome"),
                        "Deve ter violações ao tentar criar request de cadastro sem nome"},

                {new GameRequest(7, "","",null,null,null,null), 0,
                        ValidacaoConsulta.class, List.of(), "Deve criar a request de consulta com sucesso"},
                {new GameRequest(0, "","",null,null,consoleXbox360,desenvolvedoraMonica), 1,
                        ValidacaoConsulta.class, List.of("id"),
                        "Deve ter violações ao tentar criar request de consulta sem id"},

                {new GameRequest(11, "Pokemon Yellow","",null,null,consoleNintendoWii,desenvolvedoraFreak),
                        0, ValidacaoAtualizacao.class, List.of(), "Deve criar a request de atualizar com sucesso"},
                {new GameRequest().setId(11).setNome("Switch").setAnoLancamento("1").setConsole(consoleNintendoWii)
                        .setDesenvolvedora(desenvolvedoraFreak),
                        1, ValidacaoAtualizacao.class, List.of("anoLancamento"),
                        "Deve ter violações ao tentar criar request de atualizacao com ano lancamento invalido"},
        });


    }
}

package com.projeto.universojogos.application.service;

import com.projeto.universojogos.application.port.outbound.PlataformaOutbound;
import com.projeto.universojogos.core.domain.Plataforma;
import com.projeto.universojogos.core.exception.*;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PlataformaServiceTest {

    @InjectMocks
    private PlataformaService plataformaService;

    @Mock
    PlataformaOutbound plataformaOutbound;

    Plataforma plataformaCadastroRequest = new Plataforma(null,"Nintendo");
    Plataforma plataformaConsultaRequest = new Plataforma(12,null);
    Plataforma plataformaAtualizarRequest = new Plataforma(24,"Sony");

    @DisplayName("Application * Deve cadastrar plataforma com sucesso")
    @Test
    public void cadastrarPlataformaComSucesso() throws Exception {
        Plataforma plataforma = new Plataforma(10, "Nintendo");

        when(plataformaOutbound.salvar(any())).thenReturn(plataforma);

        var resultado = plataformaService.cadastrar(plataformaCadastroRequest);

        assertAll("cadastrar-plataforma-sucesso",
                () -> assertEquals(plataforma.getId(), resultado.getId()),
                () -> assertEquals(plataformaCadastroRequest.getNome(), resultado.getNome())
        );
    }

    @DisplayName("Application * Deve dar erro ao tentar cadastrar plataforma com domain nulo")
    @Test
    public void cadastrarPlataformaNula(){
        assertThrows(ParametroInvalidoException.class, () -> plataformaService.cadastrar(null));
    }

    @DisplayName("Application * Deve cadastrar plataforma informando id")
    @Test
    public void cadastrarPlataformaComId() throws Exception {
        Plataforma plataforma = new Plataforma(11, "Nintendo");

        when(plataformaOutbound.salvar(any())).thenReturn(plataforma);

        var resultado = plataformaService.cadastrar(plataforma);

        assertAll("cadastrar-plataforma-sucesso-id",
                () -> assertEquals(plataforma.getId(), resultado.getId()),
                () -> assertEquals(plataformaCadastroRequest.getNome(), resultado.getNome())
        );
    }

    @DisplayName("Application * Deve consultar plataforma com sucesso")
    @Test
    public void consultarPlataformaComSucesso() throws Exception {
        Plataforma plataforma = new Plataforma(12, "Nintendo");

        when(plataformaOutbound.consultarPorId(any())).thenReturn(plataforma);

        var resultado = plataformaService.consultarPorId(plataformaConsultaRequest);

        assertAll("consultar-plataforma-sucesso",
                () -> assertEquals(plataforma.getId(), resultado.getId()),
                () -> assertEquals(plataforma.getNome(), resultado.getNome())
        );
    }

    @DisplayName("Application * Deve dar erro ao consultar plataforma com domain nulo")
    @Test
    public void consultarPlataformaNula(){
        assertThrows(ParametroInvalidoException.class, () -> plataformaService.consultarPorId(null));
    }

    @DisplayName("Application * Deve consultar plataforma com o id, ignorando nome")
    @Test
    public void consultarPlataformaComNome() throws Exception {
        Plataforma plataforma = new Plataforma(13, "Nintendo");

        when(plataformaOutbound.consultarPorId(any())).thenReturn(plataforma);

        var resultado = plataformaService.consultarPorId(plataforma);

        assertAll("consultar-plataforma-sucesso-nome",
                () -> assertEquals(plataforma.getId(), resultado.getId()),
                () -> assertEquals(plataformaCadastroRequest.getNome(), resultado.getNome())
        );
    }

    @DisplayName("Application * Deve atualizar plataforma com sucesso")
    @Test
    public void atualizarPlataformaComSucesso() throws Exception {
        Plataforma plataformaMock = new Plataforma(24, "Sony");

        when(plataformaOutbound.consultarPorId(any())).thenReturn(plataformaMock);

        var resultado = plataformaService.consultarPorId(plataformaAtualizarRequest);

        assertAll("consultar-plataforma-sucesso",
                () -> assertEquals(plataformaMock.getId(), resultado.getId()),
                () -> assertEquals(plataformaMock.getNome(), resultado.getNome())
        );
    }

    @DisplayName("Application * Deve dar erro ao atualizar plataforma com domain nulo")
    @Test
    public void atualizarPlataformaNula(){
        assertThrows(ParametroInvalidoException.class, () -> plataformaService.atualizar(null));
    }
}

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

    @DisplayName("Application * Cadastrar plataforma com sucesso")
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

    @DisplayName("Application * Cadastrar plataforma com domain nulo")
    @Test
    public void cadastrarPlataformaNula(){
        assertThrows(ParametroInvalidoException.class, () -> plataformaService.cadastrar(null));
    }

    @DisplayName("Application * Cadastrar plataforma informando id")
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

    @DisplayName("Application * Consultar plataforma com sucesso")
    @Test
    public void consultarPlataformaComSucesso() throws Exception {
        Plataforma plataforma = new Plataforma(12, "Nintendo");

        when(plataformaOutbound.consultar(any())).thenReturn(plataforma);

        var resultado = plataformaService.consultar(plataformaConsultaRequest);

        assertAll("consultar-plataforma-sucesso",
                () -> assertEquals(plataforma.getId(), resultado.getId()),
                () -> assertEquals(plataforma.getNome(), resultado.getNome())
        );
    }

    @DisplayName("Application * Consultar plataforma com domain nulo")
    @Test
    public void consultarPlataformaNula(){
        assertThrows(ParametroInvalidoException.class, () -> plataformaService.consultar(null));
    }

    @DisplayName("Application * Consultar plataforma informando nome")
    @Test
    public void consultarPlataformaComNome() throws Exception {
        Plataforma plataforma = new Plataforma(13, "Nintendo");

        when(plataformaOutbound.consultar(any())).thenReturn(plataforma);

        var resultado = plataformaService.consultar(plataforma);

        assertAll("consultar-plataforma-sucesso-nome",
                () -> assertEquals(plataforma.getId(), resultado.getId()),
                () -> assertEquals(plataformaCadastroRequest.getNome(), resultado.getNome())
        );
    }
}

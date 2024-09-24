package org.example.classeLivro;

import org.example.estados.LivroEstadoEmAnalise;
import org.example.estados.LivroEstadoEmRevisao;
import org.example.estados.LivroEstadoPostado;
import org.example.estados.LivroEstadoRejeitado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LivroTest {

    Livro livro;

    @BeforeEach
    public void setUp() {
        livro = new Livro();
    }

    // Testes para o estado Em Análise
    @Test
    public void devePostarLivroEmAnalise() {
        livro.setEstado(LivroEstadoEmAnalise.getInstance());
        assertTrue(livro.postar());
    }

    @Test
    public void deveRejeitarLivroEmAnalise() {
        livro.setEstado(LivroEstadoEmAnalise.getInstance());
        assertTrue(livro.rejeitar());
        assertEquals(LivroEstadoRejeitado.getInstance(), livro.getEstado());
    }

    @Test
    public void deveEnviarLivroParaRevisao() {
        livro.setEstado(LivroEstadoEmAnalise.getInstance());
        assertTrue(livro.enviarParaRevisao());
        assertEquals(LivroEstadoEmRevisao.getInstance(), livro.getEstado());
    }

    // Testes para o estado Em Revisão
    @Test
    public void deveVoltarLivroParaAnalise() {
        livro.setEstado(LivroEstadoEmRevisao.getInstance());
        assertTrue(livro.voltarParaAnalise());
        assertEquals(LivroEstadoEmAnalise.getInstance(), livro.getEstado());
    }

    @Test
    public void devePostarLivroEmRevisao() {
        livro.setEstado(LivroEstadoEmRevisao.getInstance());
        assertTrue(livro.postar());
        assertEquals(LivroEstadoPostado.getInstance(), livro.getEstado());
    }

    // Testes para o estado Rejeitado
    @Test
    public void naoDevePostarLivroRejeitado() {
        livro.setEstado(LivroEstadoRejeitado.getInstance());
        assertFalse(livro.postar());
    }

    @Test
    public void naoDeveRejeitarLivroRejeitado() {
        livro.setEstado(LivroEstadoRejeitado.getInstance());
        assertFalse(livro.rejeitar());
    }

    // Testes para o estado Postado
    @Test
    public void naoDeveRejeitarLivroPostado() {
        livro.setEstado(LivroEstadoPostado.getInstance());
        assertFalse(livro.rejeitar());
    }

    @Test
    public void naoDeveEnviarParaRevisaoLivroPostado() {
        livro.setEstado(LivroEstadoPostado.getInstance());
        assertFalse(livro.enviarParaRevisao());
    }
}
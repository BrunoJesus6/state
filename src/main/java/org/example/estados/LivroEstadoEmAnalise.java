package org.example.estados;

import org.example.classeLivro.Livro;
import org.example.classeLivro.LivroEstado;

public class LivroEstadoEmAnalise extends LivroEstado {

    private LivroEstadoEmAnalise() {}
    private static LivroEstadoEmAnalise instance = new LivroEstadoEmAnalise();

    public static LivroEstadoEmAnalise getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Em Análise";
    }

    public boolean postar(Livro livro) {
        livro.setEstado(LivroEstadoPostado.getInstance());
        return true;
    }

    public boolean rejeitar(Livro livro) {
        livro.setEstado(LivroEstadoRejeitado.getInstance());
        return true;
    }

    public boolean enviarParaRevisao(Livro livro) {
        livro.setEstado(LivroEstadoEmRevisao.getInstance());
        return true;
    }
}

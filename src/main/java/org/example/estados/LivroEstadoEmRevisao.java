package org.example.estados;

import org.example.classeLivro.Livro;
import org.example.classeLivro.LivroEstado;

public class LivroEstadoEmRevisao extends LivroEstado {

    private LivroEstadoEmRevisao() {}
    private static LivroEstadoEmRevisao instance = new LivroEstadoEmRevisao();

    public static LivroEstadoEmRevisao getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Em Revisão";
    }

    public boolean postar(Livro livro) {
        livro.setEstado(LivroEstadoPostado.getInstance());
        return true;
    }

    public boolean rejeitar(Livro livro) {
        livro.setEstado(LivroEstadoRejeitado.getInstance());
        return true;
    }

    public boolean voltarParaAnalise(Livro livro) {
        livro.setEstado(LivroEstadoEmAnalise.getInstance());
        return true;
    }
}

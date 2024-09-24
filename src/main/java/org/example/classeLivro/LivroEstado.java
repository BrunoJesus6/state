package org.example.classeLivro;

public abstract class LivroEstado {

    public abstract String getEstado();

    public boolean postar(Livro livro) {
        return false;
    }

    public boolean rejeitar(Livro livro) {
        return false;
    }
}

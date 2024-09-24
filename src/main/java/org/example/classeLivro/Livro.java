package org.example.classeLivro;

import org.example.estados.LivroEstadoEmAnalise;
import org.example.estados.LivroEstadoEmRevisao;

public class Livro {

    private LivroEstado estado;

    public Livro() {
        this.estado = LivroEstadoEmAnalise.getInstance();
    }

    public void setEstado(LivroEstado estado) {
        this.estado = estado;
    }

    public boolean postar() {
        return estado.postar(this);
    }

    public boolean rejeitar() {
        return estado.rejeitar(this);
    }

    public boolean enviarParaRevisao() {
        if (estado instanceof LivroEstadoEmAnalise) {
            return ((LivroEstadoEmAnalise) estado).enviarParaRevisao(this);
        }
        return false;
    }

    public boolean voltarParaAnalise() {
        if (estado instanceof LivroEstadoEmRevisao) {
            return ((LivroEstadoEmRevisao) estado).voltarParaAnalise(this);
        }
        return false;
    }

    public String getNomeEstado() {
        return estado.getEstado();
    }

    public LivroEstado getEstado() {
        return estado;
    }
}

package org.example.estados;

import org.example.classeLivro.LivroEstado;

public class LivroEstadoRejeitado extends LivroEstado {

    private LivroEstadoRejeitado() {}
    private static LivroEstadoRejeitado instance = new LivroEstadoRejeitado();

    public static LivroEstadoRejeitado getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Rejeitado";
    }
}

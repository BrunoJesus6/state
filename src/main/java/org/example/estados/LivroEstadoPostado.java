package org.example.estados;

import org.example.classeLivro.LivroEstado;

public class LivroEstadoPostado extends LivroEstado {

    private LivroEstadoPostado() {}
    private static LivroEstadoPostado instance = new LivroEstadoPostado();

    public static LivroEstadoPostado getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Postado";
    }
}

package com.exemplo;


public class Aluno {

    private String nome;
    private boolean statusMatricula;


    public String getNome() {
        return this.nome;
    }

    public void setNone(String nome) {
        this.nome = nome;
    }

    public boolean getStatusMatricula() {
        return this.statusMatricula;
    }

    public void setStatusMatricula(boolean statusMatricula) {
        this.statusMatricula = statusMatricula;
    }

    public void verificaAlunoMatriculado() throws ValidacaoException {
        if (!this.statusMatricula) {
            throw new ValidacaoException("O aluno " + this.nome + " não está matriculado");
        }
    }

}

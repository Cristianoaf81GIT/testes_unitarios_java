package com.exemplo;

import java.time.LocalDate;

public class Chamada {

    private Aluno aluno;
    private boolean presente;
    private LocalDate data;

    public Aluno getAluno() {
        return this.aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public boolean getPresente() {
        return this.presente;
    }

    public void setPresente(boolean presente) {
        this.presente = presente;
    }

    public LocalDate getData() {
        return this.data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}

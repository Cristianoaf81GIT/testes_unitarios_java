package com.exemplo;

import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

public class ResponderChamadaServiceTest extends TestBase {

    @InjectMocks
    ResponderChamadaService responderChamadaService;

    @Mock
    ChamadaRepository chamadaRepository;

    Aluno aluno;
    Chamada chamada;
    Chamada outraChamada;


    @BeforeEach
    void setUp() {
        this.aluno = new Aluno();
        this.aluno.setNone("cristiano faria");
        this.aluno.setStatusMatricula(true);
        this.chamada = new Chamada();
        this.chamada.setAluno(aluno);
        this.chamada.setPresente(true);
        this.chamada.setData(LocalDate.now());
        this.outraChamada = new Chamada();
        this.outraChamada.setAluno(aluno);
        this.outraChamada.setPresente(true);
        this.outraChamada.setData(LocalDate.now());
    }

    @Test
    @DisplayName("should save chamada:")
    void salvarChamada() throws ValidacaoException {
        try {
            Mockito.when(responderChamadaService.apply(chamada)).thenReturn(outraChamada);
            var result = responderChamadaService.apply(chamada);
            Mockito.verify(chamadaRepository).salvar(chamada);
            Assertions.assertEquals(result.getData(), outraChamada.getData());
        } catch(ValidacaoException e) {
            throw e;
        }
    }

    @Test
    @DisplayName("should throw an exception ValidacaoException if aluno is getStatusMatricula is false")
    void verificaAlunoMatriculado() {
        this.aluno.setNone("chad");
        this.aluno.setStatusMatricula(false);
        var result = Assertions.assertThrows(ValidacaoException.class, () -> responderChamadaService.apply(chamada)); 
        var message = "O aluno " + this.aluno.getNome() + " não está matriculado";
        Assertions.assertEquals(message, result.getMessage());
    }

}

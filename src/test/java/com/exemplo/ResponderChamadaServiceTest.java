package com.exemplo;

import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
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

    @Test
    @DisplayName("should save chamada:")
    void salvarChamada() {
        var aluno = new Aluno();
        aluno.setNone("cristiano faria");
        aluno.setStatusMatricula(true);
        var chamada = new Chamada();
        chamada.setAluno(aluno);
        chamada.setPresente(true);
        chamada.setData(LocalDate.now());
        var outraChamada = new Chamada();
        outraChamada.setAluno(aluno);
        outraChamada.setPresente(true);
        outraChamada.setData(LocalDate.now());
        Mockito.when(responderChamadaService.apply(chamada)).thenReturn(outraChamada);
        var result = responderChamadaService.apply(chamada);
        Mockito.verify(chamadaRepository).salvar(chamada);
        Assertions.assertEquals(result.getData(), outraChamada.getData());
    }

}

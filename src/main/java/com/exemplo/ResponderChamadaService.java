package com.exemplo;


public class ResponderChamadaService {

    private ChamadaRepository chamadaRepository;


    public ResponderChamadaService(ChamadaRepository chamadaRepository) {
        this.chamadaRepository = chamadaRepository;
    }

    public Chamada apply(Chamada chamada) {
        var chamadaSalva = this.chamadaRepository.salvar(chamada);
        return chamadaSalva;
    }

}

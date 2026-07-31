package com.github.fernvndomatos.CadastroDeJogadores.Clubes;

import org.springframework.stereotype.Component;

@Component
public class ClubeMapper {

    public ClubeModel map(ClubeDTO clubeDTO){

        ClubeModel clubeModel = new ClubeModel();
        clubeModel.setId(clubeDTO.getId());
        clubeModel.setNomeDoClube(clubeDTO.getNomeDoClube());
        clubeModel.setCidade(clubeDTO.getCidade());
        clubeModel.setPais(clubeDTO.getPais());

        return clubeModel;
    }

    public ClubeDTO map(ClubeModel clubeModel){

        ClubeDTO clubeDTO = new ClubeDTO();
        clubeDTO.setId(clubeModel.getId());
        clubeDTO.setNomeDoClube(clubeModel.getNomeDoClube());
        clubeDTO.setCidade(clubeModel.getCidade());
        clubeDTO.setPais(clubeModel.getPais());

        return clubeDTO;
    }
}

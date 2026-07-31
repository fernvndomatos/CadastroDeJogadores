package com.github.fernvndomatos.CadastroDeJogadores.Jogadores;

import com.github.fernvndomatos.CadastroDeJogadores.Clubes.ClubeMapper;
import org.springframework.stereotype.Component;

@Component
public class JogadorMapper {

    private ClubeMapper clubeMapper;

    public JogadorMapper(ClubeMapper clubeMapper) {
        this.clubeMapper = clubeMapper;
    }

    public JogadorModel map(JogadorDTO jogadorDTO){

        JogadorModel jogadorModel = new JogadorModel();
        jogadorModel.setId(jogadorDTO.getId());
        jogadorModel.setNome(jogadorDTO.getNome());
        jogadorModel.setIdade(jogadorDTO.getIdade());
        jogadorModel.setPosicao(jogadorDTO.getPosicao());
        jogadorModel.setNumeroCamisa(jogadorDTO.getNumeroCamisa());

        if (jogadorDTO.getClube() != null) {
            jogadorModel.setClube(clubeMapper.map(jogadorDTO.getClube()));
        }
        return jogadorModel;
    }

    public JogadorDTO map(JogadorModel jogadorModel) {

        JogadorDTO jogadorDTO = new JogadorDTO();
        jogadorDTO.setId(jogadorModel.getId());
        jogadorDTO.setNome(jogadorModel.getNome());
        jogadorDTO.setIdade(jogadorModel.getIdade());
        jogadorDTO.setPosicao(jogadorModel.getPosicao());
        jogadorDTO.setNumeroCamisa(jogadorModel.getNumeroCamisa());

        if (jogadorModel.getClube() != null) {
            jogadorDTO.setClube(clubeMapper.map(jogadorModel.getClube()));
        }

        return jogadorDTO;
    }
}

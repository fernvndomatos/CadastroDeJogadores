package com.github.fernvndomatos.CadastroDeJogadores.Clubes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClubeService {

    private ClubeRepository clubeRepository;
    private ClubeMapper clubeMapper;

    public ClubeService(ClubeRepository clubeRepository, ClubeMapper clubeMapper) {
        this.clubeRepository = clubeRepository;
        this.clubeMapper = clubeMapper;
    }

    //Listar clubes
    public List<ClubeDTO> listarClubes(){
        List<ClubeModel> clubes = clubeRepository.findAll();
        return clubes.stream()
                .map(clubeMapper::map)
                .collect(Collectors.toList());
    }

    //Listar cluber por id
    public ClubeDTO listarClubePorId(Long id){
        Optional<ClubeModel> clubeModel = clubeRepository.findById(id);
        return clubeModel.map(clubeMapper::map).orElse(null);
    }

    //Criar novo clube
    public ClubeDTO criarClube(ClubeDTO clubeDTO){
        ClubeModel clubeModel = clubeMapper.map(clubeDTO);
        clubeModel = clubeRepository.save(clubeModel);
        return clubeMapper.map(clubeModel);
    }

    //Deletar um clube
    public void deletarClubePorId(Long id){
        if (!clubeRepository.existsById(id)){
            throw new RuntimeException("Clube não encontrado!");
        }
        clubeRepository.deleteById(id);
    }

    //Atualizar clube
    public ClubeDTO atualizarClube(Long id, ClubeDTO clubeDTO){
        Optional<ClubeModel> clubeAtual = clubeRepository.findById(id);
        if(clubeAtual.isPresent()){
            ClubeModel clubeNovo = clubeMapper.map(clubeDTO);
            clubeNovo.setId(id);
            ClubeModel clubeSalvo = clubeRepository.save(clubeNovo);
            return clubeMapper.map(clubeSalvo);
        }
        return null;
    }

}

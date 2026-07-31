package com.github.fernvndomatos.CadastroDeJogadores.Jogadores;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JogadorService {

    private JogadorRepository jogadorRepository;
    private JogadorMapper jogadorMapper;

    public JogadorService(JogadorRepository jogadorRepository, JogadorMapper jogadorMapper) {
        this.jogadorRepository = jogadorRepository;
        this.jogadorMapper = jogadorMapper;
    }

    //Listar todos os Jogadores
    public List<JogadorDTO> listarJogadores(){
        List<JogadorModel> jogadores = jogadorRepository.findAll();
        return jogadores.stream()
                .map(jogadorMapper::map)
                .collect(Collectors.toList());
    }

    //Listar jogadores por id
    public JogadorDTO listarJogadorPorId(Long id){
        Optional<JogadorModel> jogadorModel = jogadorRepository.findById(id);
        return jogadorModel.map(jogadorMapper::map).orElse(null);
    }

    //Criar novo jogador
    public JogadorDTO criarJogador(JogadorDTO jogadorDTO){
        JogadorModel jogadorModel = jogadorMapper.map(jogadorDTO);
        jogadorModel = jogadorRepository.save(jogadorModel);
        return jogadorMapper.map(jogadorModel);
    }

    //Deletar um jogador
    public void deletarJogadorPorId(Long id){
        if (!jogadorRepository.existsById(id)){
            throw new RuntimeException("Jogador não encontrado!");
        }
        jogadorRepository.deleteById(id);
    }

    //Atualizar jogador
    public JogadorDTO atualizarJogador(Long id, JogadorDTO jogadorDTO){
        Optional<JogadorModel> jogadorAtual = jogadorRepository.findById(id);
        if(jogadorAtual.isPresent()){
            JogadorModel jogadorNovo = jogadorMapper.map(jogadorDTO);
            jogadorNovo.setId(id);
            JogadorModel jogadorSalvo = jogadorRepository.save(jogadorNovo);
            return jogadorMapper.map(jogadorSalvo);
        }
        return null;
    }

}

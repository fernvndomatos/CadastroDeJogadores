package com.github.fernvndomatos.CadastroDeJogadores.Jogadores;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    private JogadorService jogadorService;

    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    //GET
    @GetMapping("/listar")
    public ResponseEntity <List<JogadorDTO>> listarJogadores(){
        List<JogadorDTO> jogadores = jogadorService.listarJogadores();
        return ResponseEntity.ok(jogadores);
    }

    //GET(por id)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarJogadorPorId(@PathVariable Long id){
        JogadorDTO jogadorDTO = jogadorService.listarJogadorPorId(id);
        if(jogadorDTO != null){
            return ResponseEntity.ok(jogadorDTO);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Jogador com id " + id + " não existe nos nosso registros!");
        }
    }

    //POST
    @PostMapping("/criar")
    public ResponseEntity<String> criarJogador(@RequestBody JogadorDTO jogadorDTO){
        JogadorDTO jogadorNovo = jogadorService.criarJogador(jogadorDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Jogador cadastrado com sucesso: " + jogadorNovo.getNome() + " (ID): " + jogadorNovo.getId());
    }

    //DELETE
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarPorId(@PathVariable Long id){

        if (jogadorService.listarJogadorPorId(id) != null){
            jogadorService.deletarJogadorPorId(id);
            return ResponseEntity.ok("Jogador com o ID " + id +" deletado com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Jogador com id " + id + " não encontrado!");

        }
    }

    //PUT
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> atualizarJogador(@PathVariable Long id, @RequestBody JogadorDTO jogadorDTO){

        JogadorDTO jogadorNovo = jogadorService.atualizarJogador(id, jogadorDTO);
        if (jogadorNovo != null){
            return ResponseEntity.ok(jogadorNovo);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Jogador com id " + id + " não existe nos nosso registros!");
        }
    }
}

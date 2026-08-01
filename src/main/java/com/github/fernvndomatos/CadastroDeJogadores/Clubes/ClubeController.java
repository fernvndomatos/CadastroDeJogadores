package com.github.fernvndomatos.CadastroDeJogadores.Clubes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clubes")
public class ClubeController {
    
    private ClubeService clubeService;

    public ClubeController(ClubeService clubeService) {
        this.clubeService = clubeService;
    }

    //GET
    @GetMapping("/listar")
    public ResponseEntity<List<ClubeDTO>> listarClubes(){
        List<ClubeDTO> clubes = clubeService.listarClubes();
        return ResponseEntity.ok(clubes);
    }

    //GET(por id)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarClubePorId(@PathVariable Long id){
        ClubeDTO clubeDTO = clubeService.listarClubePorId(id);
        if(clubeDTO != null){
            return ResponseEntity.ok(clubeDTO);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Clube com id " + id + " não existe nos nosso registros!");
        }
    }

    //POST
    @PostMapping("/criar")
    public ResponseEntity<String> criarClube(@RequestBody ClubeDTO clubeDTO){
        ClubeDTO clubeNovo = clubeService.criarClube(clubeDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Clube cadastrado com sucesso: " + clubeNovo.getNomeDoClube() + " (ID): " + clubeNovo.getId());
    }

    //DELETE
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarPorId(@PathVariable Long id){

        if (clubeService.listarClubePorId(id) != null){
            clubeService.deletarClubePorId(id);
            return ResponseEntity.ok("Clube com o ID " + id +" deletado com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Clube com id " + id + " não encontrado!");

        }
    }

    //PUT
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> atualizarClube(@PathVariable Long id, @RequestBody ClubeDTO clubeDTO){

        ClubeDTO clubeNovo = clubeService.atualizarClube(id, clubeDTO);
        if (clubeNovo != null){
            return ResponseEntity.ok(clubeNovo);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Clube com id " + id + " não existe nos nosso registros!");
        }
    }
}

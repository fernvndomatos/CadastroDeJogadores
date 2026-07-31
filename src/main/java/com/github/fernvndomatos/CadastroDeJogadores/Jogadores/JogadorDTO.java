package com.github.fernvndomatos.CadastroDeJogadores.Jogadores;
import com.github.fernvndomatos.CadastroDeJogadores.Clubes.ClubeDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class JogadorDTO {

    private Long id;
    private String nome;
    private Integer idade;
    private PosicaoEnum posicao;
    private Integer numeroCamisa;
    private ClubeDTO clube;
}

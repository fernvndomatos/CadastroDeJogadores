package com.github.fernvndomatos.CadastroDeJogadores.Jogadores;

import com.github.fernvndomatos.CadastroDeJogadores.Clubes.ClubeModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_jogadores")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JogadorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "idade")
    private Integer idade;

    @Column(name = "posicao")
    @Enumerated(EnumType.STRING)
    private PosicaoEnum posicao;

    @Column(name = "numero_camisa")
    private Integer numeroCamisa;

    @ManyToOne
    @JoinColumn(name = "clube_id")
    private ClubeModel clube;

}

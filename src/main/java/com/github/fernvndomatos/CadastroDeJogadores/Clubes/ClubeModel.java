package com.github.fernvndomatos.CadastroDeJogadores.Clubes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.fernvndomatos.CadastroDeJogadores.Jogadores.JogadorModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_clubes")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClubeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_clube")
    private String nomeDoClube;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "pais")
    private String pais;

    @Column(name = "ano_fundacao")
    private Integer anoFundacao;

    @OneToMany(mappedBy = "clube")
    @JsonIgnore
    private List<JogadorModel> jogadores;
}

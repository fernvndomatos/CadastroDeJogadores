package com.github.fernvndomatos.CadastroDeJogadores.Clubes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClubeDTO {

    private Long id;
    private String nomeDoClube;
    private String cidade;
    private String pais;
}

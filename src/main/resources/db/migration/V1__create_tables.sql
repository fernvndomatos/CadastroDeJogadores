CREATE TABLE tb_clubes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome_clube VARCHAR(100) NOT NULL,
    cidade VARCHAR(100),
    pais VARCHAR(100)
);

CREATE TABLE tb_jogadores (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    idade INTEGER,
    posicao VARCHAR(30),
    numero_camisa INTEGER,
    clube_id BIGINT,
    CONSTRAINT fk_jogador_clube FOREIGN KEY (clube_id) REFERENCES tb_clubes(id)
);
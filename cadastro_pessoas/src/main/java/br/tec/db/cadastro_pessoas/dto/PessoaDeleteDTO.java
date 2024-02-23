package br.tec.db.cadastro_pessoas.dto;

import br.tec.db.cadastro_pessoas.model.Pessoa;

public record PessoaDeleteDTO(String nome, Boolean ativado) {
    public PessoaDeleteDTO(Pessoa pessoa){
        this(pessoa.getNome(), pessoa.getAtivado());
    }
}

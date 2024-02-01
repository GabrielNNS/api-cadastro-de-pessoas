package br.tec.db.cadastro_pessoas.pessoa;


import br.tec.db.cadastro_pessoas.endereco.Endereco;

import java.util.List;

public record PessoaResponseDTO(String nome, String dataNascimento, List<Endereco> endereco) {

    public PessoaResponseDTO(Pessoa pessoa) {
        this(pessoa.getNome(), pessoa.getDataNascimento(), pessoa.getEndereco());
    }
}

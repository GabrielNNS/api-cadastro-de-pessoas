package br.tec.db.cadastro_pessoas.pessoa;

import br.tec.db.cadastro_pessoas.endereco.Endereco;

import java.util.List;

public record PessoaEnderecosDTO(String nome, List<Endereco> enderecos) {

    public PessoaEnderecosDTO(Pessoa pessoa) {
        this(pessoa.getNome(), pessoa.getEndereco());
    }
}

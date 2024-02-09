package br.tec.db.cadastro_pessoas.dto;

import br.tec.db.cadastro_pessoas.model.Pessoa;

import java.util.List;

public record PessoaEnderecosDTO(String nome, List<EnderecoResponseDTO> enderecos) {

    public PessoaEnderecosDTO(Pessoa pessoa) {
        this(pessoa.getNome(), pessoa.getEndereco());
    }
}

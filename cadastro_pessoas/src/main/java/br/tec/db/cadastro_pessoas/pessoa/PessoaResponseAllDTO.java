package br.tec.db.cadastro_pessoas.pessoa;


import br.tec.db.cadastro_pessoas.endereco.Endereco;

import java.util.Comparator;
import java.util.List;

public record PessoaResponseDTO(Long id, String nome, String dataNascimento, List<Endereco> endereco) {

    public PessoaResponseDTO(Pessoa pessoa) {
        this(pessoa.getId(), pessoa.getNome(), pessoa.getDataNascimento(), pessoa.getEndereco());
    }
}

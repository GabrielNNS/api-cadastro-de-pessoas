package br.tec.db.cadastro_pessoas.dto;


import br.tec.db.cadastro_pessoas.model.Pessoa;
import java.util.List;

public record PessoaResponseDTO(Long id, String nome, String dataNascimento, List<EnderecoResponseDTO> endereco) {

    public PessoaResponseDTO(Pessoa pessoa) {
        this(pessoa.getId(), pessoa.getNome(), pessoa.getDataNascimento(), pessoa.getEndereco());
    }
}

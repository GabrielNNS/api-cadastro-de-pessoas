package br.tec.db.cadastro_pessoas.dto;

import br.tec.db.cadastro_pessoas.model.Pessoa;
import jakarta.validation.constraints.NotBlank;

public record PessoaUpdateDTO(
        @NotBlank
        String nome) {
        public PessoaUpdateDTO(Pessoa pessoa) {
                this(pessoa.getNome());
        }
}

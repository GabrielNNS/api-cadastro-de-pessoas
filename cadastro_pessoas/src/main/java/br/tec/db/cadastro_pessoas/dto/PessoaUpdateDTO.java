package br.tec.db.cadastro_pessoas.dto;

import br.tec.db.cadastro_pessoas.model.Endereco;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record PessoaUpdateDTO(
        @NotBlank
        String nome,

        List<Endereco> endereco) {
}

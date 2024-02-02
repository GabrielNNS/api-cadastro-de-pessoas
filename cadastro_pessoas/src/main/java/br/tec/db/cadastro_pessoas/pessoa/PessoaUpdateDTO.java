package br.tec.db.cadastro_pessoas.pessoa;

import br.tec.db.cadastro_pessoas.endereco.Endereco;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record PessoaUpdateDTO(
        @NotBlank
        String nome,

        List<Endereco> endereco) {
}

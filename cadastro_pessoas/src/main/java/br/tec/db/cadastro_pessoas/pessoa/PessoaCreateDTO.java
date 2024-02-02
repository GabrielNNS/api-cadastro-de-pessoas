package br.tec.db.cadastro_pessoas.pessoa;

import br.tec.db.cadastro_pessoas.endereco.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record PessoaCreateDTO(
        @NotBlank
        String nome,
        @NotNull
        String dataNascimento,

        List<Endereco> endereco) {
}

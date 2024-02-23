package br.tec.db.cadastro_pessoas.dto;

import jakarta.validation.constraints.NotBlank;

public record PessoaUpdateDTO(
        @NotBlank
        String nome) {
}

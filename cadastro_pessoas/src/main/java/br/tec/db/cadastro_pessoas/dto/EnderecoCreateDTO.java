package br.tec.db.cadastro_pessoas.dto;

import br.tec.db.cadastro_pessoas.model.Endereco;
import br.tec.db.cadastro_pessoas.model.Pessoa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EnderecoCreateDTO(
        @NotBlank
        String logradouro,
        @NotBlank
        String cep,
        @NotBlank
        Integer numero,
        @NotBlank
        String cidade,

        Pessoa pessoa_id,

        @NotNull
        Boolean principal) {


    public EnderecoCreateDTO(Endereco endereco) {
        this(endereco.getLogradouro(), endereco.getCep(), endereco.getNumero(), endereco.getCidade(), endereco.getPessoa_id(), endereco.getPrincipal());
    }
}

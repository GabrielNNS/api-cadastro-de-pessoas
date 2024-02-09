package br.tec.db.cadastro_pessoas.dto;

import br.tec.db.cadastro_pessoas.model.Endereco;

public record EnderecoResponseDTO(Long id, String logradouro, String cep, Integer numero, String cidade, Boolean principal) {

    public EnderecoResponseDTO(Endereco endereco){
        this(endereco.getId(), endereco.getLogradouro(), endereco.getCep(), endereco.getNumero(), endereco.getCidade(), endereco.getPrincipal());
    }
}

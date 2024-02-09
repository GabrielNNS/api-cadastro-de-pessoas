package br.tec.db.cadastro_pessoas.service;

import br.tec.db.cadastro_pessoas.dto.EnderecoCreateDTO;
import br.tec.db.cadastro_pessoas.model.Endereco;
import br.tec.db.cadastro_pessoas.model.Pessoa;
import br.tec.db.cadastro_pessoas.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    public void createEnderecoComPessoa(List<EnderecoCreateDTO> enderecosDTO, Pessoa pessoa){
        for(EnderecoCreateDTO enderecoDTO : enderecosDTO){
            Endereco endereco = new Endereco(enderecoDTO);
            endereco.addPessoa_id(pessoa);
            repository.save(endereco);
        }
    }
}
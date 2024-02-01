package br.tec.db.cadastro_pessoas.pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public List<PessoaResponseDTO> getAllPessoas(){
        return repository.findAll().stream().map(PessoaResponseDTO::new).toList();
    }
}
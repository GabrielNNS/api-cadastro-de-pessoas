package br.tec.db.cadastro_pessoas.service;

import br.tec.db.cadastro_pessoas.dto.PessoaCreateDTO;
import br.tec.db.cadastro_pessoas.dto.PessoaEnderecosDTO;
import br.tec.db.cadastro_pessoas.dto.PessoaResponseDTO;
import br.tec.db.cadastro_pessoas.dto.EnderecoCreateDTO;
import br.tec.db.cadastro_pessoas.model.Pessoa;
import br.tec.db.cadastro_pessoas.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoService enderecoService;

    public List<PessoaResponseDTO> getAllPessoas(){
        return pessoaRepository.findAll().stream().map(PessoaResponseDTO::new).toList();
    }

    public PessoaResponseDTO getPessoaByID(Long id) {
        return new PessoaResponseDTO(pessoaRepository.findById(id).get());
    }

    public PessoaEnderecosDTO getEnderecos(Long id) {
        return new PessoaEnderecosDTO(pessoaRepository.findById(id).get());
    }

    public Pessoa createPessoa(PessoaCreateDTO data){
        Pessoa pessoa = new Pessoa(data);
        if(!data.endereco().isEmpty()){
            List<EnderecoCreateDTO> enderecoDTOList = data.endereco().stream().map(EnderecoCreateDTO::new).toList();
            enderecoService.createEnderecoComPessoa(enderecoDTOList, pessoa);
        }
        pessoaRepository.save(pessoa);
        return pessoa;
    }
}
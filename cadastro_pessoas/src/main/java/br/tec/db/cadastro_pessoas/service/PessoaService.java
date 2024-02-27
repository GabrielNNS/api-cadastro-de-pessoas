package br.tec.db.cadastro_pessoas.service;

import br.tec.db.cadastro_pessoas.dto.*;
import br.tec.db.cadastro_pessoas.exceptions.PessoaNotFoundException;
import br.tec.db.cadastro_pessoas.model.Pessoa;
import br.tec.db.cadastro_pessoas.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoService enderecoService;

    public List<PessoaResponseDTO> getAllPessoas(){
        return pessoaRepository.findAllByAtivadoTrue().stream().map(PessoaResponseDTO::new).toList();
    }

    public PessoaResponseDTO getPessoaByID(Long id) {
        Optional<Pessoa> optionalPessoa = pessoaRepository.findById(id);
        Pessoa pessoa = optionalPessoa.orElseThrow(() -> new PessoaNotFoundException("Pessoa não localizada pela ID " + id));
        return new PessoaResponseDTO(pessoa);
    }

    public PessoaEnderecosDTO getEnderecos(Long id) {
        Optional<Pessoa> optionalPessoa = pessoaRepository.findById(id);
        Pessoa pessoa = optionalPessoa.orElseThrow(() -> new PessoaNotFoundException("Pessoa não localizada pela ID " + id));
        return new PessoaEnderecosDTO(pessoa);
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

    public PessoaDeleteDTO deletePessoaByID(Long id) {
        Pessoa pessoa = pessoaRepository.getReferenceById(id);
        pessoa.deletaOuAtiva();
        return new PessoaDeleteDTO(pessoa);
    }

    public PessoaUpdateDTO updatePessoaByID(PessoaUpdateDTO data, Long id) {
        Pessoa pessoa = pessoaRepository.getReferenceById(id);
        pessoa.update(data);
        return new PessoaUpdateDTO(pessoa);
    }
}
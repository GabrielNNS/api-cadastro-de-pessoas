package br.tec.db.cadastro_pessoas.pessoa;

import br.tec.db.cadastro_pessoas.endereco.Endereco;
import br.tec.db.cadastro_pessoas.endereco.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<PessoaResponseDTO> getAllPessoas(){
        return repository.findAll().stream().map(PessoaResponseDTO::new).toList();
    }

    public PessoaResponseDTO getPessoaByID(Long id) {
        return new PessoaResponseDTO(repository.findById(id).get());
    }

    public PessoaEnderecosDTO getEnderecos(Long id) {
        return new PessoaEnderecosDTO(repository.findById(id).get());
    }

    public Pessoa createPessoa(PessoaCreateDTO data){
        Pessoa pessoa = new Pessoa(data);
        repository.save(pessoa);
        return pessoa;
    }
}
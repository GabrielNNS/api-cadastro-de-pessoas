package br.tec.db.cadastro_pessoas.controller;

import br.tec.db.cadastro_pessoas.dto.PessoaCreateDTO;
import br.tec.db.cadastro_pessoas.dto.PessoaDeleteDTO;
import br.tec.db.cadastro_pessoas.dto.PessoaEnderecosDTO;
import br.tec.db.cadastro_pessoas.model.Pessoa;
import br.tec.db.cadastro_pessoas.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import br.tec.db.cadastro_pessoas.dto.PessoaResponseDTO;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class Controller {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/all")
    public ResponseEntity<List<PessoaResponseDTO>> getPessoas(){
        return ResponseEntity.ok(pessoaService.getAllPessoas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaResponseDTO> getPessoaByID(@PathVariable Long id){
        return ResponseEntity.ok(pessoaService.getPessoaByID(id));
    }

    @GetMapping("/{id}/enderecos")
    public ResponseEntity<PessoaEnderecosDTO> getPessoaEnderecos(@PathVariable Long id){
        return ResponseEntity.ok(pessoaService.getEnderecos(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<PessoaResponseDTO> createPessoa(@RequestBody @Valid PessoaCreateDTO data, UriComponentsBuilder uriBuilder){
        Pessoa pessoa = pessoaService.createPessoa(data);
        var uri = uriBuilder.path("/pessoa/{id}").buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri).body(new PessoaResponseDTO(pessoa));
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity<PessoaDeleteDTO> deletePessoa(@PathVariable Long id){
        return ResponseEntity.ok(pessoaService.deletePessoaByID(id));
    }
}
package br.tec.db.cadastro_pessoas.controller;

import br.tec.db.cadastro_pessoas.pessoa.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

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
}
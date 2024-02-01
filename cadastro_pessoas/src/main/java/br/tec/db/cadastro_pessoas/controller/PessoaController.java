package br.tec.db.cadastro_pessoas.controller;

import br.tec.db.cadastro_pessoas.pessoa.PessoaResponseDTO;
import br.tec.db.cadastro_pessoas.pessoa.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/all")
    public List<PessoaResponseDTO> getPessoas(){
        return pessoaService.getAllPessoas();
    }
}
package br.tec.db.cadastro_pessoas;

import br.tec.db.cadastro_pessoas.pessoa.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CadastroPessoasApplication {



	public static void main(String[] args) {
		SpringApplication.run(CadastroPessoasApplication.class, args);
	}

}

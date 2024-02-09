package br.tec.db.cadastro_pessoas.repository;

import br.tec.db.cadastro_pessoas.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}

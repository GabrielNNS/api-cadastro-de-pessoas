package br.tec.db.cadastro_pessoas.repository;

import br.tec.db.cadastro_pessoas.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}

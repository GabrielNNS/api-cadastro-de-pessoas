package br.tec.db.cadastro_pessoas.repository;

import br.tec.db.cadastro_pessoas.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query("SELECT p FROM pessoa p WHERE p.ativado = true ORDER BY p.id ASC")
    List<Pessoa> findAllByAtivadoTrue();
}

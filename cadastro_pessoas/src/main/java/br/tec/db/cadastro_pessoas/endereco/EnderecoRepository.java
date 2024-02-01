package br.tec.db.cadastro_pessoas.endereco;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    public List<Endereco> findAllByOrderByPrincipalAsc();
}

package br.tec.db.cadastro_pessoas.pessoa;


import br.tec.db.cadastro_pessoas.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "pessoa")
@Table(name = "pessoa")
public class Pessoa {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dataNascimento;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Endereco> endereco;

    private Boolean ativado;
}

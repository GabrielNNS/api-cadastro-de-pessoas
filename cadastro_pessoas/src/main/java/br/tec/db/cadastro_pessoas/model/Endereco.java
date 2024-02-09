package br.tec.db.cadastro_pessoas.model;

import br.tec.db.cadastro_pessoas.dto.EnderecoCreateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Entity(name = "endereco")
@Table(name = "endereco")
public class Endereco {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private String cep;
    private Integer numero;
    private String cidade;

    @ManyToOne()
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa_id;

    private Boolean principal;

    public Endereco(EnderecoCreateDTO data){
        this.logradouro = data.logradouro();
        this.cep = data.cep();
        this.numero = data.numero();
        this.cidade = data.cidade();
        this.pessoa_id = data.pessoa_id();
        this.principal = data.principal();
    }

    public void addPessoa_id(Pessoa pessoa){
        this.pessoa_id = pessoa;
    }
}

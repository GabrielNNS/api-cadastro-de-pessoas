package br.tec.db.cadastro_pessoas.pessoa;


import br.tec.db.cadastro_pessoas.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
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

    public Pessoa(PessoaCreateDTO data) {
        this.nome = data.nome();
        this.dataNascimento = data.dataNascimento();
        this.ativado = true;

        if (data.endereco().isEmpty()){
            this.endereco = new ArrayList<Endereco>();
        }else{
            this.endereco.addAll(data.endereco());
        }
    }

    public List<Endereco> getEndereco(){
        this.endereco.sort(Comparator.comparing(Endereco::getPrincipal).reversed());
        return this.endereco;
    };

    public void update(PessoaUpdateDTO data) {
        if(data.nome() != null){
            this.nome = data.nome();
        }

    }
}

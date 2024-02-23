package br.tec.db.cadastro_pessoas.model;

import br.tec.db.cadastro_pessoas.dto.EnderecoResponseDTO;
import br.tec.db.cadastro_pessoas.dto.PessoaCreateDTO;
import br.tec.db.cadastro_pessoas.dto.PessoaUpdateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.ArrayList;

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

    @OneToMany(mappedBy = "pessoa_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Endereco> endereco = new ArrayList<>();

    private Boolean ativado;

    public Pessoa(PessoaCreateDTO data) {
        this.nome = data.nome();
        this.dataNascimento = data.dataNascimento();
        if(!data.endereco().isEmpty()) this.endereco = data.endereco();
        this.ativado = true;
    }

    public List<EnderecoResponseDTO> getEndereco(){
        if (this.endereco.isEmpty()){
            return new ArrayList<>();
        }else{
            return this.endereco.stream().map(EnderecoResponseDTO::new).toList();
        }
    }

    public void update(PessoaUpdateDTO data) {
        if(data.nome() != null){
            this.nome = data.nome();
        }
    }

    public void deletaOuAtiva() {
        this.ativado = !this.ativado;
    }
}

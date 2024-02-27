package br.tec.db.cadastro_pessoas.exceptions;

public class PessoaNotFoundException extends RuntimeException{

    public PessoaNotFoundException(String msg){
        super(msg);
    }
}

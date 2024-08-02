package br.edu.unifil.lpoo.rh.modelo;

//Alunos: Miguel Henrique Duran e Aderson Batista da Silva
public abstract class Pessoa {
    private String nome;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

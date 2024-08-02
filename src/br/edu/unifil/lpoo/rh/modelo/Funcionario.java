package br.edu.unifil.lpoo.rh.modelo;

//Alunos: Miguel Henrique Duran e Aderson Batista da Silva
public abstract class Funcionario extends Pessoa{
    private String matricula;
    protected double salario;

    public Funcionario(String nome, String matricula, double salario) {
        super(nome);
        this.matricula = matricula;
        this.salario = salario;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public abstract double getGanhoMensal();

    public abstract double getBonificacao();

}

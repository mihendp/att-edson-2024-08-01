package br.edu.unifil.lpoo.rh.modelo;

//Alunos: Miguel Henrique Duran e Aderson Batista da Silva
public class Mensalista extends Funcionario{
    public Mensalista(String nome, String matricula, double salario) {
        super(nome, matricula, salario);
    }

    @Override
    public double getGanhoMensal() {
        return salario;
    }

    @Override
    public double getBonificacao() {
        return getGanhoMensal() * 0.05;
    }


}

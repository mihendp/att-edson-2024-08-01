package br.edu.unifil.lpoo.rh.modelo;

//Alunos: Miguel Henrique Duran e Aderson Batista da Silva
public class Horista extends Funcionario{
    private int horasTrabalhadas;

    public Horista(String nome, String matricula, double salario, int horasTrabalhadas) {
        super(nome, matricula, salario);
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    @Override
    public double getGanhoMensal() {
        return salario * horasTrabalhadas;
    }

    @Override
    public double getBonificacao() {
        return getGanhoMensal() * 0.04;
    }
}

package br.edu.unifil.lpoo.rh.modelo;

//Alunos: Miguel Henrique Duran e Aderson Batista da Silva
public class Comissionado extends Funcionario{
    private double comissao;
    private int qtdVendida;

    public Comissionado(String nome, String matricula, double salario, double comissao, int qtdVendida) {
        super(nome, matricula, salario);
        this.comissao = comissao;
        this.qtdVendida = qtdVendida;
    }



    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    public int getQtdVendida() {
        return qtdVendida;
    }

    public void setQtdVendida(int qtdVendida) {
        this.qtdVendida = qtdVendida;
    }

    @Override
    public double getGanhoMensal() {
        return salario + (comissao * qtdVendida);
    }

    @Override
    public double getBonificacao() {
        return getGanhoMensal() * 0.08;
    }
}

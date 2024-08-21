package br.edu.unifil.lpoo.rh.modelo;

//Alunos: Miguel Henrique Duran e Aderson Batista da Silva
public class Producao extends Funcionario {
    private int qtdProduzida;

    public Producao(String nome, String matricula, double salario, int qtdProduzida) {
        super(nome, matricula, salario);
        this.qtdProduzida = qtdProduzida;
    }

    public int getQtdProduzida() {
        return qtdProduzida;
    }

    public void setQtdProduzida(int qtdProduzida) {
        this.qtdProduzida = qtdProduzida;
    }

    @Override
    public double getGanhoMensal() {
        return salario * qtdProduzida;
    }

    @Override
    public double getBonificacao() {
        return getGanhoMensal() * 0.07;
    }
    
}

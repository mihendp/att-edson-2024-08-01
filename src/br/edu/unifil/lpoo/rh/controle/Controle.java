package br.edu.unifil.lpoo.rh.controle;

import br.edu.unifil.lpoo.rh.modelo.Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

//Alunos: Miguel Henrique Duran e Aderson Batista da Silva
public class Controle {
    private List<Funcionario> funcionarios;

    public Controle() {
        this.funcionarios = new ArrayList<>();
    }

    public void cadastrarFuncionario(Funcionario funcionario){
        funcionarios.add(funcionario);
    }

    public String listarFuncionarios() {
        String result = "";

        for (Funcionario f : funcionarios){
            String aux = "Nome: %s\nMatrícula: %s\nSalário: %.2f\nGanho mensal: %.2f\nBonificação: %.2f\n==============================\n";
            String formatado = String.format(aux, f.getNome(), f.getMatricula(), f.getSalario(), f.getGanhoMensal(), f.getBonificacao());
           result = result.concat(formatado);
        }
        return result;
    }

    public Funcionario getFuncionario(String matricula){
        return funcionarios.stream()
                .filter(funcionario -> funcionario.getMatricula().equals(matricula))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Usuário não encontrado"));
    }

    public void excluirFuncionario(Funcionario funcionario){
        funcionarios.remove(funcionario);
    }
}

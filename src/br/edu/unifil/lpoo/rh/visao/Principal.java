package br.edu.unifil.lpoo.rh.visao;

import br.edu.unifil.lpoo.rh.controle.Controle;
import br.edu.unifil.lpoo.rh.modelo.*;
import br.edu.unifil.lpoo.rh.servico.InputService;

import java.util.NoSuchElementException;
import java.util.Scanner;

//Alunos: Miguel Henrique Duran e Aderson Batista da Silva
public class Principal {
    public static void main(String[] args) {
        Controle controle = new Controle();
        InputService inputService = new InputService();
        Scanner scan = new Scanner(System.in);
        String usuario = "";


        String nome;
        String matricula;
        double salario;
        int qtdProduzida;
        int horasTrabalhadas;
        double comissao;
        int qtdVendida;

        while(!usuario.equals("0")){
            System.out.println("=== MENU ===\n" +
                    "1 - CADASTRAR FUNCIONÁRIO\n" +
                    "2 - LISTAR FUNCIONÁRIOS\n" +
                    "3 - CONSULTAR FUNCIONÁRIO\n" +
                    "4 - EXCLUIR FUNCIONÁRIO\n" +
                    "5 - ATUALIZAR SALÁRIO DE FUNCIONÁRIO\n" +
                    "0 - ENCERRAR PROGRAMA");

            usuario = scan.nextLine();

            switch (usuario) {
                case "1":
                    String aux = "";
                    System.out.println("\nVOCÊ ESCOLHEU A OPÇÃO DE CADASTRAR FUNCIONÁRIO\n");
                    System.out.println("Qual o nome do funcionário?");
                    try {
                        nome = inputService.inputString();
                    } catch (NoSuchElementException e){
                        System.err.println("Nenhum nome foi digitado, tente novamente.");
                        break;
                    }


                    System.out.println("Qual a matrícula do funcionário?");
                    try {
                        matricula = inputService.inputString();
                    }catch (NoSuchElementException e){
                        System.err.println("Nenhuma matrícula foi digitada, tente novamente.");
                        break;
                    }


                    System.out.println("Qual o salário do funcionário?");
                    try {
                        salario = inputService.inputDouble();
                    }catch (NoSuchElementException p){
                        System.err.println("Nenhum salário foi digitado, tente novamente.");
                        break;
                    }catch (NumberFormatException e){
                        System.err.println("O salário digitado deve ser um número.");
                        break;
                    }

                    System.out.println("Qual o tipo de funcionário que deseja incluir?");
                    System.out.println("============\n" +
                            "1 - MENSALISTA\n" +
                            "2 - COMISSIONADO\n" +
                            "3 - PRODUÇÃO\n" +
                            "4 - HORISTA\n");
                    aux = scan.nextLine();

                    switch (aux){
                        case "1":
                            Funcionario f = new Mensalista(nome, matricula, salario);
                            controle.cadastrarFuncionario(f);
                            break;

                        case "2":
                            System.out.println("Qual a comissão do funcionário?");
                            comissao = Double.parseDouble(scan.nextLine());

                            System.out.println("Qual a quantidade vendida desse funcionário?");
                            qtdVendida = Integer.parseInt(scan.nextLine());
                            Funcionario f2 = new Comissionado(nome, matricula, salario, comissao, qtdVendida);
                            controle.cadastrarFuncionario(f2);
                            break;

                        case "3":
                            System.out.println("Qual a quantidade produzida desse funcionário?");
                            qtdProduzida = Integer.parseInt(scan.nextLine());

                            Funcionario f3 = new Producao(nome, matricula, salario, qtdProduzida);
                            controle.cadastrarFuncionario(f3);
                            break;

                        case "4":
                            System.out.println("Quais foram as horas trabalhadas desse funcionário?");
                            horasTrabalhadas = Integer.parseInt(scan.nextLine());

                            Funcionario f4 = new Horista(nome, matricula, salario, horasTrabalhadas);
                            controle.cadastrarFuncionario(f4);
                            break;

                        default:
                            System.out.println("\nOpção não encontrada.\n");
                    }
                    break;

                case "2":
                    System.out.println("\n==== LISTA DE FUNCIONÁRIOS =====\n");
                    System.out.println(controle.listarFuncionarios());
                    break;

                case "3":
                    System.out.println("\nCONSULTAR FUNCIONÁRIO\n");
                    System.out.println("Informe o número de matrícula do usuário: ");
                    matricula = scan.nextLine();

                    //Tratamento de usuários não cadastrado
                    try {
                        Funcionario f = controle.getFuncionario(matricula);
                        System.out.println("Nome: " + f.getNome() + "\nSalário: " + f.getSalario() + "\nGanho mensal: " + f.getGanhoMensal());
                    }catch (NoSuchElementException e){
                        System.err.println("O funcionário informado não foi encontrado");
                    }

                    break;

                case "4":
                    System.out.println("\nEXCLUIR FUNCIONÁRIO\n");
                    System.out.println("Informe o número de matrícula do usuário: ");
                    matricula = scan.nextLine();

                    try {
                        controle.excluirFuncionario(controle.getFuncionario(matricula));
                        System.out.println("Usuário deletado com sucesso.");
                    }catch (NoSuchElementException e){
                        System.err.println("O funcionário informado não foi encontrado");
                    }
                    break;

                case "5":
                    System.out.println("\nATUALIZAR SALÁRIO DE FUNCIONÁRIO\n");
                    System.out.println("Informe o número de matrícula do usuário: ");
                    matricula = scan.nextLine();

                    System.out.println("Agora informe o novo salário do funcionário: ");
                    salario = Double.parseDouble(scan.nextLine());

                    try {
                        Funcionario funcionario = controle.getFuncionario(matricula);
                        funcionario.setSalario(salario);
                        System.out.println("Salário alterado com sucesso.");
                    } catch (NoSuchElementException e){
                        System.err.println("O funcionário informado não foi encontrado");
                    }

                    break;

                case "0":
                    System.out.println("\nPROGRAMA FINALIZADO\n");
                    scan.close();
                    break;

                default:
                    System.out.println("Opção não encontrada.");
            }
        }
    }
}

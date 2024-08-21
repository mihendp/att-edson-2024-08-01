package br.edu.unifil.lpoo.rh.servico;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputService {
    private Scanner scan;

    public InputService() {
        this.scan = new Scanner(System.in);
    }

    //Método utilizado para validar se a String digitada está vazia
    public String inputString() {
        String str = scan.nextLine().trim();
        if (str.isBlank())
            throw new NoSuchElementException();
        return str;
    }

    //Método utilizado para validar se o valor digitado está vazio ou não é um número
    public Double inputDouble() {
        Double n = Double.parseDouble(scan.nextLine().trim());

        if (n.toString().isBlank()) {
            throw new NoSuchElementException();
        }

        if (n.isNaN())
            throw new NumberFormatException();

        return n;
    }

    //Método utilizado para validar se o valor digitado está vazio ou não é um número
    public Integer inputInt() {
        Integer n = Integer.parseInt(scan.nextLine().trim());

        if (n.toString().isBlank())
            throw new NoSuchElementException();

        return n;
    }
}

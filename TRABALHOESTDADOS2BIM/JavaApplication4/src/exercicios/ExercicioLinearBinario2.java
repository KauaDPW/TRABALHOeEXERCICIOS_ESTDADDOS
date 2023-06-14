/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercicios;  
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Cliente {
    private int codigo;
    private String nome;
    private String dataNascimento;
    private String cpf;

    public Cliente(int codigo, String nome, String dataNascimento, String cpf) {
        this.codigo = codigo;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }
}

public class ExercicioLinearBinario2 {

    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Cadastro de Clientes ===");

        // Cadastro de clientes
        int codigo;
        String nome, dataNascimento, cpf;
        do {
            System.out.print("Código do cliente (digite -1 para sair): ");
            codigo = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            if (codigo != -1) {
                System.out.print("Nome do cliente: ");
                nome = scanner.nextLine();

                System.out.print("Data de Nascimento (dd/mm/aaaa): ");
                dataNascimento = scanner.nextLine();

                System.out.print("CPF do cliente: ");
                cpf = scanner.nextLine();

                Cliente cliente = new Cliente(codigo, nome, dataNascimento, cpf);
                clientes.add(cliente);

                System.out.println("Cliente cadastrado com sucesso!\n");
            }
        } while (codigo != -1);

        // Ordenação dos clientes pelo código
        clientes.sort(Comparator.comparingInt(Cliente::getCodigo));

        // Exibição dos clientes
        System.out.println("\n=== Lista de Clientes Ordenados por Código ===");
        for (Cliente cliente : clientes) {
            System.out.println("Código: " + cliente.getCodigo());
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Data de Nascimento: " + cliente.getDataNascimento());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println();
        }

        // Pesquisa binária
        System.out.print("Digite o código do cliente a ser pesquisado: ");
        int codigoPesquisa = scanner.nextInt();

        int indiceCliente = Collections.binarySearch(clientes, new Cliente(codigoPesquisa, "", "", ""), Comparator.comparingInt(Cliente::getCodigo));
        if (indiceCliente >= 0) {
            Cliente clientePesquisado = clientes.get(indiceCliente);
            System.out.println("\nCliente encontrado:");
            System.out.println("Código: " + clientePesquisado.getCodigo());
            System.out.println("Nome: " + clientePesquisado.getNome());
            System.out.println("Data de Nascimento: " + clientePesquisado.getDataNascimento());
            System.out.println("CPF: " + clientePesquisado.getCpf());
        } else {
            System.out.println("\nCliente não encontrado.");
        }

        scanner.close();
    }
}

    


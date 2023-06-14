package exercicios;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author 00235565
 */
public class exercicio1Flias { 
    
    public static void main(String[] args) {
        
        Queue<String> filaPacientes = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        
        int opcao = 0;
        while (opcao != 3) {
            exibirMenu();
            opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome: ");
                    String nomePaciente = scanner.next();
                    filaPacientes.add(nomePaciente);
                    break;
                case 2:
                    if (!filaPacientes.isEmpty()) {
                        String proximoPaciente = filaPacientes.poll();
                        System.out.println("Próximo paciente: " + proximoPaciente);
                    } else {
                        System.out.println("Não há pacientes na fila.");
                    }
                    break;
                case 3:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida tente novamente.");
            }
        }
    }
    
    public static void exibirMenu() {
        System.out.println(" Menu ");
        System.out.println("1 - Adicionar:");
        System.out.println("2 - Chamar próximo paciente ja existente:");
        System.out.println("3 - Encerrar");
        System.out.print("Escolha uma das opçoes: ");
    
        
     }
    
}

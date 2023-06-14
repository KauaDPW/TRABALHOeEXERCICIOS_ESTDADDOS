/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercicios;

/**
 *
 * @author 00235565
 */
public class ExercicioLinearBinario1 { 
    public static void main(String[] args) {
        int[] numeros = { 10, 20, 30, 40, 50 }; // Números já ordenados

        int opcao = 2; // Opção de pesquisa: 1 - Linear, 2 - Binária
        int numeroPesquisar = 30; // Número a ser pesquisado

        if (opcao == 1) {
            int posicao = pesquisarLinear(numeros, numeroPesquisar);
            exibirResultado(posicao);
        } else if (opcao == 2) {
            int posicao = pesquisarBinaria(numeros, numeroPesquisar);
            exibirResultado(posicao);
        } else {
            System.out.println("Opção inválida.");
        }
    }

    public static int pesquisarLinear(int[] numeros, int numeroPesquisar) {
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == numeroPesquisar) {
                return i;
            }
        }
        return -1;
    }

    public static int pesquisarBinaria(int[] numeros, int numeroPesquisar) {
        int esquerda = 0;
        int direita = numeros.length - 1;
        while (esquerda <= direita) {
            int meio = (esquerda + direita) / 2;
            if (numeros[meio] == numeroPesquisar) {
                return meio;
            } else if (numeros[meio] < numeroPesquisar) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }
        return -1;
    }

    public static void exibirResultado(int posicao) {
        if (posicao == -1) {
            System.out.println("Número não encontrado.");
        } else {
            System.out.println("O número foi encontrado na posição: " + posicao);
        }
    }
     }
    


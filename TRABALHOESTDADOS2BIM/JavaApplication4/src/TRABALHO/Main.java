/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package TRABALHO;

import javax.swing.JOptionPane;
import TRABALHO.ContaBancaria;

/**
 *
 * @author 00235565
 */
public class Main {

    private static final int CONTAS_MAXIMAS = 100;
    private ContaBancaria[] contas;
    private int nContas;

    public Main() {
        contas = new ContaBancaria[CONTAS_MAXIMAS];
        nContas = 0;
    }

    public static void main(String[] args) {
        Main sistema = new Main();

        int opcao = 0;

        while (opcao != 7) {
            String menu = " Menu \n"
                    + "1. Cadastrar nova conta\n"
                    + "2. Exibir contas cadastradas\n"
                    + "3. Pesquisar conta por número\n"
                    + "4. Realizar saque\n"
                    + "5. Calcular saldo total\n"
                    + "6. Verificar saldo negativo\n"
                    + "7. Sair\n"
                    + "Escolha uma opção:";

            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcao) {
                case 1:
                    int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta:"));
                    String nomeTitular = JOptionPane.showInputDialog("Digite o nome do titular:");
                    double saldoInicial = Double.parseDouble(JOptionPane.showInputDialog("Digite o saldo inicial:"));
                    sistema.cadastrarConta(numeroConta, nomeTitular, saldoInicial);
                    break;
                //-------------------------------------------------------------------------------     
                case 2:
                    sistema.exibirContas();
                    break;
                //------------------------------------------------------------------------------    
                case 3:
                    int numeroPesquisa = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta:"));

                    ContaBancaria contaNumero = sistema.pesquisarContaPorNumero(numeroPesquisa);
                    if (contaNumero != null) {
                        JOptionPane.showMessageDialog(null, "Conta encontrada:\n" + contaNumero.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Conta não encontrada.");
                    }
                    break;
                //------------------------------------------------------------------------------     
                case 4:
                    int numeroSaque = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta:"));
                    double valorSaque = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do saque:"));
                    sistema.realizarSaque(numeroSaque, valorSaque);
                    break;
                //-----------------------------------------------------------------------------    
                case 5:
                    double saldoTotal = sistema.calcularSaldoTotal();
                    JOptionPane.showMessageDialog(null, "Saldo Total: R$" + saldoTotal);
                    break;
                //------------------------------------------------------------------------------   
                case 6:
                    boolean saldoNegativo = sistema.verificarSaldoNegativo();
                    if (saldoNegativo) {
                        JOptionPane.showMessageDialog(null, "conta existente com saldo negativo!.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Todas as contas estão positivadas!.");
                    }
                    break;
                //-------------------------------------------------------------------------------     
                case 7:
                    JOptionPane.showMessageDialog(null, "Encerrando...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        }
    }

    //------METODOS A SEGUIR---------//
    //-Cadastro de contas no codigo 
    public void cadastrarConta(int numeroConta, String nomeTitular, double saldoInicial) {
        if (nContas >= CONTAS_MAXIMAS) {
            JOptionPane.showMessageDialog(null, "Não pode Cadastrar mais contas!");
            return;
        }

        ContaBancaria novaConta = new ContaBancaria(numeroConta, nomeTitular, saldoInicial);
        contas[nContas] = novaConta;
        nContas++;

        ordenarContasPorNumeroConta();
        JOptionPane.showMessageDialog(null, "Cadastro concluido!!");
    }

    // - pesquisar conta no codigo 
    public ContaBancaria pesquisarContaPorNumero(int numeroConta) {
        int inicio = 0;
        int fim = nContas - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            ContaBancaria contaMeio = contas[meio];

            if (contaMeio.getNumeroConta() == numeroConta) {
                return contaMeio;
            } else if (contaMeio.getNumeroConta() < numeroConta) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        return null;
    }

    //- exibir conta no codigo
    public void exibirContas() {
        StringBuilder mensagem = new StringBuilder("---- Contas Bancárias ----\n");

        for (int i = 0; i < nContas; i++) {
            mensagem.append("Conta ").append(i + 1).append("\n");
            mensagem.append(contas[i].toString()).append("\n");
        }

        JOptionPane.showMessageDialog(null, mensagem.toString());
    }

    //- ordenar contas por numero no codigo
    public void ordenarContasPorNumeroConta() {
        for (int i = 0; i < nContas - 1; i++) {
            for (int j = 0; j < nContas - i - 1; j++) {
                if (contas[j].getNumeroConta() > contas[j + 1].getNumeroConta()) {
                    ContaBancaria temp = contas[j];
                    contas[j] = contas[j + 1];
                    contas[j + 1] = temp;
                }
          } 
        }
    }

    //- realizar saque no codigo
    public void realizarSaque(int numeroConta, double valorSaque) {
        ContaBancaria conta = pesquisarContaPorNumero(numeroConta);

        if (conta != null) {
            if (valorSaque <= conta.getSaldo()) {
                conta.realizarSaque(valorSaque);
                JOptionPane.showMessageDialog(null, "Saque de R$" + valorSaque + " realizado com sucesso na conta " + numeroConta + ".");
            } else {
                JOptionPane.showMessageDialog(null, "Saldo insuficiente para realizar o saque.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Conta não encontrada.");
        }
    }

    //calcular saldo no codigo
    public double calcularSaldoTotal() {
        return calcularSaldoRecursivo(0);
    }

    
    // calcular saldo total recursivamente no codigo
    private double calcularSaldoRecursivo(int index) {
        if (index >= nContas) {
            return 0.0;
        }

        ContaBancaria conta = contas[index];
        return conta.getSaldo() + calcularSaldoRecursivo(index + 1);
    }

    
    //verificar saldo negativado no codigo
    public boolean verificarSaldoNegativo() {
        return verificarSaldoNegativadoRecursivo(0);
    }

    
    //verificar saldo negativado com recursividade
    private boolean verificarSaldoNegativadoRecursivo(int index) {
        if (index >= nContas) {
            return false;
        }

        ContaBancaria conta = contas[index];
        if (conta.getSaldo() < 0) {
            return true;
        }

        return verificarSaldoNegativadoRecursivo(index + 1);
    }

}

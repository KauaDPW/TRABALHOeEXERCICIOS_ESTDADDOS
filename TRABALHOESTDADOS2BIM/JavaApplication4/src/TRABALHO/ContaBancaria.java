/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TRABALHO;

/**
 *
 * @author 00235565
 */ 
    public class ContaBancaria { 
        
    private int numConta;
    private String nomeTitular;
    private double saldo;

    
    public ContaBancaria(int numConta, String nomeTitular, double saldoInicial) {
        this.numConta = numConta;
        this.nomeTitular = nomeTitular;
        this.saldo = saldoInicial;
    }

    public int getNumeroConta() {
        return numConta;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void realizarSaque(double valor) {
        saldo -= valor;
    }

    @Override
    public String toString() {
        return "Número da conta: " + numConta + "\n"
                + "Nome do titular: " + nomeTitular + "\n"
                + "Saldo: R$" + saldo;
    }
}


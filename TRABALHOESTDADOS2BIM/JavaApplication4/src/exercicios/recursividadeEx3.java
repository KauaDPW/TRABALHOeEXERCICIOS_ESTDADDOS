package exercicios;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author 00235565
 */
public class recursividadeEx3 {

   
    public static void main(String[] args) {
        
        int numF = 2;  
        for (int i = 0; i <= numF; i++) {
            System.out.println("sequência Fibonacci de " + numF); 
            System.out.print(calculoFibonacci(i) + " ");          
        }
    }
    
    public static int calculoFibonacci(int numF) {
        if (numF == 0) {
            return 0;   
        } else if (numF == 1) {
            return 1;     
        } else {
            return calculoFibonacci(numF - 1) + calculoFibonacci(numF - 2);
        }
        
     }
    
}

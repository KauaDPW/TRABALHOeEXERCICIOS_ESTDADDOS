package exercicios;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author 00235565
 */
public class recursividadeEx1 {
 // c = começo   f = fim
    public static void main(String[] args) { 
        
        sequenciaNumeros(0, 50);
    }
    
    public static void sequenciaNumeros(int c, int f) {
        if (c <= f) {
            System.out.println(c);
            
            sequenciaNumeros(c + 1, f);
        }
    }
}
        
     
    


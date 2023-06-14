package exercicios;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner; 
/**
 *
 * @author 00235565
 */
public class exercicioFilas2 { 
    
    public static void main(String[] args) {
        
        Queue<Cliente> filaPrioritaria = new LinkedList<>();
        Queue<Cliente> filaNormal = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        int opcao = 0;
        while (opcao != 3) {
            exibirMenu();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome: ");
                    String nomeCliente = scanner.next();
                    System.out.print("Digite o ano de nascimento: ");
                    int anoNascimento = scanner.nextInt();
                    
                    Cliente cliente = new Cliente(nomeCliente, anoNascimento);

                    if (cliente.Prioridade()) {
                        filaPrioritaria.add(cliente);
                    } else {
                        filaNormal.add(cliente);
                    }
                    break;
                case 2:
                    if (!filaPrioritaria.isEmpty()) {
                        atenderCliente(filaPrioritaria);
                        atenderCliente(filaPrioritaria);
                    }

                    if (!filaNormal.isEmpty()) {
                        atenderCliente(filaNormal);
                    }
                    break;
                case 3:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida tente novamente.");
            }
        }
    }

    public static void exibirMenu() {
        System.out.println("Menu ");
        System.out.println("1 - Adicionar:");
        System.out.println("2 - Chamar cliente:");
        System.out.println("3 - Encerrar:");
        System.out.print("Escolha uma das opçoes: ");
    }

    public static void atenderCliente(Queue<Cliente> fila) {
        Cliente cliente = fila.poll();
        System.out.println("Cliente atendido: " + cliente.getNome());
    }
}

class Cliente {
    private int senha;
    private String nome;
    private int anoNascimento;

    public Cliente(String nome, int anoNascimento) {
        this.nome = nome;
        this.anoNascimento = anoNascimento;
        this.senha = (int) (Math.random() * 1000); // Gera uma senha aleatória
    }

    public boolean Prioridade() {
        int idade = calcularIdade();
        return idade >= 65;
    }

    private int calcularIdade() {
        int anoAtual = java.time.Year.now().getValue();
        return anoAtual - anoNascimento;
    }

    public String getNome() {
        return nome;
    }
}
        
     
    



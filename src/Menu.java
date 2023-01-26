import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem vinda ao LivruxDoixmil, minha ama. Deseja que eu...");
        System.out.println("———————————————————————————");
        System.out.println("(A) dicione um novo livro ao estoque?");
        System.out.println("(L) iste todos os livros do estoque?");
        System.out.println("(O) lhe um livro específico?");
        System.out.println("(R) emova um livro do estoque?");
        System.out.println("(F) eche o sistema?");
        System.out.println("———————————————————————————");
        System.out.println("Digite aqui a opção desejada:");
        
        String opcaoEscolhida = scanner.nextLine();
        

        System.out.println(opcaoEscolhida);
        
        Estante.cadastraLivros();
        Estante.cadastraLivros();

        Estante.mostraCatalogo();

        scanner.close();
    }

}

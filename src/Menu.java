import java.util.Scanner;

public abstract class Menu {
    private static Estante estante = new Estante();

    public static void main(String[] args) {
        
        String escolha;
        
        do {
            escolha = exibeMenu();

            switch (escolha.toUpperCase()) {
                case "A":
                    escolhaA();
                    break;
                    
                default:
                    break;
            }

            escolha = exibeMenu();

        } while (!escolha.toUpperCase().equals("F"));

    }

    public static String exibeMenu() {
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

        String escolha = scanner.nextLine();
        scanner.close();
        return escolha;

    }

    public static void escolhaA() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o título do livro: ");
        String titulo = scanner.nextLine();
        System.out.println("Digite uma descrição para o livro: ");
        String descricao = scanner.nextLine();
        System.out.println("Digite o preço para o livro: ");
        double preco = scanner.nextDouble();

        estante.cadastrarLivro(titulo, descricao, preco);

        scanner.close();
    }
}

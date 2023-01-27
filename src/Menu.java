import java.util.Scanner;

public abstract class Menu {
    private static Estante estante = new Estante();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String escolha;

        do {
            escolha = exibeMenu();

            switch (escolha.toUpperCase()) {
                case "A":
                    escolhaA();
                    break;
                case "L":
                    escolhaL();
                    break;
                case "O":
                    escolhaO();
                    break;
                case "R":
                    escolhaR();
                    break;
                case "F":
                    System.out.println("Obrigada por usar o LivroxDoixmil! \nAté breve!");
                    scanner.close();
                    break;
                }
                
        } while (!escolha.toUpperCase().equals("F"));

    }

    public static String exibeMenu() {

        System.out.println();
        System.out.println("Bem vinda ao LivruxDoixmil, minha ama. Deseja que eu...");
        System.out.println("———————————————————————————");
        System.out.println("(A) dicione um novo livro ao estoque?");
        System.out.println("(L) iste todos os livros do estoque?");
        System.out.println("(O) lhe um livro específico?");
        System.out.println("(R) emova um livro do estoque?");
        System.out.println("(F) eche o sistema?");
        System.out.println("———————————————————————————");
        System.out.println("Digite aqui a opção desejada: ");
        
        String escolha = scanner.nextLine();
        
        return escolha;

    }

    public static void escolhaA() {

        System.out.println("Digite o título do livro: ");
        String titulo = scanner.nextLine();
        System.out.println("Digite uma descrição para o livro: ");
        String descricao = scanner.nextLine();
        System.out.println("Digite o preço para o livro: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();
        
        estante.cadastrarLivro(titulo, descricao, preco);

    }

    public static void escolhaL() {
        System.out.println("Segue abaixo o catálogo com todos os livros!");
        System.out.println("\n" + estante.mostrarCatalogo());

    }

    public static void escolhaO() {

        System.out.println("Digite o título do livro que deseja inspecionar: ");
        String titulo = scanner.nextLine();
        System.out.println("\n" + estante.buscarLivro(titulo));

    }

    public static void escolhaR() {

        System.out.println("Qual livro deseja remover? Digite o título: ");
        String exemplar = scanner.nextLine();
        estante.removerLivro(exemplar);

    }

}

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
                case "E":
                    escolhaE();                
                    break;
                case "M":
                    escolhaM();
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
        System.out.println("(E) Adicione livros já existentes no estoque?");
        System.out.println("(M) odificar informações de um livro?");
        System.out.println("(F) eche o sistema?");
        System.out.println("———————————————————————————");
        System.out.println("Digite aqui a opção desejada: ");
        
        String escolha = scanner.nextLine().trim();
        
        return escolha;

    }

    public static void escolhaA() {

        System.out.println("Digite o título do livro: ");
        String titulo = scanner.nextLine().trim();
        System.out.println("Digite uma descrição para o livro: ");
        String descricao = scanner.nextLine();
        System.out.println("Digite o preço para o livro: ");
        double preco = scanner.nextDouble();
        System.out.println("Quantos exemplares deste quer adicionar?");
        int quantidade = scanner.nextInt();
        scanner.nextLine();
        
        estante.cadastrarLivro(titulo, descricao, preco, quantidade);

    }

    public static void escolhaL() {
        System.out.println("Segue abaixo o catálogo com todos os livros!");
        estante.mostrarCatalogo();

    }

    public static void escolhaO() {

        System.out.println("Digite o título do livro que deseja inspecionar: ");
        String titulo = scanner.nextLine().trim();
        System.out.println("\n" + estante.buscarLivro(titulo));

    }

    public static void escolhaR() {

        System.out.println("Qual livro deseja remover? Digite o título: ");
        String exemplar = scanner.nextLine().trim();
        estante.removerLivro(exemplar);

    }

    public static void escolhaE(){
        System.out.println("Qual livro que deseja acrescentar? ");
        String titulo = scanner.nextLine().trim();
        System.out.println("Quantos livros desejar somar ao catálogo? ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        estante.modificarQuantidadeExemplar(titulo, quantidade);
    }

    public static void escolhaM() {
        System.out.println("Qual livro deseja modificar? ");
        String titulo = scanner.nextLine().trim();
        Livro exemplar = estante.buscarLivro(titulo);

        System.out.println("Escolha uma das propriedades abaixo para alterar: ");
        System.out.println("———————————————————————————");
        System.out.println("(1) Título");
        System.out.println("(2) Descrição");
        System.out.println("(3) Preço");
        System.out.println("———————————————————————————");
        
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                System.out.println("Qual o novo título para o livro -> " + exemplar.getTitulo());
                String novoTitulo = scanner.nextLine().trim();
                exemplar.setTitulo(novoTitulo);
                break;
                case 2: 
                System.out.println("Qual a nova descrição para o livro -> " + exemplar.getTitulo());
                String novaDescricao = scanner.nextLine();
                exemplar.setDescricao(novaDescricao);
                break;
            case 3:
                System.out.println("Qual o novo preço para o livro -> " + exemplar.getTitulo());
                double novoPreco = scanner.nextDouble();
                scanner.nextLine();
                exemplar.setPreco(novoPreco);
                break;
            default:
                //exibir mensagem de erro e iniciar novamente o menu para escolha de modificações
                break;
        }

    }

}

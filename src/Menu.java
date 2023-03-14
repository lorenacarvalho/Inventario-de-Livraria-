import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Menu {
    private static Estante estante = new Estante();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        iniciarEstante();
        
        String escolha;
        do {
            escolha = exibeMenu();

            try {
                switch (escolha) {
                    case "1":
                        escolha1();
                        break;
                    case "2":
                        escolha2();
                        break;
                    case "3":
                        escolha3();
                        break;
                    case "4":
                        escolha4();
                        break;
                    case "5":
                        escolha5();
                        break;
                    case "6":
                        escolha6();
                        break;
                    case "0":
                        System.out.println("Obrigada por usar o Seu Inventário de Livros! \nAté breve!");
                        scanner.close();
                        break;

                    default:
                        System.out.println("\nDigite uma opção válida!");
                }

            } catch (BookNotFoundException ex) {
                System.out.println(ex.getMessage());
            } catch (UnacceptableEntryException exception) {
                System.out.println(exception.getMessage());
            }

        } while (!escolha.equals("0"));

    }

    public static String exibeMenu() {

        System.out.println();
        System.out.println("Bem vindo(a) ao Seu Inventário de Livros. Deseja que eu...");
        System.out.println("———————————————————————————");
        System.out.println("(1) Adicione um novo livro ao estoque?");
        System.out.println("(2) Liste todos os livros do estoque?");
        System.out.println("(3) Olhe um livro específico?");
        System.out.println("(4) Remova um livro do estoque?");
        System.out.println("(5) Adicione livros já existentes no estoque?");
        System.out.println("(6) Modifique informações de um livro?");
        System.out.println("(0) Feche o sistema?");
        System.out.println("———————————————————————————");
        System.out.println("Digite aqui a opção desejada: ");

        String escolha = scanner.nextLine().trim();

        return escolha;

    }

    public static void escolha1() throws UnacceptableEntryException {
        System.out.println("Digite o título do livro: ");
        String inputTitulo = scanner.nextLine().trim();
        String titulo = Livro.validarEntradaCaracter(inputTitulo);
        System.out.println("Digite uma descrição para o livro: ");
        String inputDescricao = scanner.nextLine();
        String descricao = Livro.validarEntradaCaracter(inputDescricao);
        System.out.println("Digite o preço para o livro: ");

        try {
            double preco = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Quantos exemplares deste quer adicionar?");
            int quantidade = scanner.nextInt();
            scanner.nextLine();
            estante.cadastrarLivro(titulo, descricao, preco, quantidade);

        } catch (InputMismatchException exception) {
            scanner.nextLine();
            throw new UnacceptableEntryException("Por favor, digite apenas números");
        }

    }

    public static void escolha2() {
        System.out.println("\nSegue abaixo o catálogo com todos os livros!");
        estante.mostrarCatalogo();

    }

    public static void escolha3() throws BookNotFoundException {
        System.out.println("Digite o título do livro que deseja inspecionar: ");
        String titulo = scanner.nextLine().trim();
        System.out.println("\n" + estante.buscarLivro(titulo));

    }

    public static void escolha4() throws BookNotFoundException {
        System.out.println("Qual livro deseja remover? Digite o título: ");
        String exemplar = scanner.nextLine().trim();
        estante.removerLivro(exemplar);

    }

    public static void escolha5() throws UnacceptableEntryException {
        System.out.println("Qual livro que deseja acrescentar? ");
        String titulo = scanner.nextLine().trim();
        System.out.println("Quantos livros deseja somar ao catálogo? ");

        int quantidade = scanner.nextInt();
        estante.modificarQuantidadeExemplar(titulo, quantidade);
        scanner.nextLine();

    }

    public static void escolha6() throws BookNotFoundException, UnacceptableEntryException {

        System.out.println("Qual livro deseja modificar? ");
        String titulo = scanner.nextLine().trim();
        Livro exemplar = estante.buscarLivro(titulo);

        int opcao = 0;

        do {
            System.out.println("\nEscolha uma das propriedades abaixo para alterar: ");
            System.out.println("———————————————————————————");
            System.out.println("(1) Título");
            System.out.println("(2) Descrição");
            System.out.println("(3) Preço");
            System.out.println("———————————————————————————");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException exception) {
                System.out.println("---Digite uma opção válida!---");
                scanner.nextLine();
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.println("Qual o novo título para o livro -> " + exemplar.getTitulo());
                    String inputTitulo = scanner.nextLine().trim();
                    String novoTitulo = Livro.validarEntradaCaracter(inputTitulo);
                    exemplar.setTitulo(novoTitulo);
                    break;
                case 2:
                    System.out.println("Qual a nova descrição para o livro -> " + exemplar.getTitulo());
                    String inputDescricao = scanner.nextLine();
                    String novaDescricao = Livro.validarEntradaCaracter(inputDescricao);
                    exemplar.setDescricao(novaDescricao);
                    break;
                case 3:
                    System.out.println("Qual o novo preço para o livro -> " + exemplar.getTitulo());
                    try {
                        double novoPreco = scanner.nextDouble();
                        scanner.nextLine();
                        exemplar.setPreco(novoPreco);
                        break;
                    } catch (InputMismatchException exception) {
                        scanner.nextLine();
                        throw new UnacceptableEntryException("Digite apenas números!");
                    }
                default:
                    System.out.println("Digite uma escolha válida!");
            }

        } while (opcao > 3 || opcao < 1);

    }

    public static void iniciarEstante(){
        estante.cadastrarLivro("Guia de Volo para Monstros",
        "Livro com descrição e imagens de diversos monstros catalogados pelo mago viajante Volothamp Geddarm. ",
        150, 3);
        estante.cadastrarLivro("As Aventuras de Yohann Ibn La'Ahad: Contos do Norte", 
        "Este livro contém os contos e cantos sobre as (des)aventuras do Encantador Yohann Ibn La'Ahad quando andava pelo Norte da Costa da Espada", 
        200, 2);
    }

}

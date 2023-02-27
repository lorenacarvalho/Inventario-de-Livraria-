import java.util.InputMismatchException;
import java.util.Scanner;


public abstract class Menu {
    private static Estante estante = new Estante();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

   
        String escolha;
        do {
            escolha = exibeMenu();
        
        try{
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
                
                default:
                    System.out.println("\nDigite uma opção válida!");
            }

        } catch (BookNotFoundException ex){
            System.out.println(ex.getMessage());
           
        } catch (UnacceptableEntryException exception){
            System.out.println(exception.getMessage());
            
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

    public static void escolhaA() throws UnacceptableEntryException {

        System.out.println("Digite o título do livro: ");
        String titulo = scanner.nextLine().trim();
        Livro.validarEntradaCaracter(titulo);
        System.out.println("Digite uma descrição para o livro: ");
        String descricao = scanner.nextLine();
        Livro.validarEntradaCaracter(descricao);
        System.out.println("Digite o preço para o livro: ");
        
        try{
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

    public static void escolhaL() {
        System.out.println("\nSegue abaixo o catálogo com todos os livros!");
        estante.mostrarCatalogo();

    }

    public static void escolhaO() throws BookNotFoundException {

        System.out.println("Digite o título do livro que deseja inspecionar: ");
        String titulo = scanner.nextLine().trim();
        System.out.println("\n" + estante.buscarLivro(titulo));

    }

    public static void escolhaR() {

        System.out.println("Qual livro deseja remover? Digite o título: ");
        String exemplar = scanner.nextLine().trim();
        estante.removerLivro(exemplar);

    }

    //Pensei em colocar esse também dentro de um loop, pra aceitar apenas números e enquanto não for digitado isso, permanece nesse input
    //Mas pareceu algo besta pra eu perder tempo fazendo
    public static void escolhaE() throws UnacceptableEntryException{
        System.out.println("Qual livro que deseja acrescentar? ");
        String titulo = scanner.nextLine().trim();
        System.out.println("Quantos livros deseja somar ao catálogo? ");
        
        int quantidade = scanner.nextInt();
        estante.modificarQuantidadeExemplar(titulo, quantidade);
        scanner.nextLine();

    }

    public static void escolhaM() throws BookNotFoundException, UnacceptableEntryException{
     
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

            try{
                opcao = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException exception){
                System.out.println("---Digite uma opção válida!---");
                scanner.nextLine();
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.println("Qual o novo título para o livro -> " + exemplar.getTitulo());
                    String novoTitulo = scanner.nextLine().trim(); //dando exception nessa linha, printando o caminho da exception novamente 
                    //qnd eu já printei a mensagem a partir do teste abaixo na linha 172. whyy?
                    Livro.validarEntradaCaracter(novoTitulo);
                    exemplar.setTitulo(novoTitulo);
                    break;
                case 2:
                    System.out.println("Qual a nova descrição para o livro -> " + exemplar.getTitulo());
                    String novaDescricao = scanner.nextLine();
                    Livro.validarEntradaCaracter(novaDescricao);
                    exemplar.setDescricao(novaDescricao);
                    break;
                case 3:
                    System.out.println("Qual o novo preço para o livro -> " + exemplar.getTitulo());
                    try{
                        double novoPreco = scanner.nextDouble();
                        scanner.nextLine();
                        exemplar.setPreco(novoPreco);
                        break;
                    } catch (InputMismatchException exception){
                        scanner.nextLine();
                        throw new UnacceptableEntryException("Digite apenas números!");
                    }
                default:
                    System.out.println("Digite uma escolha válida!");
            }

        } while (opcao > 3 || opcao < 1);

    }

}

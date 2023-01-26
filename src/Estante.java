import java.util.ArrayList;
import java.util.Scanner;

public class Estante {
    private static ArrayList<Livro> catalogo;

    //Mostra todos os livros cadastrados
    public static void mostraCatalogo(){
        for(Livro refs : Estante.catalogo) {
            System.out.println("-------------");
            System.out.println(refs);
        }
    }
    
    //Cadastro de Livros 
    public static void cadastraLivros() {
        Scanner scanner = new Scanner(System.in);
        catalogo = new ArrayList<Livro>();

        System.out.println("Digite o Título do Livro: ");
        String titulo = scanner.nextLine();
        System.out.println("Digite uma descrição para o Livro: ");
        String descricao = scanner.nextLine();
        System.out.println("Determine o preço do Livro: ");
        double preco = scanner.nextDouble();
        
                
        Livro novoLivro = new Livro(titulo, descricao, preco);
        Estante.catalogo.add(novoLivro);
    
        scanner.close();
    }


    //Buscar Livro específico pelo nome



     


}

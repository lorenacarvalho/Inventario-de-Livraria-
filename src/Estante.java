import java.util.ArrayList;

public class Estante {

    private ArrayList<Livro> catalogo;

    public Estante() {
        this.catalogo = new ArrayList<Livro>();
    }

    public Livro cadastrarLivro(String titulo, String descricao, double preco, int quantidade) {
        Livro exemplar = new Livro(titulo, descricao, preco, quantidade);
        this.catalogo.add(exemplar);
        return exemplar;
    }

    public void modificarQuantidadeExemplar(String titulo, int quantidade){
        try{
            Livro exemplar = buscarLivro(titulo);
            exemplar.setQuantidade(exemplar.getQuantidade() + quantidade);
        }catch(BookNotFoundException ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }

    }

    public Livro buscarLivro(String titulo) throws BookNotFoundException {
            for (int i = 0; i < this.catalogo.size(); i++) {
                if (this.catalogo.get(i).getTitulo().equals(titulo)) {
                    return this.catalogo.get(i);
                }
            }
           
        throw new BookNotFoundException("O livro '"+ titulo + "' não existe ou foi digitado incorretamente");

    }

    public void mostrarCatalogo() {
        for (Livro i : catalogo){
            System.out.println(i);
        }
    }

    public void removerLivro(String titulo) {
        for (int i = 0; i < this.catalogo.size(); i++) {
            if (this.catalogo.get(i).getTitulo().equals(titulo)) {
                this.catalogo.remove(i);
                break;
            }
        }
    }

}

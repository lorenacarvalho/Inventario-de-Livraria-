import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Estante {

    private List<Livro> catalogo;

    public Estante() {
        this.catalogo = new ArrayList<Livro>();
    }

    public Livro cadastrarLivro(String titulo, String descricao, double preco, int quantidade) {
        Livro exemplar = new Livro(titulo, descricao, preco, quantidade);
        this.catalogo.add(exemplar);
        return exemplar;
    }

    public void modificarQuantidadeExemplar(String titulo, int quantidade) {
        try {
            Livro exemplar = buscarLivro(titulo);
            exemplar.setQuantidade(exemplar.getQuantidade() + quantidade);
        } catch (BookNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public Livro buscarLivro(String entrada) throws BookNotFoundException {
        String titulo = entrada.substring(0, 1).toUpperCase() + entrada.substring(1);
        for (int i = 0; i < this.catalogo.size(); i++) {
            if (this.catalogo.get(i).getTitulo().equals(titulo)) {
                return this.catalogo.get(i);
            }
        }

        throw new BookNotFoundException("O livro '" + titulo + "' não existe ou foi digitado incorretamente");

    }

    public void mostrarCatalogo() {
        catalogo.sort(Comparator.comparing(Livro::getTitulo));
        catalogo.forEach(exemplar -> System.out.println(exemplar));
    }

    public void removerLivro(String entrada) throws BookNotFoundException {
        String titulo = entrada.substring(0, 1).toUpperCase() + entrada.substring(1);
        for (int i = 0; i < this.catalogo.size(); i++) {
            if (this.catalogo.get(i).getTitulo().equals(titulo)) {
                this.catalogo.remove(i);
                break;
            }
        }

        throw new BookNotFoundException(
                "O livro '" + titulo + "' não foi removido pois não existe ou foi digitado incorretamente");
    }

}

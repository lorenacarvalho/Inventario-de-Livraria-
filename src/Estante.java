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

    public void modificarQuantidadeExemplar(String titulo, int quantidade) {
        Livro exemplar = buscarLivro(titulo);
        exemplar.setQuantidade(exemplar.getQuantidade() + quantidade);
    }


    //adicionar exceção ou mensagem especifica em caso de livro não existente!
    public Livro buscarLivro(String titulo) {
        for (int i = 0; i < this.catalogo.size(); i++) {
            if (this.catalogo.get(i).getTitulo().equals(titulo)) {
                return this.catalogo.get(i);
            }
        }
        return null;
    }

    public ArrayList<Livro> mostrarCatalogo() {
        return this.catalogo;
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

import java.util.ArrayList;

public class Estante {
    
    private ArrayList<Livro> catalogo;

    public Estante() {
        this.catalogo = new ArrayList<Livro>();
    }

    public Livro cadastrarLivro(String titulo, String descricao, double preco){
        Livro exemplar = new Livro(titulo, descricao, preco);
        this.catalogo.add(exemplar);
        return exemplar;        
    }

    public Livro buscarLivro(String titulo){
        for (int i = 0; i < this.catalogo.size(); i++){
            if (this.catalogo.get(i).getTitulo().equals(titulo)){
                return this.catalogo.get(i);
            }
        }
        return null;
    }

    public ArrayList<Livro> mostrarCatalogo(){
        return this.catalogo;
    }

    public void removerLivro(String titulo){
        for (int i = 0; i < this.catalogo.size(); i++){
            if (this.catalogo.get(i).getTitulo().equals(titulo)){
                this.catalogo.remove(i);
                break;
            }
        }
    }

}

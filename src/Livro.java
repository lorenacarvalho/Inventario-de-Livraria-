
public class Livro {
    private String titulo;
    private String descricao;
    private double preco;
   
    public Livro(String title, String description, double price){
        this.titulo = title;
        this.descricao = description;
        this.preco = price;
    }
   
    public String getTitulo() {
        return this.titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
   
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
   
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object ref) {
        Livro livro = (Livro) ref;
        titulo = livro.getTitulo();
        if (titulo == livro.getTitulo()) {
            return true ;
        }
        return false;
    }

    @Override
    public String toString() {
        return ("Titulo: " + getTitulo() + "\nDescrição: " + getDescricao() + "\nPreço: " + getPreco());
    }


}


public class Livro {
    private String titulo;
    private String descricao;
    private double preco;
    private int quantidade;
   
    
    public Livro(String titulo, String descricao, double preco, int quantidade){
        this.titulo = titulo;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
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
    
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
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
        return ("\nTitulo: " + getTitulo() + "\nDescrição: " + getDescricao() + "\nPreço: " + getPreco() + " PO" +
        "\nQuantidade: " + getQuantidade());
    }
    
    
}

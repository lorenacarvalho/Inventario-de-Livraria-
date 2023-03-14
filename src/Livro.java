
public class Livro implements Comparable<Livro> {
    private String titulo;
    private String descricao;
    private double preco;
    private int quantidade;

    public Livro(String titulo, String descricao, double preco, int quantidade) {
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

    public static String validarEntradaCaracter(String entrada) throws UnacceptableEntryException {
        if (entrada.isBlank()) {
            throw new UnacceptableEntryException("Não é possível título ou descrições vazias!\nTente novamente!");
        } else if (entrada.matches("[0-9]+") && entrada.length() >= 1) {
            throw new UnacceptableEntryException("Não é possível ter títulos e descrições apenas com números." +
                    "\nPor favor, tente novamente!");
        }

        return entrada.substring(0, 1).toUpperCase() + entrada.substring(1);
    }

    @Override
    public boolean equals(Object ref) {
        Livro livro = (Livro) ref;
        titulo = livro.getTitulo();
        if (titulo == livro.getTitulo()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return ("\nTitulo: " + getTitulo() + "\nDescrição: " + getDescricao() + "\nPreço: " + getPreco() + " PO" +
                "\nQuantidade: " + getQuantidade());
    }

    @Override
    public int compareTo(Livro outroLivro) {
        return this.getTitulo().compareTo(outroLivro.getTitulo());
    }

}

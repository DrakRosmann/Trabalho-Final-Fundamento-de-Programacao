public class Inscricao {
    private int numero;
    private String nome;
    private String categoria;
    private double preco;
    private String cpf;
    private String cargo;
    private String instituicao;

    public Inscricao(int numero, String nome, String categoria, String cpf, String cargo, String instituicao) {
        this.numero = numero;
        this.nome = nome;
        this.categoria = categoria;
        this.cpf = cpf;
        this.cargo = cargo;
        this.instituicao = instituicao;
        definirPreco();
    }

    private void definirPreco() {
        if (categoria.equalsIgnoreCase("Aluno")) {
            this.preco = 50.0;
        } else if (categoria.equalsIgnoreCase("Professor")) {
            this.preco = 100.0;
        } else {
            this.preco = 200.0;
        }
    }

    public String getCpf() {
        return cpf;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Inscrito: " + nome + " | Cat: " + categoria + " | Valor: R$" + preco;
    }
}
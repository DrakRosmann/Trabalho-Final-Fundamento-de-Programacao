public class Inscricao {
    private int numeroInscricao; // Identificação [cite: 26]
    private String nome;         // [cite: 27]
    private String categoria;    // [cite: 28] (Ex: Aluno, Professor, Empresario)
    private double preco;        // [cite: 29]
    private String cpf;          // [cite: 30]
    private String cargo;        // [cite: 31]
    private String instituicao;  // [cite: 32]

    public Inscricao(int numeroInscricao, String nome, String categoria, String cpf, String cargo, String instituicao) {
        this.numeroInscricao = numeroInscricao;
        this.nome = nome;
        this.categoria = categoria;
        this.cpf = cpf;
        this.cargo = cargo;
        this.instituicao = instituicao;
        this.definirPreco(); // Regra de negócio automática
    }

    // Lógica para definir preço baseado na categoria [cite: 6, 29]
    private void definirPreco() {
        if (this.categoria.equalsIgnoreCase("Aluno")) {
            this.preco = 50.0;
        } else if (this.categoria.equalsIgnoreCase("Professor")) {
            this.preco = 100.0;
        } else {
            this.preco = 200.0; // Empresário ou outros
        }
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public String getCategoria() { return categoria; }
    public double getPreco() { return preco; }
    public String getCpf() { return cpf; }

    @Override
    public String toString() {
        return "Inscrito: " + nome + " (" + categoria + ") - Valor: R$ " + preco;
    }
}
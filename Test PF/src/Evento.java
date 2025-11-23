import java.time.LocalDate;
import java.util.ArrayList;

public class Evento {
    // Atributos [cite: 12]
    private String codigo;
    private String nome;
    private String tipo; // feira, congresso, etc.
    private LocalDate dataInicial; // [cite: 17]
    private LocalDate dataFinal;
    private double valorLocacaoEspaco; // [cite: 24]

    // Listas (Vetores de Objetos) [cite: 35]
    private ArrayList<Sala> salas;
    private ArrayList<Inscricao> inscritos;

    public Evento(String codigo, String nome, String tipo, LocalDate dataInicial, LocalDate dataFinal, double valorLocacaoEspaco) {
        this.codigo = codigo;
        this.nome = nome;
        this.tipo = tipo;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.valorLocacaoEspaco = valorLocacaoEspaco;
        this.salas = new ArrayList<>();
        this.inscritos = new ArrayList<>();
    }

    // --- MÉTODOS DE MANIPULAÇÃO DE VETORES (REQUISITO PDF) ---

    // 1. Adicionar sala [cite: 38]
    public void adicionarSala(Sala sala) {
        salas.add(sala);
    }

    // 2. Remover sala [cite: 39]
    public boolean removerSala(String idSala) {
        return salas.removeIf(s -> s.getIdentificacao().equals(idSala));
    }

    // 3. Buscar salas por capacidade mínima [cite: 40]
    public ArrayList<Sala> buscarSalasPorCapacidade(int capacidadeMinima) {
        ArrayList<Sala> resultado = new ArrayList<>();
        for (Sala s : salas) {
            if (s.getLotacaoMaxima() >= capacidadeMinima) {
                resultado.add(s);
            }
        }
        return resultado;
    }

    // 4. Adicionar Inscrição (Necessário para gerir a lista de inscritos)
    public void adicionarInscricao(Inscricao inscricao) {
        inscritos.add(inscricao);
    }

    // 5. Identificar se pessoa está inscrita (busca por CPF) [cite: 44]
    public boolean isPessoaInscrita(String cpf) {
        for (Inscricao i : inscritos) {
            if (i.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    // 6. Quantidade de inscritos por categoria 
    public int contarInscritosPorCategoria(String categoria) {
        int cont = 0;
        for (Inscricao i : inscritos) {
            if (i.getCategoria().equalsIgnoreCase(categoria)) {
                cont++;
            }
        }
        return cont;
    }

    // 7. Calcular valor total arrecadado 
    public double calcularArrecadacaoTotal() {
        double total = 0;
        for (Inscricao i : inscritos) {
            total += i.getPreco();
        }
        return total;
    }

    // Getters básicos necessários
    public String getNome() { return nome; }
    public LocalDate getDataInicial() { return dataInicial; }
    public ArrayList<Inscricao> getInscritos() { return inscritos; } // [cite: 48]
    public ArrayList<Sala> getSalas() { return salas; }

    @Override
    public String toString() {
        return "Evento: " + nome + " (" + tipo + ") - Data: " + dataInicial;
    }
}
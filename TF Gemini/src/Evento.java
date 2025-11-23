import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Evento {
    private String codigo;
    private String nome;
    private String tipo;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private List<Sala> salas;
    private List<Inscricao> inscritos;

    public Evento(String codigo, String nome, String tipo, LocalDate dataInicial, LocalDate dataFinal) {
        this.codigo = codigo;
        this.nome = nome;
        this.tipo = tipo;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.salas = new ArrayList<>();
        this.inscritos = new ArrayList<>();
    }

    public void adicionarSala(Sala sala) {
        salas.add(sala);
    }

    public boolean removerSala(String idSala) {
        return salas.removeIf(s -> s.getIdentificacao().equalsIgnoreCase(idSala));
    }

    public boolean adicionarInscricao(Inscricao inscricao) {
        if (isPessoaInscrita(inscricao.getCpf())) {
            return false;
        }
        inscritos.add(inscricao);
        return true;
    }

    public List<Sala> buscarSalasPorCapacidade(int capacidadeMinima) {
        List<Sala> resultado = new ArrayList<>();
        for (Sala s : salas) {
            if (s.getLotacaoMaxima() >= capacidadeMinima) {
                resultado.add(s);
            }
        }
        return resultado;
    }

    public boolean isPessoaInscrita(String cpf) {
        for (Inscricao i : inscritos) {
            if (i.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    public int contarInscritosPorCategoria(String categoria) {
        int contador = 0;
        for (Inscricao i : inscritos) {
            if (i.getCategoria().equalsIgnoreCase(categoria)) {
                contador++;
            }
        }
        return contador;
    }

    public double calcularArrecadacaoTotal() {
        double total = 0;
        for (Inscricao i : inscritos) {
            total += i.getPreco();
        }
        return total;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public List<Inscricao> getInscritos() {
        return inscritos;
    }

    @Override
    public String toString() {
        return "Evento: " + nome + " (" + tipo + ") - Início: " + dataInicial;
    }
}
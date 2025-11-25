import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Evento {
    private String codigo;
    private String nome;
    private String tipoEvento;
    private LocalDate dataInicio;
    private LocalDate dataFinal;
    private List<Sala> salas;
    private List<Inscricao> inscritos;

    public Evento(String codigo, String nome, int tipo, LocalDate dataInicio, LocalDate dataFinal) {
        this.codigo = codigo;
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.salas = new ArrayList<>();
        this.inscritos = new ArrayList<>();

        switch (tipo) {
            case 1: this.tipoEvento = "Congresso"; break;
            case 2: this.tipoEvento = "Feira"; break;
            case 3: this.tipoEvento = "Seminário"; break;
            default: this.tipoEvento = "Outro";
        }
    }

    public void adicionarSala(Sala sala) {
        salas.add(sala);
    }

    public boolean removerSala(String idSala) {
        return salas.removeIf(s -> s.getIdentificacao().equalsIgnoreCase(idSala));
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

    public boolean adicionarInscrito(Inscricao inscricao) {
        if (isPessoaInscrita(inscricao.getCpf())) {
            return false;
        }
        inscritos.add(inscricao);
        return true;
    }

    public boolean removerInscrito(int numeroInscricao) {
        return inscritos.removeIf(i -> i.getNumero() == numeroInscricao);
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

    public double calcularTotalArrecadado() {
        double total = 0;
        for (Inscricao i : inscritos) {
            total += i.getPreco();
        }
        return total;
    }

    public double calcularCustoSalas() {
        double total = 0;
        for (Sala s : salas) {
            total += s.getValorLocacao();
        }
        return total;
    }

    public String getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public String getTipoEvento() { return tipoEvento; }
    public List<Sala> getSalas() { return salas; }
    public List<Inscricao> getInscritos() { return inscritos; }

    @Override
    public String toString() {
        return "Evento " + codigo + ": " + nome + " (" + tipoEvento + ") | Início: " + dataInicio;
    }
}
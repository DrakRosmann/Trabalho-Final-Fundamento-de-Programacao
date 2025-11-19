import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Evento {
    int codigo;
    String nome;
    tipoEvento tipo;
    LocalDate dataInicio;
    LocalDate dataFinal;
    int quantSalas;
    List<Inscritos> inscritos = new ArrayList<Inscritos>();
    List<Sala> salas = new ArrayList<Sala>();

    public Evento(int codigo, String nome, tipoEvento tipo, int quantSalas, LocalDate dataInicio, LocalDate dataFinal, Sala sala) {
        this.codigo = codigo;
        this.nome = nome;
        this.tipo = tipo;
        this.quantSalas = quantSalas;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        salas.add(sala);
    }

}

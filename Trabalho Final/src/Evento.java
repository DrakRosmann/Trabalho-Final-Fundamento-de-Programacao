import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Evento {
    int codigo=0;
    String nome;
    String tipoEvento;
    LocalDate dataInicio;
    LocalDate dataFinal;
    int quantSalas;
    Sala[] sala;
    int indexSala;
    int indexInscritos;
    Inscritos[] inscritos;

    public Evento(String nome,int tipo, int quantSalas, String dataInicio, String dataFinal, int quantInsc) {
        codigo++;
        this.nome = nome;
        this.quantSalas = quantSalas;
        this.dataInicio = LocalDate.parse(dataInicio);
        this.dataFinal = LocalDate.parse(dataFinal);
        switch (tipo){
            case 1:
                tipoEvento = "Congresso";
                break;
            case 2:
                tipoEvento = "Feira";
                break;
            case 3:
                tipoEvento = "Seminário";
        }
        sala = new Sala[quantSalas];
        indexSala = 0;
        indexInscritos = 0;
        inscritos = new Inscritos[quantInsc];
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public int getQuantSalas() {
        return quantSalas;
    }

    public void setQuantSalas(int quantSalas) {
        this.quantSalas = quantSalas;
    }

    public Inscritos[] getInscritos() {
        return inscritos;
    }

    public int getIndexSala() {
        return indexSala;
    }

    public void addSala(Sala sl,int quant) {
        sala[indexSala] = sl;
        indexSala++;
    }

    public void addIncritos(Inscritos ins){
        inscritos[indexInscritos] = ins;
        indexInscritos++;
    }

    public void removeSala(int id){
        for (Sala sl: sala){
            if (sl.getId() == id){
                sala[indexSala] = null;
            }
        }
    }

    public Sala[] salaLoc(int quant){
        Sala[] vet = new Sala[quantSalas];
        int i=0;
        for (Sala sl : sala){
            if (sl.getLotacao_max() == quant){
                vet[i] = sl;
                i++;
            }
        }
        return vet;
    }

    public boolean pessoaEvento(String nome){
        for (Inscritos ins : inscritos){
            if(ins.getNome().equals(nome)){
                return true;
            }
            else return false;
        }
        return false;
    }

    public double valorTotalIncritos(){
        double valor=0;
        for (Inscritos ins : inscritos){
            valor+=ins.getPreco();
        }
        return valor;
    }
}

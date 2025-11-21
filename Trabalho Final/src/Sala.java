public class Sala {
    int id=0;
    String local;
    int lotacao_max;
    double valor;

    public Sala(String local, int lotacao_max, double valor) {
        id++;
        this.local = local;
        this.lotacao_max = lotacao_max;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getLotacao_max() {
        return lotacao_max;
    }

    public void setLotacao_max(int lotacao_max) {
        this.lotacao_max = lotacao_max;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}

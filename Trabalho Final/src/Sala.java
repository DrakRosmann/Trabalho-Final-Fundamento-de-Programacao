public class Sala {
    int id=0;
    String local;
    int lotacao_max;
    double valor;
    boolean reservado;

    public Sala(String local, int lotacao_max, double valor,boolean reservado) {
        id++;
        this.local = local;
        this.lotacao_max = lotacao_max;
        this.valor = valor;
        this.reservado = reservado;
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

    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    @Override
    public String toString() {
        return "Sala: "+id+" | Local: "+local+" | Locação maxima: "+lotacao_max+" | Valor: R$"+valor;
    }
}

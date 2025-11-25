public class Sala {
    private String identificacao;
    private String localizacao;
    private int lotacaoMaxima;
    private double valorLocacao;
    private boolean reservada;

    public Sala(String identificacao, String localizacao, int lotacaoMaxima, double valorLocacao) {
        this.identificacao = identificacao;
        this.localizacao = localizacao;
        this.lotacaoMaxima = lotacaoMaxima;
        this.valorLocacao = valorLocacao;
        this.reservada = false;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public int getLotacaoMaxima() {
        return lotacaoMaxima;
    }

    public double getValorLocacao() {
        return valorLocacao;
    }

    public boolean isReservada() {
        return reservada;
    }

    public void setReservada(boolean reservada) {
        this.reservada = reservada;
    }

    @Override
    public String toString() {
        return "Sala " + identificacao + " (" + localizacao + ") | Lotação Maxima: " + lotacaoMaxima + " | R$" + valorLocacao;
    }
}
public class Sala {
    private String identificacao;
    private String localizacao;
    private int lotacaoMaxima;
    private double valorLocacao;

    public Sala(String identificacao, String localizacao, int lotacaoMaxima, double valorLocacao) {
        this.identificacao = identificacao;
        this.localizacao = localizacao;
        this.lotacaoMaxima = lotacaoMaxima;
        this.valorLocacao = valorLocacao;
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

    @Override
    public String toString() {
        return "Sala " + identificacao + " (" + localizacao + ") - Cap: " + lotacaoMaxima + " - R$" + valorLocacao;
    }
}
public class Sala {
    private String identificacao; // [cite: 21]
    private String localizacao;   // [cite: 22]
    private int lotacaoMaxima;    // [cite: 23]

    public Sala(String identificacao, String localizacao, int lotacaoMaxima) {
        this.identificacao = identificacao;
        this.localizacao = localizacao;
        this.lotacaoMaxima = lotacaoMaxima;
    }

    // Getters e Setters [cite: 34]
    public String getIdentificacao() { return identificacao; }
    public void setIdentificacao(String identificacao) { this.identificacao = identificacao; }

    public String getLocalizacao() { return localizacao; }
    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }

    public int getLotacaoMaxima() { return lotacaoMaxima; }
    public void setLotacaoMaxima(int lotacaoMaxima) { this.lotacaoMaxima = lotacaoMaxima; }

    @Override
    public String toString() {
        return "Sala: " + identificacao + " | Local: " + localizacao + " | Cap: " + lotacaoMaxima;
    }
}
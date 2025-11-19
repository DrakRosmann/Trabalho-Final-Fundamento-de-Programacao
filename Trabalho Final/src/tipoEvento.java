public enum tipoEvento {
    FEIRA("Feira"),
    CONGRESSO("Congresso"),
    SEMINARIO("Seminario");

    private String tipo;

    tipoEvento(String tipo){
        this.tipo = tipo;
    }

    public String getTipo(){
        return tipo;
    }
}

public enum Categoria {
    ALUNO(100.0),
    PROFESSOR(150.0),
    EMPRESSARIO(300.0);

    private Double cat;

    Categoria(Double cat){
        this.cat = cat;
    }

    public Double getCat(){
        return cat;
    }
}

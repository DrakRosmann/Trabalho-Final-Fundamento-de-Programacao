public class Inscritos {
    int id=0;
    String nome;
    String cat;
    double preco;
    String cpf;
    String cargo;
    String institucao;

    public Inscritos(String nome, int cat, String cpf, String cargo, String institucao) {
        id++;
        this.nome = nome;
        this.cat = cat;
        this.cpf = cpf;
        this.cargo = cargo;
        this.institucao = institucao;
        switch (cat){
            case 1:
                preco = 200;
                this.cat="Funcionário";
                break;
            case 2:
                preco = 300;
                this.cat="Aluno";
                break;
            case 3:
                preco = 150;
                this.cat="Professor";
                break;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCat() {
        return cat;
    }

    public String getCat_nome() {
        return cat_nome;
    }

    public void setCat(int cat) {
        this.cat = cat;
    }



    public void setPreco() {

    }
    public double getPreco() {
        return preco;
    }
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getInstitucao() {
        return institucao;
    }

    public void setInstitucao(String institucao) {
        this.institucao = institucao;
    }
}

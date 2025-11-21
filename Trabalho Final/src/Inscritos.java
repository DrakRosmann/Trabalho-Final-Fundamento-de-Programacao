public class Inscritos {
    int id=0;
    String nome;
    int cat;
    String cat_nome;
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

    public double getPreco() {
        return preco;
    }

    public void setPreco() {
        switch (cat){
            case 1:
                preco = 200;
                cat_nome="Funcionário";
                break;
            case 2:
                preco = 300;
                cat_nome="Aluno";
                break;
            case 3:
                preco = 150;
                cat_nome="Professor";
                break;
        }
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

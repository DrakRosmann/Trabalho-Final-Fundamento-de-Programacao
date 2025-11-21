public class Inscritos {
    int id=0;
    String nome;
    String cat;
    double preco;
    String cpf;
    String cargo;
    String institucao;

    public Inscritos(String nome, String cat, String cpf, String cargo, String institucao) {
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

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco() {
        switch (cat){
            case "Funcionario":
                preco = 200;
                break;
            case "Aluno":
                preco = 300;
                break;
            case "Professor":
                preco = 150;
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

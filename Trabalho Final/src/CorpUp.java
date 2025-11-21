import java.time.LocalDate;
import java.util.Scanner;

public class CorpUp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        menu();
        int sel = in.nextInt();
        switch (sel){
            case 1:
                criarEvento();
                break;
        }
    }

    public static void menu(){
        System.out.println("CorpUp Eventos.");
        System.out.println("1. Criar Evento.");
        System.out.println("2. Imprimir Evento.");
        System.out.println("3. Excluir Evento.");
        System.out.println("4. Listar Eventos.");
        System.out.println("5. Excluir Evento.");
        System.out.print("Sel: ");
    }

    public static void criarEvento(){
        Scanner in = new Scanner(System.in);
        System.out.print("Nome do evento: ");
        String nome = in.nextLine();
        System.out.print("Tipo de evento:\n1-Congresso;\n2-Feira;\n3-Seminario\nSel:  ");
        int tipoEvento = in.nextInt();
        System.out.print("Data de inicio(ano-mês-dia): ");
        String dataInicio = in.next();
        System.out.print("Data de fim(ano-mês-dia): ");
        String dataFim = in.next();
        System.out.print("Quantidade de salas necessarias: ");
        int quantidade = in.nextInt();
        System.out.println("Quantidade de inscritos: ");
        int quantidadeInscritos = in.nextInt();
        Evento evento = new Evento(nome,tipoEvento,quantidade,dataInicio,dataFim,quantidadeInscritos);
        for (int i=0;i<quantidadeInscritos;i++){
            evento.addIncritos(adicionarInscritos());
        }
    }

    public static Inscritos adicionarInscritos(){
        Scanner in = new Scanner(System.in);
        System.out.print("Nome: ");
        String nome = in.nextLine();
        System.out.print("Categoria da inscrição:\n1-Funcionario(R$200)\n2-Aluno(R$300)\n3-Professor(R$150)\nSel: ");
        int cat = in.nextInt();
        System.out.print("CPF: ");
        String cpf = in.nextLine();
        System.out.print("Cargo: ");
        String cargo = in.nextLine();
        System.out.print("Instituição: ");
        String instituicao = in.nextLine();
        Inscritos inscritos = new Inscritos(nome,cat,cpf,cargo,instituicao);
        return inscritos;
    }
}

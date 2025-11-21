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
        System.out.println("Data de inicio(ano-mês-dia): ");
        String dataInicio = in.nextLine();
        System.out.print("Data de fim(ano-mês-dia): ");
        String dataFim = in.nextLine();
        System.out.print("Quantidade de salas necessarias: ");
        int quantidade = in.nextInt();
        System.out.println("Quantidade de inscritos: ");
        int quantidadeInscritos = in.nextInt();
    }
}

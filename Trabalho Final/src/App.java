import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static List<Evento> eventos = new ArrayList<Evento>();
    private static List<Sala> salas = new ArrayList<Sala>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("-----------");
        int p=0;
        do{
            menu();
            int sel = in.nextInt();
            switch (sel){
                case 1:
                    eventos.add(criarEvento());
                    break;
                case 2:
                    System.out.println(selecionarEvento().toString());
                    break;
                case 3:

                case 4:
                    criarSala();
                    break;
                case 5:
                    listarSala();
                    break;
                case 6:
                    selecionarEvento().listarInscritos();
                    break;
                case 7:
                    removerInscrito();
                    break;
                case 8:
                    adicionaInscrito();

            }
            System.out.print("\nDeseja realizar mais alguma ação (1-Sim | 2-Não)? ");
            p = in.nextInt();
            System.out.println();
        }while (p == 1);
    }

    public static void menu(){
        System.out.println("App CorpUp Eventos.");
        System.out.println("1. Criar Evento.");
        System.out.println("2. Listar Evento.");
        System.out.println("3. Excluir Evento.");
        System.out.println("4. Criar sala.");
        System.out.println("5. Listar salas.");
        System.out.println("6. Listar inscritos de um evento.");
        System.out.println("7. Remover inscrito de evento.");
        System.out.println("8. Adicionar inscrito ao um evento.");
        System.out.print("Sel: ");
    }

    public static Evento criarEvento(){
        Scanner in = new Scanner(System.in);
        System.out.print("Nome do evento: ");
        String nome = in.nextLine();
        System.out.print("Tipo de evento:\n1-Congresso;\n2-Feira;\n3-Seminario\nSel:  ");
        int tipoEvento = in.nextInt();
        System.out.print("Data de inicio(aaaa-mm-dd): ");
        String dataInicio = in.next();
        System.out.print("Data de fim(aaaa-mm-dd): ");
        String dataFim = in.next();
        System.out.print("Quantidade de salas necessarias: ");
        int quantidade = in.nextInt();
        System.out.print("Quantidade de inscritos: ");
        int quantidadeInscritos = in.nextInt();
        Evento evento = new Evento(nome,tipoEvento,quantidade,dataInicio,dataFim,quantidadeInscritos);
        for (int i=0;i<quantidadeInscritos;i++){
            System.out.println("Adicionar inscrito numero "+(i+1)+":");
            System.out.println("---------");
            evento.addIncritos(adicionarInscritos());
        }

        for (int i=0;i<salas.size();i++){
            if (salas.get(i).getLotacao_max()>=quantidadeInscritos && !salas.get(i).isReservado()){
                for (int j=0;j<quantidade;j++){
                    System.out.printf("Selecione a %dª sala: \n",j+1);
                    evento.addSala(selecionarSala());
                }
            }else {
                System.out.println("Não a salas disponiveis.");
                return null;
            }
        }
        System.out.printf("\nEvento de numero %d criado com sucesso.\n",evento.getCodigo());
        System.out.printf("\nValor total por inscrito: R$%.1f\n",evento.valorTotalIncritos());
        System.out.printf("\nValor total da locação: R$%.1f\n",evento.valorTotalSala());
        return evento;
    }

    public static Inscritos adicionarInscritos(){
        Scanner in = new Scanner(System.in);
        System.out.print("Nome: ");
        String nome = in.nextLine();
        System.out.print("Categoria da inscrição:\n1-Funcionario(R$200)\n2-Aluno(R$300)\n3-Professor(R$150)\nSel: ");
        int cat = in.nextInt();
        System.out.print("CPF: ");
        String cpf = in.next();
        System.out.print("Cargo: ");
        String cargo = in.next();
        System.out.print("Instituição: ");
        String instituicao = in.next();
        return new Inscritos(nome,cat,cpf,cargo,instituicao);
    }

    public static void criarSala(){
        Scanner in = new Scanner(System.in);
        System.out.print("Local: ");
        in.next();
        String local = in.nextLine();
        System.out.print("Locação maxima: ");
        int locacao = in.nextInt();
        System.out.print("Valor da locação: R$");
        double valor = in.nextDouble();
        Sala sl = new Sala(local,locacao,valor,false);
        salas.add(sl);

    }

    public static Sala selecionarSala(){
        Scanner in = new Scanner(System.in);
        if (salas.isEmpty()) {
            System.out.println("Nenhuma sala cadastrada.");
            return null;
        }
        for (int i=0;i<salas.size();i++){
            System.out.println((i+1)+". "+salas.get(i).toString());
        }
        System.out.print("Selecione a sala: ");
        int sele = in.nextInt();
        salas.get(sele -1).setReservado(true);
        return salas.get(sele -1);
    }

    public static void listarSala(){
        if (salas.isEmpty()) {
            System.out.println("Nenhuma sala cadastrada.");
        }
        for (int i=0;i<salas.size();i++){
            if (salas.get(i).isReservado()){
                System.out.println((i+1)+". "+salas.get(i).toString()+" Status: Reservado.");
            }else {
                System.out.println((i+1)+". "+salas.get(i).toString()+" Status: Não reservado");
            }
        }
    }

    public static Evento selecionarEvento(){
        Scanner in = new Scanner(System.in);
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento cadastrado.");
            return null;
        }
        for (int i=0;i<eventos.size();i++){
            System.out.printf("%d. Evento: %s | código: %d | tipo: %s\n",i+1,eventos.get(i).getNome(),eventos.get(i).getCodigo(),eventos.get(i).getTipoEvento());
        }
        System.out.print("Selecione o evento: ");
        int sel = in.nextInt();
        return eventos.get(sel-1);
    }

    public static void adicionaInscrito(){
        Scanner in = new Scanner(System.in);
        selecionarEvento().addIncritos(adicionarInscritos());
    }

    public static void removerInscrito(){
        Scanner in = new Scanner(System.in);
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento cadastrado.");
        }
        for (int i=0;i<eventos.size();i++){
            System.out.printf("%d. Evento: %s | código: %d | tipo: %s\n",i+1,eventos.get(i).getNome(),eventos.get(i).getCodigo(),eventos.get(i).getTipoEvento());
        }
        System.out.print("Selecione o evento: ");
        int sel = in.nextInt();
        eventos.get(sel-1).listarInscritos();
        System.out.print("Qual selecione o ID da pessoa para remover: ");
        int id = in.nextInt();
        eventos.get(sel-1).removeInscrito(id);
    }
}

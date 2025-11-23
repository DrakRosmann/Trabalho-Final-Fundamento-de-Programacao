import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static List<Evento> eventos = new ArrayList<>();
    private static List<Sala> bancoDeSalas = new ArrayList<>();
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = 0;
        do {
            menu();
            opcao = in.nextInt();
            in.nextLine();

            switch (opcao) {
                case 1:
                    criarEvento();
                    break;
                case 2:
                    criarSalaNoBanco();
                    break;
                case 3:
                    gerenciarSalasEvento();
                    break;
                case 4:
                    realizarInscricao();
                    break;
                case 5:
                    relatoriosEvento();
                    break;
                case 6:
                    listarTodosEventos();
                    break;
                case 0:
                    System.out.println("Saindo.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    public static void menu() {
        System.out.println("\n--- CORPUP EVENTOS ---");
        System.out.println("1. Criar Evento");
        System.out.println("2. Cadastrar Sala (Banco de Salas)");
        System.out.println("3. Gerenciar Salas de um Evento");
        System.out.println("4. Realizar Inscrição em Evento");
        System.out.println("5. Relatórios");
        System.out.println("6. Listar Todos os Eventos");
        System.out.println("0. Sair");
        System.out.print("Selecione: ");
    }

    public static void criarEvento() {
        System.out.println("--- Novo Evento ---");
        System.out.print("Código do Evento: ");
        String cod = in.nextLine();

        System.out.print("Nome: ");
        String nome = in.nextLine();

        System.out.print("Tipo (Congresso/Feira/Seminário): ");
        String tipo = in.nextLine();

        System.out.print("Data Início (aaaa-mm-dd): ");
        LocalDate dtIni = LocalDate.parse(in.nextLine());

        System.out.print("Data Fim (aaaa-mm-dd): ");
        LocalDate dtFim = LocalDate.parse(in.nextLine());

        Evento ev = new Evento(cod, nome, tipo, dtIni, dtFim);
        eventos.add(ev);
        System.out.println("Evento criado com sucesso!");
    }

    public static void criarSalaNoBanco() {
        System.out.println("--- Nova Sala ---");
        System.out.print("Identificação da Sala (ex: A101): ");
        String id = in.nextLine();

        System.out.print("Localização (Prédio/Andar): ");
        String local = in.nextLine();

        System.out.print("Lotação Máxima: ");
        int cap = in.nextInt();
        in.nextLine();

        System.out.print("Valor da Locação: ");
        double valor = in.nextDouble();
        in.nextLine();

        Sala sala = new Sala(id, local, cap, valor);
        bancoDeSalas.add(sala);
        System.out.println("Sala cadastrada no banco geral.");
    }

    public static void gerenciarSalasEvento() {
        Evento ev = selecionarEvento();
        if (ev == null) return;

        System.out.println("1. Adicionar Sala ao Evento");
        System.out.println("2. Remover Sala do Evento");
        System.out.print("Opção: ");
        int op = in.nextInt();
        in.nextLine();

        if (op == 1) {
            if (bancoDeSalas.isEmpty()) {
                System.out.println("Não há salas cadastradas no sistema.");
                return;
            }
            for (int i = 0; i < bancoDeSalas.size(); i++) {
                System.out.println((i + 1) + ". " + bancoDeSalas.get(i));
            }
            System.out.print("Selecione a sala para adicionar: ");
            int sel = in.nextInt() - 1;
            in.nextLine();

            if (sel >= 0 && sel < bancoDeSalas.size()) {
                ev.adicionarSala(bancoDeSalas.get(sel));
                System.out.println("Sala adicionada ao evento!");
            }
        } else if (op == 2) {
            System.out.print("Digite a Identificação da Sala para remover: ");
            String idSala = in.nextLine();
            boolean removeu = ev.removerSala(idSala);
            if (removeu) {
                System.out.println("Sala removida.");
            } else {
                System.out.println("Sala não encontrada neste evento.");
            }
        }
    }

    public static void realizarInscricao() {
        Evento ev = selecionarEvento();
        if (ev == null) return;

        System.out.println("--- Nova Inscrição ---");
        System.out.print("Número da Inscrição: ");
        int num = in.nextInt();
        in.nextLine();

        System.out.print("Nome do Participante: ");
        String nome = in.nextLine();

        System.out.print("CPF: ");
        String cpf = in.nextLine();

        System.out.print("Categoria (Aluno/Professor/Outro): ");
        String cat = in.nextLine();

        System.out.print("Cargo: ");
        String cargo = in.nextLine();

        System.out.print("Instituição: ");
        String inst = in.nextLine();

        Inscricao insc = new Inscricao(num, nome, cat, cpf, cargo, inst);

        if (ev.adicionarInscricao(insc)) {
            System.out.println("Inscrição realizada! Valor a pagar: R$" + insc.getPreco());
        } else {
            System.out.println("Erro: CPF já inscrito neste evento.");
        }
    }

    public static void relatoriosEvento() {
        Evento ev = selecionarEvento();
        if (ev == null) return;

        System.out.println("\n--- RELATÓRIO: " + ev.getNome() + " ---");
        System.out.println("Total Arrecadado: R$ " + ev.calcularArrecadacaoTotal());

        System.out.print("Deseja filtrar inscritos por categoria? (1-Sim/2-Não): ");
        int opcao = in.nextInt();
        in.nextLine();

        if (opcao == 1) {
            System.out.print("Qual categoria? ");
            String cat = in.nextLine();
            System.out.println("Total de " + cat + ": " + ev.contarInscritosPorCategoria(cat));
        }

        System.out.println("--- Lista de Salas do Evento ---");
        for (Sala s : ev.getSalas()) {
            System.out.println(s);
        }

        System.out.println("--- Lista de Inscritos ---");
        for (Inscricao i : ev.getInscritos()) {
            System.out.println(i);
        }
    }

    public static void listarTodosEventos() {
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento.");
        }
        for (Evento e : eventos) {
            System.out.println(e);
        }
    }

    public static Evento selecionarEvento() {
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento cadastrado.");
            return null;
        }
        for (int i = 0; i < eventos.size(); i++) {
            System.out.println((i + 1) + ". " + eventos.get(i).toString());
        }
        System.out.print("Selecione o Evento: ");
        int sel = in.nextInt() - 1;
        in.nextLine();

        if (sel >= 0 && sel < eventos.size()) {
            return eventos.get(sel);
        }
        System.out.println("Opção inválida.");
        return null;
    }
}
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static List<Evento> eventos = new ArrayList<>();
    private static List<Sala> bancoSalas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int opcao = 0;
        int sel = 0;
        do {
            menu();
            opcao = in.nextInt();
            in.nextLine();

            switch (opcao) {
                case 1:
                    criarEvento(in);
                    break;
                case 2:
                    listarEventos();
                    break;
                case 3:
                    removerEvento(in);
                    break;
                case 4:
                    criarSala(in);
                    break;
                case 5:
                    listarTodasSalas();
                    break;
                case 6:
                    gerenciarSalasEvento(in);
                    break;
                case 7:
                    adicionarInscritoEvento(in);
                    break;
                case 8:
                    removerInscritoEvento(in);
                    break;
                case 9:
                    mostrarRelatorios(in);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
            System.out.print("\nGostaria de realizar mais alguma ação? (1-Sim | 2-Não) ");
            sel = in.nextInt();
        } while (sel != 2);
    }

    public static void menu() {
        System.out.println("\n--- CorpUP Eventos ---");
        System.out.println("1. Criar Evento");
        System.out.println("2. Listar Eventos");
        System.out.println("3. Remover Evento");
        System.out.println("4. Cadastrar Sala");
        System.out.println("5. Listar Todas as Salas");
        System.out.println("6. Gerenciar Salas de um Evento (Adicionar/Remover)");
        System.out.println("7. Adicionar Inscrito em Evento");
        System.out.println("8. Remover Inscrito de Evento");
        System.out.println("9. Relatórios Eventos");
        System.out.print("Selecione: ");
    }

    public static void criarEvento(Scanner in) {
        System.out.println("--- Criar Evento ---");
        System.out.print("Código do Evento: ");
        String cod = in.nextLine();

        System.out.print("Nome do Evento: ");
        String nome = in.nextLine();

        System.out.print("Tipo (1-Congresso, 2-Feira, 3-Seminário): ");
        int tipo = in.nextInt();
        in.nextLine();

        System.out.print("Data Início (aaaa-mm-dd): ");
        LocalDate dtIni = LocalDate.parse(in.nextLine());

        System.out.print("Data Fim (aaaa-mm-dd): ");
        LocalDate dtFim = LocalDate.parse(in.nextLine());

        Evento ev = new Evento(cod, nome, tipo, dtIni, dtFim);
        eventos.add(ev);
        System.out.println("Evento criado com sucesso.");
    }

    public static void criarSala(Scanner in) {
        System.out.println("--- Nova Sala ---");
        System.out.print("Identificação (ex: A101): ");
        String id = in.nextLine();

        System.out.print("Localização: ");
        String local = in.nextLine();

        System.out.print("Lotação Máxima: ");
        int lotacao = in.nextInt();

        System.out.print("Valor Locação: ");
        double valor = in.nextDouble();
        in.nextLine();

        Sala sala = new Sala(id, local, lotacao, valor);
        bancoSalas.add(sala);
        System.out.println("Sala cadastrada no sistema.");
    }

    public static void gerenciarSalasEvento(Scanner in) {
        Evento ev = selecionarEvento(in);
        if (ev == null) return;

        System.out.println("1. Adicionar Sala ao Evento");
        System.out.println("2. Remover Sala do Evento");
        int op = in.nextInt();
        in.nextLine();

        if (op == 1) {
            listarTodasSalas();
            System.out.print("Digite a identificação da sala para adicionar: ");
            String idSala = in.nextLine();

            Sala salaEncontrada = null;
            for (Sala s : bancoSalas) {
                if (s.getIdentificacao().equalsIgnoreCase(idSala)) {
                    salaEncontrada = s;
                    break;
                }
            }

            if (salaEncontrada != null) {
                ev.adicionarSala(salaEncontrada);
                System.out.println("Sala vinculada ao evento.");
            } else {
                System.out.println("Sala não encontrada.");
            }
        } else if (op == 2) {
            System.out.print("Digite a identificação da sala para remover: ");
            String idSala = in.nextLine();
            if (ev.removerSala(idSala)) {
                System.out.println("Sala removida do evento.");
            } else {
                System.out.println("Sala não estava vinculada.");
            }
        }
    }

    public static void adicionarInscritoEvento(Scanner in) {
        Evento ev = selecionarEvento(in);
        if (ev == null) return;

        System.out.print("Número da Inscrição: ");
        int num = in.nextInt();
        in.nextLine();

        System.out.print("Nome: ");
        String nome = in.nextLine();

        System.out.print("Categoria (Aluno/Professor/Outro): ");
        String cat = in.nextLine();

        System.out.print("CPF: ");
        String cpf = in.nextLine();

        System.out.print("Cargo: ");
        String cargo = in.nextLine();

        System.out.print("Instituição: ");
        String inst = in.nextLine();

        Inscricao ins = new Inscricao(num, nome, cat, cpf, cargo, inst);

        if (ev.adicionarInscrito(ins)) {
            System.out.println("Inscrito com sucesso! Valor: R$" + ins.getPreco());
        } else {
            System.out.println("Erro: CPF já cadastrado neste evento.");
        }
    }

    public static void removerInscritoEvento(Scanner in) {
        Evento ev = selecionarEvento(in);
        if (ev == null) return;

        System.out.print("Digite o número da inscrição para remover: ");
        int num = in.nextInt();
        in.nextLine();

        if (ev.removerInscrito(num)) {
            System.out.println("Inscrição removida.");
        } else {
            System.out.println("Inscrição não encontrada.");
        }
    }

    public static void mostrarRelatorios(Scanner in) {
        Evento ev = selecionarEvento(in);
        if (ev == null) return;

        System.out.println("\n--- RELATÓRIO DO EVENTO ---");
        System.out.println("Total Arrecadado (Inscrições): R$ " + ev.calcularTotalArrecadado());
        System.out.println("Custo Total (Salas): R$ " + ev.calcularCustoSalas());

        System.out.println("--- Salas Alocadas ---");
        for (Sala s : ev.getSalas()) {
            System.out.println(s);
        }

        System.out.println("--- Inscritos ---");
        if (ev.getInscritos().isEmpty()) {
            System.out.println("Nenhum inscrito.");
        } else {
            for (Inscricao i : ev.getInscritos()) {
                System.out.println(i);
            }
        }
    }

    public static void removerEvento(Scanner in) {
        Evento ev = selecionarEvento(in);
        if (ev != null) {
            eventos.remove(ev);
            System.out.println("Evento removido.");
        }
    }

    public static void listarEventos() {
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento cadastrado.");
        }
        for (int i = 0; i < eventos.size(); i++) {
            System.out.println((i + 1) + ". " + eventos.get(i));
        }
    }

    public static void listarTodasSalas() {
        if (bancoSalas.isEmpty()) {
            System.out.println("Nenhuma sala no banco geral.");
        }
        for (Sala s : bancoSalas) {
            System.out.println(s);
        }
    }

    public static Evento selecionarEvento(Scanner in) {
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento cadastrado.");
            return null;
        }
        listarEventos();
        System.out.print("Selecione o número do evento: ");
        int index = in.nextInt() - 1;
        in.nextLine();

        if (index >= 0 && index < eventos.size()) {
            return eventos.get(index);
        }
        System.out.println("Opção inválida.");
        return null;
    }

}

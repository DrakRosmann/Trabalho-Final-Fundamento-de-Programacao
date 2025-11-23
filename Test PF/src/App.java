import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static ArrayList<Evento> listaEventos = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = lerInteiro("Digite a opção: ");

            switch (opcao) {
                case 1: cadastrarEvento(); break;
                case 2: gerenciarSalasEvento(); break;
                case 3: cadastrarInscricao(); break;
                case 4: relatoriosEvento(); break;
                case 5: listarEventosAposData(); break; // 
                case 0: System.out.println("Sencerrando o sistema CorpUP..."); break;
                default: System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void exibirMenu() {
        System.out.println("\n--- SISTEMA CorpUP --- [cite: 3]");
        System.out.println("1. Cadastrar Novo Evento");
        System.out.println("2. Gerenciar Salas de um Evento (Adicionar/Remover)");
        System.out.println("3. Realizar Inscrição em Evento");
        System.out.println("4. Relatórios Financeiros e de Público de um Evento");
        System.out.println("5. Consultar Eventos a partir de uma Data");
        System.out.println("0. Sair");
    }

    // --- LÓGICA DE NEGÓCIO DO APP ---

    private static void cadastrarEvento() {
        System.out.println("\n--- Cadastro de Evento ---");
        String codigo = lerTexto("Código: ");
        String nome = lerTexto("Nome do Evento: ");
        String tipo = lerTexto("Tipo (Feira, Congresso...): ");
        // Validação de Data Simplificada
        LocalDate dataIni = LocalDate.parse(lerTexto("Data Início (AAAA-MM-DD): "));
        LocalDate dataFim = LocalDate.parse(lerTexto("Data Fim (AAAA-MM-DD): "));
        double custo = lerDouble("Custo de Locação: ");

        Evento novoEvento = new Evento(codigo, nome, tipo, dataIni, dataFim, custo);
        listaEventos.add(novoEvento);
        System.out.println("Evento cadastrado com sucesso! Total de eventos: " + listaEventos.size()); // [cite: 41]
    }

    private static void gerenciarSalasEvento() {
        Evento ev = selecionarEvento();
        if (ev == null) return;

        System.out.println("1. Adicionar Sala");
        System.out.println("2. Remover Sala");
        int op = lerInteiro("Opção: ");

        if (op == 1) {
            String id = lerTexto("ID da Sala: ");
            String local = lerTexto("Localização: ");
            int cap = lerInteiro("Lotação Máxima: ");
            ev.adicionarSala(new Sala(id, local, cap));
            System.out.println("Sala adicionada!");
        } else if (op == 2) {
            String id = lerTexto("ID da Sala para remover: ");
            boolean removeu = ev.removerSala(id);
            if(removeu) System.out.println("Sala removida.");
            else System.out.println("Sala não encontrada.");
        }
    }

    private static void cadastrarInscricao() {
        Evento ev = selecionarEvento();
        if (ev == null) return;

        System.out.println("--- Nova Inscrição ---");
        int id = lerInteiro("ID Inscrição: ");
        String nome = lerTexto("Nome: ");
        String cpf = lerTexto("CPF: ");

        // Validação: verificar se já está inscrito [cite: 44]
        if (ev.isPessoaInscrita(cpf)) {
            System.out.println("Erro: Pessoa com este CPF já está inscrita neste evento!");
            return;
        }

        String cat = lerTexto("Categoria (Aluno, Professor, Outro): ");
        String cargo = lerTexto("Cargo: ");
        String inst = lerTexto("Instituição: ");

        Inscricao ins = new Inscricao(id, nome, cat, cpf, cargo, inst);
        ev.adicionarInscricao(ins);
        System.out.println("Inscrição realizada! Valor a pagar: R$ " + ins.getPreco());
    }

    private static void relatoriosEvento() {
        Evento ev = selecionarEvento();
        if (ev == null) return;

        System.out.println("--- Relatório do Evento: " + ev.getNome() + " ---");
        System.out.println("Total de Inscritos: " + ev.getInscritos().size()); // [cite: 43]
        System.out.println("Arrecadação Total: R$ " + ev.calcularArrecadacaoTotal()); // 

        String catBusca = lerTexto("Deseja contar inscritos de qual categoria? ");
        int qtdCat = ev.contarInscritosPorCategoria(catBusca);
        System.out.println("Inscritos da categoria '" + catBusca + "': " + qtdCat); // 

        System.out.println("--- Lista de Inscritos ---"); // [cite: 48]
        for (Inscricao i : ev.getInscritos()) {
            System.out.println(i);
        }
    }

    // Método para identificar todos os eventos a partir de uma data 
    private static void listarEventosAposData() {
        LocalDate dataRef = LocalDate.parse(lerTexto("Digite a data de corte (AAAA-MM-DD): "));
        System.out.println("Eventos a partir de " + dataRef + ":");
        boolean achou = false;
        for (Evento e : listaEventos) {
            if (e.getDataInicial().isAfter(dataRef) || e.getDataInicial().equals(dataRef)) {
                System.out.println(e);
                achou = true;
            }
        }
        if (!achou) System.out.println("Nenhum evento encontrado.");
    }

    // --- MÉTODOS AUXILIARES E VALIDAÇÃO DE ENTRADA  ---

    private static Evento selecionarEvento() {
        if (listaEventos.isEmpty()) {
            System.out.println("Nenhum evento cadastrado.");
            return null;
        }
        System.out.println("Selecione o evento:");
        for (int i = 0; i < listaEventos.size(); i++) {
            System.out.println(i + ". " + listaEventos.get(i).getNome());
        }
        int idx = lerInteiro("Índice: ");
        if (idx >= 0 && idx < listaEventos.size()) {
            return listaEventos.get(idx);
        }
        System.out.println("Índice inválido.");
        return null;
    }

    // Wrappers para tratar exceções de entrada (InputMismatch)
    private static String lerTexto(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }

    private static int lerInteiro(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número inteiro válido.");
            }
        }
    }

    private static double lerDouble(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número válido.");
            }
        }
    }
}
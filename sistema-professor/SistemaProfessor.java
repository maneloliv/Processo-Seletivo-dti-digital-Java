import java.util.*;
import java.text.DecimalFormat;

public class SistemaProfessor {
    private static List<Aluno> alunos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static DecimalFormat df = new DecimalFormat("0.00");
    
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("   SISTEMA DO PROFESSOR CARLOS");
        System.out.println("   Gestão de Notas e Frequência");
        System.out.println("==========================================");
        
        // Adicionar alguns alunos de exemplo
        inicializarExemplos();
        
        int opcao;
        do {
            mostrarMenu();
            opcao = lerInteiro("Escolha uma opção: ");
            
            switch (opcao) {
                case 1 -> cadastrarAluno();
                case 2 -> listarAlunos();
                case 3 -> mostrarEstatisticas();
                case 4 -> buscarAluno();
                case 5 -> removerAluno();
                case 6 -> exportarRelatorio();
                case 0 -> System.out.println("\nSaindo do sistema...");
                default -> System.out.println("\nOpção inválida!");
            }
            
            if (opcao != 0) {
                System.out.println("\nPressione Enter para continuar...");
                scanner.nextLine();
            }
            
        } while (opcao != 0);
        
        scanner.close();
    }
    
    private static void mostrarMenu() {
        System.out.println("\n============ MENU PRINCIPAL ============");
        System.out.println("1. Cadastrar novo aluno");
        System.out.println("2. Listar todos os alunos");
        System.out.println("3. Ver estatísticas da turma");
        System.out.println("4. Buscar aluno por nome");
        System.out.println("5. Remover aluno");
        System.out.println("6. Exportar relatório completo");
        System.out.println("0. Sair");
        System.out.println("=========================================");
    }
    
    private static void inicializarExemplos() {
        alunos.add(new Aluno("Ana Silva", 
            new double[]{8.5, 9.0, 7.5, 8.0, 9.5}, 85.0));
        alunos.add(new Aluno("Carlos Souza", 
            new double[]{6.0, 5.5, 7.0, 6.5, 5.0}, 65.0));
        alunos.add(new Aluno("Maria Santos", 
            new double[]{9.0, 9.5, 8.5, 9.0, 10.0}, 95.0));
    }
    
    private static void cadastrarAluno() {
        System.out.println("\n===== CADASTRAR NOVO ALUNO =====");
        
        System.out.print("Nome do aluno: ");
        String nome = scanner.nextLine();
        
        double[] notas = new double[5];
        System.out.println("\nDigite as 5 notas (0 a 10):");
        for (int i = 0; i < 5; i++) {
            notas[i] = lerDouble("Nota da disciplina " + (i+1) + ": ", 0, 10);
        }
        
        double frequencia = lerDouble("Frequência (0-100%): ", 0, 100);
        
        Aluno novoAluno = new Aluno(nome, notas, frequencia);
        alunos.add(novoAluno);
        
        System.out.println("\nAluno cadastrado com sucesso!");
        System.out.println("Média do aluno: " + df.format(novoAluno.calcularMedia()));
        
        if (novoAluno.precisaAtencao()) {
            System.out.println("ATENÇÃO: Este aluno tem frequência abaixo de 75%!");
        }
    }
    
    private static void listarAlunos() {
        System.out.println("\n===== LISTA DE ALUNOS =====");
        
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        
        System.out.println("Total de alunos: " + alunos.size());
        System.out.println("\n" + "=".repeat(70));
        System.out.printf("%-20s | %-10s | %-10s | Status%n", "Nome", "Média", "Frequência");
        System.out.println("=".repeat(70));
        
        for (Aluno aluno : alunos) {
            String status = aluno.precisaAtencao() ? "ATENÇÃO" : "OK";
            System.out.printf("%-20s | %-10s | %-9.1f%% | %s%n",
                aluno.getNome(),
                df.format(aluno.calcularMedia()),
                aluno.getFrequencia(),
                status);
        }
        
        // Mostrar alunos que precisam de atenção
        System.out.println("\n--- ALUNOS QUE PRECISAM DE ATENÇÃO (freq < 75%) ---");
        boolean temAlunosAtencao = false;
        for (Aluno aluno : alunos) {
            if (aluno.precisaAtencao()) {
                System.out.println("-" + aluno.getNome() + 
                    " - Frequência: " + aluno.getFrequencia() + "%");
                temAlunosAtencao = true;
            }
        }
        if (!temAlunosAtencao) {
            System.out.println("Nenhum aluno com frequência baixa.");
        }
    }
    
    private static void mostrarEstatisticas() {
        System.out.println("\n===== ESTATÍSTICAS DA TURMA =====");
        
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado para calcular estatísticas.");
            return;
        }
        
        // Calcular médias por disciplina
        double[] somaPorDisciplina = new double[5];
        int totalAlunos = alunos.size();
        
        for (Aluno aluno : alunos) {
            double[] notas = aluno.getNotas();
            for (int i = 0; i < 5; i++) {
                somaPorDisciplina[i] += notas[i];
            }
        }
        
        // Calcular média geral da turma
        double somaTotal = 0;
        int totalNotas = 0;
        
        for (Aluno aluno : alunos) {
            for (double nota : aluno.getNotas()) {
                somaTotal += nota;
                totalNotas++;
            }
        }
        double mediaGeralTurma = somaTotal / totalNotas;
        
        // Mostrar resultados
        System.out.println("Total de alunos: " + totalAlunos);
        System.out.println("Média geral da turma: " + df.format(mediaGeralTurma));
        
        System.out.println("\n--- MÉDIAS POR DISCIPLINA ---");
        for (int i = 0; i < 5; i++) {
            double mediaDisciplina = somaPorDisciplina[i] / totalAlunos;
            System.out.printf("Disciplina %d: %.2f%n", (i+1), mediaDisciplina);
        }
        
        // Alunos acima da média
        System.out.println("\n--- ALUNOS ACIMA DA MÉDIA DA TURMA ---");
        int countAcimaMedia = 0;
        for (Aluno aluno : alunos) {
            if (aluno.calcularMedia() > mediaGeralTurma) {
                System.out.println("-" + aluno.getNome() + 
                    " - Média: " + df.format(aluno.calcularMedia()));
                countAcimaMedia++;
            }
        }
        if (countAcimaMedia == 0) {
            System.out.println("Nenhum aluno acima da média.");
        }
        
        // Alunos com frequência baixa
        System.out.println("\n--- ALUNOS COM FREQUÊNCIA BAIXA (<75%) ---");
        int countFreqBaixa = 0;
        for (Aluno aluno : alunos) {
            if (aluno.precisaAtencao()) {
                System.out.println("-" + aluno.getNome() + 
                    " - Frequência: " + aluno.getFrequencia() + "%");
                countFreqBaixa++;
            }
        }
        if (countFreqBaixa == 0) {
            System.out.println("Nenhum aluno com frequência baixa.");
        }
        
        // Resumo
        System.out.println("\n--- RESUMO ---");
        System.out.println("- Alunos acima da média: " + countAcimaMedia);
        System.out.println("- Alunos com frequência baixa: " + countFreqBaixa);
    }
    
    private static void buscarAluno() {
        System.out.print("\nDigite o nome (ou parte) do aluno: ");
        String busca = scanner.nextLine().toLowerCase();
        
        System.out.println("\n===== RESULTADOS DA BUSCA =====");
        
        boolean encontrou = false;
        for (Aluno aluno : alunos) {
            if (aluno.getNome().toLowerCase().contains(busca)) {
                System.out.println("\nNome: " + aluno.getNome());
                System.out.print("Notas: ");
                for (int i = 0; i < 5; i++) {
                    System.out.printf("D%d=%.1f ", (i+1), aluno.getNotas()[i]);
                }
                System.out.printf("%nMédia: %.2f%n", aluno.calcularMedia());
                System.out.printf("Frequência: %.1f%%%n", aluno.getFrequencia());
                System.out.println("Status: " + 
                    (aluno.precisaAtencao() ? "Precisa de atenção" : "OK"));
                encontrou = true;
            }
        }
        
        if (!encontrou) {
            System.out.println("Nenhum aluno encontrado com '" + busca + "'");
        }
    }
    
    private static void removerAluno() {
        System.out.println("\n===== REMOVER ALUNO =====");
        
        if (alunos.isEmpty()) {
            System.out.println("Não há alunos cadastrados.");
            return;
        }
        
        System.out.println("Lista de alunos:");
        for (int i = 0; i < alunos.size(); i++) {
            System.out.println((i+1) + ". " + alunos.get(i).getNome());
        }
        
        int indice = lerInteiro("\nDigite o número do aluno a remover (0 para cancelar): ");
        
        if (indice == 0) {
            System.out.println("Operação cancelada.");
            return;
        }
        
        if (indice < 1 || indice > alunos.size()) {
            System.out.println("Índice inválido!");
            return;
        }
        
        Aluno removido = alunos.remove(indice - 1);
        System.out.println("Aluno '" + removido.getNome() + "' removido com sucesso!");
    }
    
    private static void exportarRelatorio() {
        System.out.println("\n===== RELATÓRIO COMPLETO =====");
        System.out.println("Data: " + new Date());
        System.out.println("Total de alunos: " + alunos.size());
        
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno para gerar relatório.");
            return;
        }
        
        // Calcular média geral
        double somaTotal = 0;
        int totalNotas = 0;
        for (Aluno aluno : alunos) {
            for (double nota : aluno.getNotas()) {
                somaTotal += nota;
                totalNotas++;
            }
        }
        double mediaGeral = somaTotal / totalNotas;
        
        System.out.println("\n" + "=".repeat(80));
        System.out.println("RELATÓRIO DO PROFESSOR CARLOS");
        System.out.println("=".repeat(80));
        System.out.printf("%nMédia geral da turma: %.2f%n%n", mediaGeral);
        
        System.out.println("LISTA DE ALUNOS:");
        System.out.println("-".repeat(80));
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
        
        System.out.println("\nALUNOS QUE PRECISAM DE ATENÇÃO ESPECIAL:");
        System.out.println("-".repeat(80));
        boolean temAtencao = false;
        for (Aluno aluno : alunos) {
            if (aluno.precisaAtencao()) {
                System.out.println("- " + aluno.getNome() + 
                    " (Frequência: " + aluno.getFrequencia() + "%)");
                temAtencao = true;
            }
        }
        if (!temAtencao) {
            System.out.println("Nenhum aluno precisa de atenção especial.");
        }
        
        System.out.println("\nALUNOS COM DESEMPENHO ACIMA DA MÉDIA:");
        System.out.println("-".repeat(80));
        boolean temAcimaMedia = false;
        for (Aluno aluno : alunos) {
            if (aluno.calcularMedia() > mediaGeral) {
                System.out.println("- " + aluno.getNome() + 
                    " (Média: " + df.format(aluno.calcularMedia()) + ")");
                temAcimaMedia = true;
            }
        }
        if (!temAcimaMedia) {
            System.out.println("Nenhum aluno acima da média.");
        }
        
        System.out.println("\n" + "=".repeat(80));
        System.out.println("FIM DO RELATÓRIO");
        System.out.println("=".repeat(80));
        
        System.out.println("\nRelatório exibido na tela.");
        System.out.println("Para salvar, use a função de imprimir do terminal.");
    }
    
    // Métodos auxiliares para entrada de dados
    private static int lerInteiro(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número inteiro válido.");
            }
        }
    }
    
    private static double lerDouble(String mensagem, double min, double max) {
        while (true) {
            try {
                System.out.print(mensagem);
                double valor = Double.parseDouble(scanner.nextLine());
                if (valor >= min && valor <= max) {
                    return valor;
                }
                System.out.printf("Valor deve estar entre %.1f e %.1f%n", min, max);
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um numero valido.");
            }
        }
    }
}
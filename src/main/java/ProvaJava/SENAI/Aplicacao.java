/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProvaJava.SENAI;

/**
 *
 * @author Aluno
 */
import ProvaJava.Clinica;
import ProvaJava.EAtendimentoNaoRegistradoException;
import ProvaJava.EValorInvalidoException;
import ProvaJava.Paciente;
import ProvaJava.Util;
import java.util.Scanner;
import java.util.Date;

public class Aplicacao {
    public static void main(String[] args) {
        try {
            Clinica senaiMedClinic = new Clinica("Senai Med", "Av Dendezeiros, 188, Bonfim", "123456789", 80.00, 120.00);
            Scanner scanner = new Scanner(System.in);

            while (true) {
                exibirMenu();
                int escolha = scanner.nextInt();
                scanner.nextLine(); // Consumir a quebra de linha

                switch (escolha) {
                    case 1:
                        realizarAtendimento(senaiMedClinic, scanner);
                        break;
                    case 2:
                        consultarMediaValorAtendimentos(senaiMedClinic);
                        break;
                    case 3:
                        alterarValoresConsulta(senaiMedClinic, scanner);
                        break;
                    case 4:
                        System.out.println("Encerrando a aplicação");
                        return;
                    default:
                        System.out.println("Opção inválida.");
                }
            }
        } catch (EValorInvalidoException e) {
            System.out.println("Erro ao criar a clínica: " + e.getMessage());
        }
    }

    private static void exibirMenu() {
        System.out.println("\nSENAI MED ");
        System.out.println("1 - Realizar Atendimento");
        System.out.println("2 - Consultar Média de Valor dos Atendimentos");
        System.out.println("3 - Alterar Valor da Consulta Simples ou Adicional para Exames");
        System.out.println("4 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void realizarAtendimento(Clinica clinica, Scanner scanner) {
        System.out.println("\nRealizar Atendimento");
        System.out.print("Digite o tipo de consulta (simples ou checkup): ");
        String tipoConsulta = scanner.nextLine();

        System.out.print("Digite o CPF do paciente: ");
        String cpf = scanner.nextLine();

        System.out.print("Digite o nome do paciente: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a data de nascimento do paciente (formato: dd/MM/yyyy): ");
        String dataNascimentoStr = scanner.nextLine();
        Date dataNascimento = Util.parseDate(dataNascimentoStr);

        System.out.print("Digite o plano de saúde do paciente: ");
        String planoSaude = scanner.nextLine();

        Paciente paciente = new Paciente(cpf, nome, dataNascimento, planoSaude);
        double valorAdicional = 0.0;
        if ("checkup".equalsIgnoreCase(tipoConsulta)) {
            System.out.print("Digite o valor adicional para exames: ");
            valorAdicional = scanner.nextDouble();
        }
        double valorAtendimento = clinica.realizarAtendimento(tipoConsulta, paciente, new Date(), "Local Qualquer", valorAdicional);
        System.out.println("Atendimento realizado! Valor do atendimento: R$ " + valorAtendimento);
    }

    private static void consultarMediaValorAtendimentos(Clinica clinica) {
        System.out.println("\nConsultar Média de Valor dos Atendimentos");
        double mediaValor = clinica.getValorTotal() / clinica.getAtendimentosRealizados().size();
        System.out.println("Média de valor dos atendimentos realizados: R$ " + mediaValor);
    }

    private static void alterarValoresConsulta(Clinica clinica, Scanner scanner) {
        System.out.println("\nAlterar Valores Consulta Simples ou Adicional para Exames");
        System.out.print("Digite o novo valor da consulta simples: ");
        double novoValorConsulta = scanner.nextDouble();

        System.out.print("Digite o novo valor adicional para exames: ");
        double novoValorAdicional = scanner.nextDouble();

        try {
            clinica.alterarValores(novoValorConsulta, novoValorAdicional);
            System.out.println("Valores alterados com sucesso!");
        } catch (EValorInvalidoException e) {
            System.out.println("Erro ao alterar valores: " + e.getMessage());
        }
    }
}

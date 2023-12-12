/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProvaJava;

/**
 *
 * @author Aluno
 */

import java.util.ArrayList;
import java.util.List;

public class Clinica {
    private final String nome;
    private final String endereco;
    private final String cnpj;
    private double valorConsultaSimples;
    private double valorAdicionalExames;
    private final List<Consulta> atendimentosRealizados;

    public Clinica(String nome, String endereco, String cnpj, double valorConsultaSimples, double valorAdicionalExames)
            throws EValorInvalidoException {
        this.nome = nome;
        this.endereco = endereco;
        this.cnpj = cnpj;
        this.valorConsultaSimples = Util.validarValorConsulta(valorConsultaSimples);
        this.valorAdicionalExames = Util.validarValorConsulta(valorAdicionalExames);
        this.atendimentosRealizados = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public List<Consulta> getAtendimentosRealizados() {
        return atendimentosRealizados;
    }

    public void alterarValores(double novoValorConsultaSimples, double novoValorAdicionalExames) throws EValorInvalidoException {
        this.valorConsultaSimples = Util.validarValorConsulta(novoValorConsultaSimples);
        this.valorAdicionalExames = Util.validarValorConsulta(novoValorAdicionalExames);
    }

    public double getValorTotal() {
        double total = 0;
        for (Consulta consulta : atendimentosRealizados) {
            total += consulta.getValorConsulta();
        }
        return total;
    }

    public void realizarAtendimento(String tipoConsulta, Paciente paciente, String dataAtendimento, String localAtendimento, double valorAdicional)
            throws EAtendimentoNaoRegistradoException {
        try {
            Consulta atendimento;
            if (tipoConsulta.equalsIgnoreCase("simples")) {
                atendimento = new Consulta(paciente, dataAtendimento, localAtendimento, valorConsultaSimples);
            } else if (tipoConsulta.equalsIgnoreCase("checkup")) {
                atendimento = new Checkup(paciente, dataAtendimento, localAtendimento, valorConsultaSimples, valorAdicional);
            } else {
                throw new EAtendimentoNaoRegistradoException("Tipo de consulta não reconhecido");
            }
            atendimentosRealizados.add(atendimento);
        } catch (EValorInvalidoException e) {
            throw new EAtendimentoNaoRegistradoException("Não foi possível realizar o atendimento: " + e.getMessage());
        }
    }
}


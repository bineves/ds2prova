/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProvaJava;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


/**
 *
 * @author Aluno
 */


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Consulta {
    private Paciente paciente;
    private LocalDate dataAtendimento;
    private String localAtendimento;
    private double valorConsulta;

    public Consulta(Paciente paciente, String dataAtendimento, String localAtendimento, double valorConsulta)
            throws EValorInvalidoException {

        if (!Util.isValidDataAtendimento(dataAtendimento) || valorConsulta < 0) {
            throw new EValorInvalidoException("Data de atendimento ou valor inválido");
        }

        this.paciente = paciente;
        this.dataAtendimento = Util.parseLocalDate(dataAtendimento);
        this.localAtendimento = localAtendimento;
        this.valorConsulta = valorConsulta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public LocalDate getDataAtendimento() {
        return dataAtendimento;
    }

    public String getLocalAtendimento() {
        return localAtendimento;
    }

    public double getValorConsulta() {
        return valorConsulta;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProvaJava;

/**
 *
 * @author Aluno
 */

public class Checkup extends Consulta {
    private final double valorAdicionalExames;

    public Checkup(Paciente paciente, String dataAtendimento, String localAtendimento, double valorConsulta, double valorAdicionalExames)
            throws EValorInvalidoException {
        super(paciente, dataAtendimento, localAtendimento, valorConsulta);
        this.valorAdicionalExames = Util.validarValorConsulta(valorAdicionalExames);
    }

    public double consultarValorAdicionalExames() {
        return valorAdicionalExames;
    }

    @Override
    public double getValorConsulta() {
        return super.getValorConsulta() + valorAdicionalExames;
    }
}


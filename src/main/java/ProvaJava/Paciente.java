/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProvaJava;

/**
 *
 * @author Aluno
 */
import java.util.Date;

public class Paciente {
    private final String cpf;
    private final String nome;
    private final Date dataNascimento;
    private final String planoSaude;

    public Paciente(String cpf, String nome, String dataNascimento, String planoSaude) throws EValorInvalidoException {
        this.cpf = cpf;
        this.nome = nome;

        this.dataNascimento = Util.parseDate(dataNascimento);

        this.planoSaude = planoSaude;
    }

    public Paciente(String cpf, String nome, Date dataNascimento, String planoSaude) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String consultarInformacoes() {
        return "CPF: " + cpf +
                "\nNome: " + nome +
                "\nData de Nascimento: " + Util.formatDate(dataNascimento) +
                "\nPlano de Saúde: " + planoSaude;
    }
}


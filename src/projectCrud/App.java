package projectCrud;

import projectCrud.dao.ClientMapDAO;
import projectCrud.dao.IClientDAO;

import javax.swing.*;

import static projectCrud.method.Register.*;
import static projectCrud.method.Consult.*;
import static projectCrud.method.Delete.*;
import static projectCrud.method.Change.*;
import static projectCrud.method.Exit.isExit;
import static projectCrud.method.Util.exit;
import static projectCrud.method.Util.isValid;

public class App {

    public static void main (String args[]) {
        IClientDAO iClientDAO = new ClientMapDAO();


        String option = JOptionPane.showInputDialog(
                null,
                "Escolha as opções abaixo:\n\n" +
                        "1 - Cadastrar um novo cliente\n" +
                        "2 - Consultar os dados de um cliente já cadastrado\n" +
                        "3 - Exluir um cliente cadastrado\n" +
                        "4 - Alterar dados de um cliente cadastrado\n" +
                        "5 - Sair da tela",
                "Cadastro",
                JOptionPane.INFORMATION_MESSAGE);

        while (!isValid(option)) {
            if ("".equals(option)) {
                exit();
            } option = JOptionPane.showInputDialog(
                    null,
                    "Opção Inválida! Tente novamente:\n\n" +
                            "1 - Cadastrar um novo cliente\n" +
                            "2 - Consultar os dados de um cliente já cadastrado\n" +
                            "3 - Exluir um cliente cadastrado\n" +
                            "4 - Alterar dados de um cliente cadastrado\n" +
                            "5 - Sair da tela",
                    "Cadastro",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        while (isValid(option)) {
            if (isExit(option)) {
                exit();
            } else if (isRegister(option)) {
                var data = JOptionPane.showInputDialog(
                        null,
                        "Digite o nome, cpf, telefone," + " endereço, numero da casa, e o estado separados por virgula",
                        "Cadastro",
                        JOptionPane.INFORMATION_MESSAGE);
                addClient(data);
            } else if (isConsult(option)) {
                var cpf = JOptionPane.showInputDialog(
                        null,
                        "Digite o cpf que você deseja consultar",
                        "Consulta",
                        JOptionPane.INFORMATION_MESSAGE);
                consult(Long.valueOf(cpf));
            } else if (isDelete(option)) {
                var cpf = JOptionPane.showInputDialog(
                        null,
                        "Digite o cpf que você deseja excluir",
                        "Excluir",
                        JOptionPane.INFORMATION_MESSAGE);
                delete(Long.valueOf(cpf));
            } else if (isChange(option)) {
                var cpf = JOptionPane.showInputDialog(
                        null,
                        "Digite o cpf que você deseja alterar",
                        "Alterar",
                        JOptionPane.INFORMATION_MESSAGE);
                var data = JOptionPane.showInputDialog(
                        null,
                        "Digite os dados que voce deseja alterar separdos por virgula",
                        "Alterar",
                        JOptionPane.INFORMATION_MESSAGE);
                change(Long.valueOf(cpf), data);
            }


            option = JOptionPane.showInputDialog(
                    null,
                    "Escolha as opções abaixo:\n\n" +
                            "1 - Cadastrar um novo cliente\n" +
                            "2 - Consultar os dados de um cliente já cadastrado\n" +
                            "3 - Exluir um cliente cadastrado\n" +
                            "4 - Alterar dados de um cliente cadastrado\n" +
                            "5 - Sair da tela",
                    "Cadastro",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

}

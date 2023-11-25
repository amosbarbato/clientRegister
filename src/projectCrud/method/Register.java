package projectCrud.method;

import projectCrud.dao.ClientMapDAO;
import projectCrud.dao.IClientDAO;
import projectCrud.domain.Client;

import javax.swing.*;

public class Register {

    static IClientDAO clientRepository = new ClientMapDAO();

    public static boolean isRegister(String option) {
        return "1".equals(option);
    }

    public static void addClient(String data) {

        String[] split = data.split(",");

        String clientName = split.length > 0 ? split[0] : null;
        String clientCpf = split.length > 1 ? split[1] : null;
        String clientPhone = split.length > 2 ? split[2] : null;
        String clientAddress = split.length > 3 ? split[3] : null;
        String clientNumber = split.length > 4 ? split[4] : null;
        String clientHouseState = split.length > 5 ? split[5] : null;

        var client = new Client(clientName, clientCpf, clientPhone, clientAddress, clientNumber, clientHouseState);

        Boolean registered = clientRepository.register(client);
        if (registered.equals(true)) {
            JOptionPane.showMessageDialog(
                    null,
                    "Cliente cadastrado com sucesso",
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Não foi possivel cadastrar esse cliente" + " ele ja se encontra no nosso banco de dados",
                    "Erro",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void consult(Long cpf) {
        var client = clientRepository.consult(cpf);
        if (client != null) {
            JOptionPane.showMessageDialog(
                    null,
                    "Cliente encontrado: " + client,
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Cliente não encontrado: ",
                    "Erro",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void delete(Long cpf) {
        var client = clientRepository.consult(cpf);
        if (client != null) {
            clientRepository.delete(cpf);
            JOptionPane.showMessageDialog(
                    null,
                    "Cliente excluído",
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Não foi possivel encontrar este cliente",
                    "Erro",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void change(Long cpf, String data) {
        var client = clientRepository.consult(cpf);

        if (client != null) {
            String[] split = data.split(",");

            String clientName = split.length > 0 ? split[0] : null;
            Long clientCpf = split.length > 1 ? Long.valueOf(split[1]) : null;
            Long clientPhone = split.length > 2 ? Long.valueOf(split[2]) : null;
            String clientAddress = split.length > 3 ? split[3] : null;
            Integer clientNumber = split.length > 4 ? Integer.valueOf(split[4]) : null;
            String clientHouseState = split.length > 5 ? split[5] : null;

            client.setName(clientName);
            client.setCpf(clientCpf);
            client.setPhone(clientPhone);
            client.setAddress(clientAddress);
            client.setNumber(clientNumber);
            client.setState(clientHouseState);

            JOptionPane.showMessageDialog(
                    null,
                    "Cliente alterado: " + client,
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Nao foi possivel alterar o cliente",
                    "Erro",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

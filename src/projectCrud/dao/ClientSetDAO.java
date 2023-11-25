package projectCrud.dao;

import projectCrud.domain.Client;

import java.util.Collection;
import java.util.HashSet;
import java.util.*;


public class ClientSetDAO implements IClientDAO {

    Set<Client> set;

    public ClientSetDAO() {
        this.set = new HashSet<>();
    }

    @Override
    public Boolean register(Client client) {
        return this.set.add(client);
    }

    @Override
    public Client consult(Long cpf) {
        for (Client registeredClient : this.set) {
            if (registeredClient.getCpf().equals(cpf)) {
                return registeredClient;
            }
        }
        return null;
    }

    @Override
    public void change(Client client) {
        if (this.set.contains(client)) {
            for (Client registeredClient : this.set) {
                if (registeredClient.equals(client)) {
                    registeredClient.setName(client.getName());
                    registeredClient.setPhone(client.getPhone());
                    registeredClient.setAddress(client.getAddress());
                    registeredClient.setNumber(client.getNumber());
                    registeredClient.setCity(client.getCity());
                    registeredClient.setState(client.getState());
                    break;
                }
            }
        }
    }

    @Override
    public void delete(Long cpf) {
        Client foundedClient = null;
        for (Client client : this.set) {
            if (client.getCpf().equals(cpf)) {
                foundedClient = client;
                break;
            }
            if (foundedClient != null) {
                this.set.remove(foundedClient);
            }
        }
    }

    @Override
    public Collection<Client> searchAll() {
        return this.set;
    }
}

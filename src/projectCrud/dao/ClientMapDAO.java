package projectCrud.dao;

import projectCrud.domain.Client;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class ClientMapDAO implements IClientDAO {
    Map<Long, Client> map;
    public ClientMapDAO() {
        map = new TreeMap<>();
    }

    @Override
    public Boolean register(Client client) {
        if (map.containsKey(client.getCpf())) {
            return false;
        }
        map.put(client.getCpf(), client);
        return true;
    }

    @Override
    public void delete(Long cpf) {
        Client registeredClient = map.get(cpf);

        map.remove(registeredClient.getCpf(), registeredClient);
    }

    @Override
    public void change(Client client) {
        Client registeredClient = map.get(client.getCpf());
        registeredClient.setName(client.getName());
        registeredClient.setPhone(client.getPhone());
        registeredClient.setAddress(client.getAddress());
        registeredClient.setNumber(client.getNumber());
        registeredClient.setCity(client.getCity());
        registeredClient.setState(client.getState());

    }

    @Override
    public Client consult(Long cpf) {
        return map.get(cpf);
    }

    @Override
    public Collection<Client> searchAll() {
        return map.values();
    }
}
package projectCrud.dao;

import projectCrud.domain.Client;

import java.util.Collection;

public interface IClientDAO {

    public Boolean register(Client client);
    public void delete(Long cpf);
    public void change(Client client);
    public Client consult(Long cpf);
    public Collection<Client> searchAll();
}

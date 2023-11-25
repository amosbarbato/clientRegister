package projectCrud.domain;

import java.util.Objects;

public class Client {
    private String name;
    private Long cpf;
    private Long phone;
    private String address;
    private Integer number;
    private String city;
    private String state;

    public Client() {

    }

    public Client(String name, String cpf, String phone, String address, String number, String city, String state) {
        this.name = name;
        this.cpf = Long.valueOf(cpf.trim());
        this.phone = Long.valueOf(phone.trim());
        this.address = address;
        this.number = Integer.valueOf(number.trim());
        this.city = city;
        this.state = state;
    }

    public Client(String clientName, String clientCpf, String clientPhone, String clientAddress, String clientNumber, String clientHouseState) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", cpf=" + cpf +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(cpf, client.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }


}


package motocycle_rental.models.reports;

import motocycle_rental.models.Client;

public class Clients {

    private Long total;
    private Client client;

    public Clients() {

    }

    public Clients(Long total, Client client) {
        this.total = total;
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}

package motocycle_rental.models;

import javax.persistence.*;

@Entity
@Table(name="message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idMessage;
    @Column(length = 250, name = "message_text")
    private String messageText;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "motorbike_id")
    private Motorbike motorbike;

    public Message() {
    }

    public Message(Integer idMessage, String messageText, Client client, Motorbike motorbike) {
        this.idMessage = idMessage;
        this.messageText = messageText;
        this.client = client;
        this.motorbike = motorbike;
    }

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Motorbike getMotorbike() {
        return motorbike;
    }

    public void setMotorbike(Motorbike motorbike) {
        this.motorbike = motorbike;
    }
}
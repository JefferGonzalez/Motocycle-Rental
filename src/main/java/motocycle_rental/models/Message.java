package motocycle_rental.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
    @ManyToOne                      // Relación muchos a uno
    @JoinColumn(name = "client_id") // Nombre de la columna que hace referencia a la llave foránea
    private Client client;          // Objeto de la clase Client
    @ManyToOne                         // Relación muchos a uno
    @JoinColumn(name = "motorbike_id") // Nombre de la columna que hace referencia a la llave foránea
    @JsonIgnoreProperties({"messages", "reservations"}) // Evita que se cree un bucle infinito
    private Motorbike motorbike;       // Objeto de la clase Motorbike

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

package motocycle_rental.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer idClient;
    @Column(length = 45)
    private String name;
    @Column(length = 45)
    private String email;
    @Column(length = 45)
    private String password;
    @Column(length = 3)
    private Integer age;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client_id")
    private List<Message> messages;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client_id")
    private List<Reservation> reservations;


    public Client() {
    }

    public Client(Integer idClient, String name, String email, String password, Integer age) {
        this.idClient = idClient;
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

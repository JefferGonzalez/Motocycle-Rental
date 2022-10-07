package motocycle_rental.models;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="motorbike")
public class Motorbike {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 45)
    private String name;
    @Column(length = 45)
    private String brand;
    @Column(length = 4)
    private Integer year;
    @Column(length = 250)
    private String description;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "motorbike_id")
    private List<Message> messages;
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "motorbike_id")
    private List<Reservation> reservations;

    public Motorbike(){

    }

    public Motorbike(Integer id, String brand, Integer year, String name, String description) {
        this.id = id;
        this.brand = brand;
        this.year = year;
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

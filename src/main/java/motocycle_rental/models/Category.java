package motocycle_rental.models;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    @Column(length = 45)
    private String name;
    @Column(length = 45)
    private String description;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "category_id")
    private List<Motorbike> motorbikes;


    public Category(){
    }

    public Category(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

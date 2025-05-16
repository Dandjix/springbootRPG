package s6.springboot.tp.models;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class ItemCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public  ItemCategory(){}
    public  ItemCategory(String name)
    {
        this.name = name;
    }
}

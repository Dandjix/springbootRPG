package s6.springboot.tp.models;

import jakarta.persistence.*;

@Entity
@Table(name = "rpgitems")
public class RPGItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //name, id_category, price, effect

    private  String name;

    private long idCategory;

    private float price;

    private  String effect;

    public RPGItem(){}
    public RPGItem(String name, long id_category, float price, String effect)
    {
        this.name = name;
        this.idCategory = id_category;
        this.price = price;
        this.effect = effect;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getIdCategory() {
        return idCategory;
    }

    public float getPrice() {
        return price;
    }

    public String getEffect() {
        return effect;
    }
}

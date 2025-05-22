package s6.springboot.tp.models;

public class RPGItemDTO {

    private final String name;

    private final long idCategory;

    private final float price;

    private final String effect;

    public RPGItemDTO(String name, long id_category, float price, String effect)
    {
        this.name = name;
        this.idCategory = id_category;
        this.price = price;
        this.effect = effect;
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

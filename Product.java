package Demo;

import java.util.Formatter;

public class Product {
    public int Id;
    public String name;
    public String author;
    public Float price;
    public String category;
    public String desc;
    public float amount;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Product(int Id, String name, String author, float price, String category, String desc, float amount)
    {
        super();
        this.Id = Id;
        this.name=name;
        this.author=author;
        this.price  = price ;
        this.category = category;
        this.desc = desc;
        this.amount=amount;
    }


}

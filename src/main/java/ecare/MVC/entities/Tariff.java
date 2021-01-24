package ecare.MVC.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * tariff entity class
 */
@Entity
@Table(name  = "tariff")
public class Tariff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tariff_id")
    private int tariffId;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "price")
    private BigDecimal price;

    @Basic
    @Column(name = "description")
    private String description;

    public int getTariffId() {
        return tariffId;
    }

    public void setTariffId(int tariffId) {
        this.tariffId = tariffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Tariff(String name, BigDecimal price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Tariff(){};

    @Override
    public String toString() {
        return "Tariff{" +
                "tariffId=" + tariffId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tariff tariff = (Tariff) o;
        return tariffId == tariff.tariffId && name.equals(tariff.name) && price.equals(tariff.price) && Objects.equals(description, tariff.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tariffId, name, price, description);
    }
}

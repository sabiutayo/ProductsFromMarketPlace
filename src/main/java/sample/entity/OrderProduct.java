package sample.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class OrderProduct {

    @OneToMany
    @JoinTable(name = "order_product",
            joinColumns =
                    {@JoinColumn(name = "order_id", referencedColumnName = "id")},
            inverseJoinColumns =
                    {@JoinColumn(name = "product_id", referencedColumnName = "id")}
    )
    public List<Product> products;
}

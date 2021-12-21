package io.orderup.models;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@javax.persistence.Table(name = "orders")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String productlist;

    @ManyToOne()
    @JoinColumn(name = "table_id")
    private Table table;

    private String comments;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    private int total;
}

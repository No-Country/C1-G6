package io.orderup.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@javax.persistence.Table(name = "tables")
public class Table implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private Integer tableNumber;

    @JoinColumn(name = "order")
    @OneToOne(fetch = FetchType.LAZY)
    private Order order;


}

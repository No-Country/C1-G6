package io.orderup.models;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Entity
@Table (name = "products")
public class Product implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        private String name;

        private String price;

        private String description;

        private int stock;

        @ManyToOne()
        @JoinColumn(name = "category_id")
        private Category category;

        @CreatedDate
        private Timestamp created_at;
        @LastModifiedDate
        private Timestamp updated_at;
}

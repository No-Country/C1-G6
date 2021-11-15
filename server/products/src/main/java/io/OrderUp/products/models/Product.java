package io.OrderUp.products.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "products")
public class Product {

        public Product (){}

        public Product(long id, String name, String price, String description, String comments, int stock, Timestamp created_at, Timestamp updated_at) {
                this.id = id;
                this.name = name;
                this.price = price;
                this.description = description;
                this.comments = comments;
                this.stock = stock;
                this.created_at = created_at;
                this.updated_at = updated_at;
        }

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        private String name;

        private String price;

        private String description;

        private String comments;

        private int stock;

        @CreatedDate
        private Timestamp created_at;
        @LastModifiedDate
        private Timestamp updated_at;


        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getPrice() {
                return price;
        }

        public void setPrice(String price) {
                this.price = price;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public String getComments() {
                return comments;
        }

        public void setComments(String comments) {
                this.comments = comments;
        }

        public int getStock() {
                return stock;
        }

        public void setStock(int stock) {
                this.stock = stock;
        }

        public Timestamp getCreated_at() {
                return created_at;
        }

        public void setCreated_at(Timestamp created_at) {
                this.created_at = created_at;
        }

        public Timestamp getUpdated_at() {
                return updated_at;
        }

        public void setUpdated_at(Timestamp updated_at) {
                this.updated_at = updated_at;
        }


}

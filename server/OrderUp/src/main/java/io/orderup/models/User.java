package io.orderup.models;


import javax.persistence.*;
import javax.persistence.Table;

import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private String id;
    private String name;
    private String surname;
    private String password;
    private Integer phone;
    private String email;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}

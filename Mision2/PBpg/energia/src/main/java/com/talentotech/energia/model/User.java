package com.talentotech.energia.model;
import jakarta.persistence.*;
//convierte las clases de java en base de datos 
@Entity
@Table(name = "users")
public class User {
@Id 
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(nullable = false,unique = true)
private String username;
@Column(nullable = false)
private String email;


}





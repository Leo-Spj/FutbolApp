package com.civa.futbolapp.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "posicion")
public class PosicionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "posicion_id")
    private int id;

    @Column(unique = true, nullable = false, length = 50)
    private String posicion;
}

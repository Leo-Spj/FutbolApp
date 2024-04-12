package com.civa.futbolapp.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "futbolista")
public class FutbolistaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "futbolistaid")
    private int id;

    private String nombre;

    private String apellido;

    @Column(columnDefinition = "DATE")
    private LocalDate fechaNacimiento;

    private String caracteristicas;

    @OneToOne
    @JoinColumn(name = "posicionid", referencedColumnName = "posicionid")
    private PosicionEntity posicion;
}

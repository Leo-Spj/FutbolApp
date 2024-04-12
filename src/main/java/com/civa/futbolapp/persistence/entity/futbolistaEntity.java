package com.civa.futbolapp.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "futbolista")
public class FutbolistaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "futbolista_id")
    private int id;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String apellido;

    @Column(name = "fecha_nacimiento", nullable = false, columnDefinition = "DATE")
    private LocalDate fechaNacimiento;

    private String caracteristicas;

    //para posicion
    @ManyToOne
    @JoinColumn(name = "posicion_id", referencedColumnName = "posicion_id")
    @Fetch(FetchMode.JOIN)
    private PosicionEntity posicion;
}

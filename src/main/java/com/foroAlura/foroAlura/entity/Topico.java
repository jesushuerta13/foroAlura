package com.foroAlura.foroAlura.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="topicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Topico {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 200)
    private String titulo;
    @Column(nullable = false,length = 200)
    private String mensaje;
    @Column(name="fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @PrePersist
    public void prePersist(){
        if(fechaCreacion==null){
            fechaCreacion=LocalDateTime.now();
        }
    }

}

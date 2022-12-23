package com.unab.vetshop.Models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="cliente")
public class Cliente  implements Serializable{
    @Id
    @Column(name="id_cliente")
    private String id_cliente;
    @Column(name="nombre_cliente")
    private String nombre_cliente;
    @Column(name="contrasena_cliente")
    private String contrasena_cliente;
    @Column(name="direccion_cliente")
    private String direccion_cliente;
    @Column(name="correo_cliente")
    private String correo_cliente;

    @Override
    public String toString() {
        return "Cliente [id_cliente=" + id_cliente + ", nombre_cliente=" + nombre_cliente + ", contrasena_cliente="
                + contrasena_cliente + ", direccion_cliente="
                + direccion_cliente + ", correo_cliente="
                + correo_cliente + "]";
    }
}

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
@Table(name="login")
public class Login  implements Serializable{
    @Id
    @Column(name="id_login")
    private String id_login;
    @Column(name="correo_cliente")
    private String correo_cliente;
    @Column(name="contrasena_cliente")
    private String contrasena_cliente;

    @Override
    public String toString() {
        return "Login [id_login=" + id_login + ",  correo_cliente=" + correo_cliente + ", contrasena_cliente=" + contrasena_cliente + ",]";
    }
}

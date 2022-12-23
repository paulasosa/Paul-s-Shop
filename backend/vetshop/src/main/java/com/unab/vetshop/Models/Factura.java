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
@Table(name="factura")
public class Factura  implements Serializable{
    @Id
    @Column(name="id_factura")
    private String id_factura;
    @Column(name="cliente")
    private String cliente;
    @Column(name="idpedido")
    private String idpedido;
    @Column(name="dirEnvio_factura")
    private String dirEnvio_factura;
    @Column(name="forma_pago")
    private String forma_pago;

    @Override
    public String toString() {
        return "Factura [id_factura=" + id_factura + ", cliente=" + cliente + ", idpedido="
                + idpedido + ", dirEnvio_factura="
                + dirEnvio_factura + ", forma_pago="
                + forma_pago + "]";
    }
}

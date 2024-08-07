package com.distribuida.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "autor")
public class Factura_detalle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_factura_detalle")
	private int idfacturadetalle;
	@Column(name="cantidad")
	private int cantidad;
	@Column(name="subtotal")
	private float subtotal;
	
	@JoinColumn(name="id_factura")
	@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH})
	private Factura factura;
	
	
	@JoinColumn(name="id_libro")
	@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH})
	private Libro libro;
	
	
	public Factura_detalle() {}
	
	public Factura_detalle(int idfactura_detalle, int cantidad, float subtotal) {
		this.idfacturadetalle=idfactura_detalle;
		this.cantidad=cantidad;
		this.subtotal=subtotal;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Factura_detalle [idfacturadetalle=" + idfacturadetalle + ", cantidad=" + cantidad + ", subtotal="
				+ subtotal + "]";
	}
	public int getIdfacturadetalle() {
		return idfacturadetalle;
	}
	public void setIdfacturadetalle(int idfacturadetalle) {
		this.idfacturadetalle = idfacturadetalle;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public float getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}
	
	
	
}

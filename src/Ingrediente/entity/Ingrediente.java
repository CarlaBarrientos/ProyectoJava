package Ingrediente.entity;



public class Ingrediente {
   private int codIngrediente;
   private String descripci�n;
   private double costo;
   private int numAlmac�n;
   private int cantidad;
   
   
   public Ingrediente(int codIngrediente, String descripci�n, double costo, int numAlmac�n, int cantidad) {
	   this.codIngrediente = codIngrediente;
	   this.descripci�n = descripci�n;
	   this.costo = costo;
	   this.numAlmac�n = numAlmac�n;
	   this.cantidad = cantidad;
   }
   public int getCodIngrediente() {
	return codIngrediente;
 }
 public void setCodIngrediente(int codIngrediente) {
	this.codIngrediente = codIngrediente;
 }
 public String getDescripci�n() {
	return descripci�n;
 }
 public void setDescripci�n(String descripci�n) {
	this.descripci�n = descripci�n;
 }
 public double getCosto() {
	return costo;
 }
 public void setCosto(double costo) {
	this.costo = costo;
 }
 public int getNumAlmac�n() {
	return numAlmac�n;
 }
 public void setNumAlmac�n(int numAlmac�n) {
	this.numAlmac�n = numAlmac�n;
 }
 public int getCantidad() {
	return cantidad;
 }
 public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
 }

	@Override
	public String toString() {
		return "Ingrediente [codIngrediente=" + codIngrediente + ",  descripci�n=" +  descripci�n + ", costo=" + costo + ", numAlmac�n="
				+ numAlmac�n + ", cantidad=" + cantidad + "]";
	}
	
}

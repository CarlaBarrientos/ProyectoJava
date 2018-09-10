package Ingrediente.entity;



public class Ingrediente {
   private int codIngrediente;
   private String descripción;
   private double costo;
   private int numAlmacén;
   private int cantidad;
   
   
   public Ingrediente(int codIngrediente, String descripción, double costo, int numAlmacén, int cantidad) {
	   this.codIngrediente = codIngrediente;
	   this.descripción = descripción;
	   this.costo = costo;
	   this.numAlmacén = numAlmacén;
	   this.cantidad = cantidad;
   }
   public int getCodIngrediente() {
	return codIngrediente;
 }
 public void setCodIngrediente(int codIngrediente) {
	this.codIngrediente = codIngrediente;
 }
 public String getDescripción() {
	return descripción;
 }
 public void setDescripción(String descripción) {
	this.descripción = descripción;
 }
 public double getCosto() {
	return costo;
 }
 public void setCosto(double costo) {
	this.costo = costo;
 }
 public int getNumAlmacén() {
	return numAlmacén;
 }
 public void setNumAlmacén(int numAlmacén) {
	this.numAlmacén = numAlmacén;
 }
 public int getCantidad() {
	return cantidad;
 }
 public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
 }

	@Override
	public String toString() {
		return "Ingrediente [codIngrediente=" + codIngrediente + ",  descripción=" +  descripción + ", costo=" + costo + ", numAlmacén="
				+ numAlmacén + ", cantidad=" + cantidad + "]";
	}
	
}

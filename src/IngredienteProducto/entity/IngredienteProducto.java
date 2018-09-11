package IngredienteProducto.entity;

public class IngredienteProducto {
 private int codProducto;
 private int codIngrediente;

 public IngredienteProducto(int codIngrediente, int codProducto){
	 this.codIngrediente = codIngrediente;
	 this.codProducto = codProducto;
 }
 public int getCodProducto() {
	return codProducto;
}
public void setCodProducto(int codProducto) {
	this.codProducto = codProducto;
}
public int getCodIngrediente() {
	return codIngrediente;
}
public void setCodIngrediente(int codIngrediente) {
	this.codIngrediente = codIngrediente;
}
@Override
public String toString() {
	return "IngredienteProducto [codIngrediente=" + codIngrediente + ", codProducto=" + codProducto + "]";
}
}

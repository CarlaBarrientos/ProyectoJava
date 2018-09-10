package DetalleCompraIngrediente.entity;



public class DetalleCompraIngrediente {
   private int codIngrediente;
   private int codCompraIngrediente;
   
   
   public DetalleCompraIngrediente(int codCompraIngrediente, int codIngrediente) {
	   this.codCompraIngrediente = codCompraIngrediente;
	   this.codIngrediente = codIngrediente;
   }
   public int getCodIngrediente() {
	return codIngrediente;
}
public void setCodIngrediente(int codIngrediente) {
	this.codIngrediente = codIngrediente;
}
public int getCodCompraIngrediente() {
	return codCompraIngrediente;
}
public void setCodCompraIngrediente(int codCompraIngrediente) {
	this.codCompraIngrediente = codCompraIngrediente;
}

@Override
public String toString() {
	return "DetalleCompraIngrediente [codIngrediente=" + codIngrediente + ", codCompraIngrediente=" + codCompraIngrediente + "]";
}

}

package tallerweb.sangucheto.modelo;

public class Producto {

    private String nombre;
    private Double precio;
    private TipoIngrediente tipo;
    private Integer cantidad;
    
    public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public TipoIngrediente getTipo() {
        return tipo;
    }
    public void setTipo(TipoIngrediente tipo) {
        this.tipo = tipo;
    }
}

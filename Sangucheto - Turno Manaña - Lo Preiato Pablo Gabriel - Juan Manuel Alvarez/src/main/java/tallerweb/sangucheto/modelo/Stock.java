package tallerweb.sangucheto.modelo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Maneja un stock de ingredientes, el mismo puede ser asociado a una cantidad.<br>
 * No persiste, es decir, luego de la ejecucion del programa el Stock se inicialza vacio.<br>
 * @author sismael
 *
 */
public class Stock {
	
	private static Stock instance = new Stock();
	private Map<Ingrediente, Integer> stock = new HashMap<Ingrediente, Integer>();
	
	private Stock(){
	 Ingrediente i1 = new Ingrediente();
	 i1.setNombre("Mayonesa");
	 i1.setPrecio(5.5);
	 i1.setTipo(TipoIngrediente.CONDIMENTO);
	 
	 Ingrediente i2 = new Ingrediente();
	 i2.setNombre("Mostaza");
	 i2.setPrecio(3.5);
	 i2.setTipo(TipoIngrediente.CONDIMENTO);
	 
	 Ingrediente i3 = new Ingrediente();
	 i3.setNombre("Ketchup");
	 i3.setPrecio(4.0);
	 i3.setTipo(TipoIngrediente.CONDIMENTO);
	 
	 Ingrediente i4 = new Ingrediente();
	 i4.setNombre("Tomate");
	 i4.setPrecio(10.5);
	 i4.setTipo(TipoIngrediente.INGREDIENTE);
	 
	 Ingrediente i5 = new Ingrediente();
	 i5.setNombre("Jamon");
	 i5.setPrecio(12.5);
	 i5.setTipo(TipoIngrediente.INGREDIENTE);
	 
	 Ingrediente i6 = new Ingrediente();
	 i6.setNombre("Queso");
	 i6.setPrecio(15.0);
	 i6.setTipo(TipoIngrediente.INGREDIENTE);
	 
	 stock.put(i1, 20);
	 stock.put(i2, 20);
	 stock.put(i3, 20);
	 stock.put(i4, 25);
	 stock.put(i5, 30);
	 stock.put(i6, 35);
	}

	public static Stock getInstance(){
		return instance;
	}
	
	/**
	 * Devuelve un listado de los ingredientes del stock, tengan o no stock, es decir, los ingredientes con cantidad 0 son incluidos.<br>
	 * @param producto
	 * @param cantidad
	 * @return 
	 */
	public Set<Ingrediente> listarIngredientesDisponibles(){
		return stock.keySet();
	}
	
	/**
	 * Devuelve un mapa con los ingredientes y su stock correspondiente, tengan o no stock, es decir, los ingredientes con cantidad 0 son incluidos.<br>
	 * @param producto
	 * @param cantidad
	 * @return 
	 */
	public Map<Ingrediente, Integer> obtenerStock(){
		return stock;
	}
	
	/**
	 * Permite agregar el ingrediente indicado al stock, con cantidad 0.<br>
	 * @param ingrediente
	 * @param cantidad
	 * @return true en caso de exito, false si el ingrediente ya existe en el stock.<br>
	 */
	public Boolean agregarIngrediente(Ingrediente ingrediente){
		if(this.stock.containsKey(ingrediente)){
			return false;
		}
		this.stock.put(ingrediente, 0);
		return true;
	}
	
	/**
	 * Permite agregar stock al existente para un ingrediente dado. Si el ingrediente tiene un stock de N, ahora tendra N + cantidad.<br>
	 * @param ingrediente
	 * @param cantidad
	 * @return true en caso de exito, false si el ingrediente no existe en el stock.<br>
	 */
	public Boolean agregarStock(Ingrediente ingrediente, Integer cantidad){
		if(!this.stock.containsKey(ingrediente)){
			return false;
		}
		Integer nuevaCantidad = this.stock.get(ingrediente) + cantidad;
		this.stock.put(ingrediente, nuevaCantidad);
		return true;
	}
	
	/**
	 * Devuelve el stock disponible para el ingrediente pedido. NULL si el ingrediente no existe en el stock<br>
	 * @param ingrediente
	 * @return
	 */
	public Integer obtenerStockDisponible(Ingrediente ingrediente){
		if(!this.stock.containsKey(ingrediente)){
			return null;
		}
		return this.stock.get(ingrediente);
	}
	
	/**
	 * Indica si el ingrediente indicado fue incluido en el stock.<br>
	 * @param ingrediente
	 * @return
	 */
	public Boolean existeIngrediente(Ingrediente ingrediente){
		return this.stock.containsKey(ingrediente);
	}
	
	/**
	 * Permite comprar N unidades del ingrediente indicado.<br>
	 * @param ingrediente
	 * @param unidades
	 * @return true en caso de exito, false si el ingrediente no existe en el stock.<br>
	 */
	public Boolean comprarIngrediente(Ingrediente ingrediente, Integer unidades){
		if(!this.stock.containsKey(ingrediente)){
			return false;
		}
		Integer nuevaCantidad = this.stock.get(ingrediente) - unidades;
		this.stock.put(ingrediente, nuevaCantidad);
		return true;
	}
	
	/**
	 * Elimina el ingrediente indicado del stock, no importa cual sea la cantidad disponible del mismo.<br>
	 * @param ingrediente
	 * @return true en caso de exito, false si el ingrediente no existe en el stock.<br>
	 */
	public Boolean eliminarIngrediente(Ingrediente ingrediente){
		if(!this.stock.containsKey(ingrediente)){
			return false;
		}
		this.stock.remove(ingrediente);
		return true;
	}
	
	/**
	 * Elimina el stock del ingrediente.<br>
	 * @param ingrediente
	 * @return true en caso de exito, y false si el ingrediente no existe en el stock.<br>
	 */
	public Boolean eliminarStockDeIngrediente(Ingrediente ingrediente){
		if(!this.stock.containsKey(ingrediente)){
			return false;
		}
		this.stock.put(ingrediente, 0);
		return true;
		
		}
}

package tallerweb.sangucheto.modelo;

import java.util.LinkedList;
import java.util.List;

public class Sangucheto {

	private static Sangucheto instance = new Sangucheto();
	private List<Ingrediente> listIngredientes = new LinkedList<Ingrediente>();
	private double sanguche=50.0;
	
	private Sangucheto(){}
	
	public static Sangucheto getInstance(){
		return instance;
	}
	
	/**
	 * Elimina todos los ingredientes del sanguchetto.<br>
	 */
	public void vaciar(){
		listIngredientes.clear();
	}
	
	/**
	 * Agrega un ingrediente al carrito.<br>
	 * @param ingrediente
	 */
	public void agregarIngrediente(Ingrediente ingrediente){ 		
		listIngredientes.add(ingrediente);
	}
	
	/**
	 * Lista todos los ingredientes que forman parte del sanguchetto.<br>
	 * @return
	 */
	public List<Ingrediente> verIngredientes(){
		List<Ingrediente> listSoloIngredientes = new LinkedList<Ingrediente>();

			for (int i = 0; i < listIngredientes.size(); i++) {
				if(listIngredientes.get(i).getTipo()==TipoIngrediente.INGREDIENTE)
				{
					listSoloIngredientes.add(listIngredientes.get(i));
				}
				
			}

			return listSoloIngredientes;


	}
	
	/**
     * Lista todos los condimentos que forman parte del sanguchetto.<br>
     * @return
     */
    public List<Ingrediente> verCondimentos(){
    	List<Ingrediente> listSoloCondimentos = new LinkedList<Ingrediente>();

			for (int i = 0; i < listIngredientes.size(); i++) {
				if(listIngredientes.get(i).getTipo()==TipoIngrediente.CONDIMENTO)
				{
					listSoloCondimentos.add(listIngredientes.get(i));
				}
				
			}

			return listSoloCondimentos;

    }
	
	/**
	 * Devuelve el precio total del sanguchetto.<br>
	 * @return
	 */
	public Double getPrecio(){
		//el sanguche solo vale $50
		double precioTotal=sanguche;
			for (Ingrediente item : listIngredientes) {
				precioTotal+=item.getPrecio();
			}
			return precioTotal;
	}
	/**
	 * Devuelve el descuento
	 * @param precioTotal
	 * @return
	 */
	public double getDescuento(double precioTotal){
		double descuento = 0.0;
		if(precioTotal>=125){
			descuento=(precioTotal*10)/100;
		}
		return descuento;
	}
/**Devuelve el precio del sanguche sin nada mas*/
	public double getSanguche() {
		return sanguche;
	}
	/**Establece el precio del sanguche sin nada mas*/
	public void setSanguche(double sanguche) {
		this.sanguche = sanguche;
	}
	
	public List<Ingrediente> getIngredientes(){
		return listIngredientes;
	}
}

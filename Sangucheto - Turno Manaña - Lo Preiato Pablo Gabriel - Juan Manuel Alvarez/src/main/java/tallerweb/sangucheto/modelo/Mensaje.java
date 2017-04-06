package tallerweb.sangucheto.modelo;

public class Mensaje {

	private static Mensaje instance = new Mensaje();
	private String mensajeResumen="";
	private String mensajeDetallado="";
	private String mensajeTipo="";
	private String mensajeProductoTipo = "";
	private String mensajeClase="";


	public static Mensaje getInstance() {
		return instance;
	}

	public String getMensajeResumen() {
		return mensajeResumen;
	}

	public void setMensajeResumen(String mensajeResumen) {
		this.mensajeResumen = mensajeResumen;
	}

	public String getMensajeDetallado() {
		return mensajeDetallado;
	}

	public void setMensajeDetallado(String mensajeDetallado) {
		this.mensajeDetallado = mensajeDetallado;
	}

	/**
	 * Devuelve el tipo de mensaje para la alerta. Success: cuando es una alerta
	 * en relacion a agregar elementos. y Danger: cuando es una alerta en
	 * ralación a elminar elementos
	 * 
	 * @return
	 */
	public String getMensajeTipo() {
		return mensajeTipo;
	}

	/**
	 * Establece el tipo de mensaje para la alerta. Success: cuando es una
	 * alerta en relacion a agregar elementos. y Danger: cuando es una alerta en
	 * relación a elminar elementos
	 * 
	 * @return
	 */
	public void setMensajeTipo(String mensajeTipo) {
		this.mensajeTipo = mensajeTipo;
	}
	/** Devuelve para que tipo de producto y que clase es el mensaje. INGREDIENTE, CONDIMENTO ó PRODUCTO.
	 * 
	 * @return
	 */
	public String getMensajeProductoTipo() {
		return mensajeProductoTipo;
	}
	/** Establece para que tipo de producto y que clase es el mensaje. INGREDIENTE, CONDIMENTO ó PRODUCTO.
	 * 
	 * @return
	 */
	public void setMensajeProductoTipo(String mensajeProductoTipo) {
		this.mensajeProductoTipo = mensajeProductoTipo;
	}
/** Devuelve la clase a la que pertenece el mensaje 
 * 
 * @return
 */
	public String getMensajeClase() {
		return mensajeClase;
	}
/** Establece a que clase pertenece el mensaje
 * 
 * @param mensajeClase
 */
	public void setMensajeClase(String mensajeClase) {
		this.mensajeClase = mensajeClase;
	}
}

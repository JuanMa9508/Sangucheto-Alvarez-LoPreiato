package tallerweb.sangucheto.controladores;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import tallerweb.sangucheto.modelo.Ingrediente;
import tallerweb.sangucheto.modelo.Mensaje;
import tallerweb.sangucheto.modelo.Producto;
import tallerweb.sangucheto.modelo.Stock;

@Controller
public class ControladorStock {

	// 1-recibo un producto, lo combierto a ingrediente, y lo agrego a stock.
	// 2-Agrego el ingrediente a stock y luego la cantidad a ese ingrediente.
	@RequestMapping(path = "/stock", method = RequestMethod.POST)
	public String stock(@ModelAttribute("producto") Producto producto) {
		if(producto.getNombre().isEmpty())
		{
			Mensaje mensaje = Mensaje.getInstance();
			mensaje.setMensajeClase("Stock");
				mensaje.setMensajeResumen("Error!");
				mensaje.setMensajeDetallado("Debe ingresarle un nombre al nuevo producto.");
				mensaje.setMensajeTipo("Danger");
				mensaje.setMensajeProductoTipo("PRODUCTO");
		}
		else{
		//Mensaje
				Mensaje mensaje = Mensaje.getInstance();
				mensaje.setMensajeClase("Stock");
					mensaje.setMensajeResumen("Producto agregado!");
					mensaje.setMensajeDetallado("El producto se ha agregado correctamente.");
					mensaje.setMensajeTipo("Success");
					mensaje.setMensajeProductoTipo("PRODUCTO");
		// 1
		
		Stock stock = Stock.getInstance();
		Ingrediente i1 = new Ingrediente();
		i1.setNombre(producto.getNombre());
		i1.setPrecio(producto.getPrecio());
		i1.setTipo(producto.getTipo());
		stock.agregarIngrediente(i1);
		// 2
		stock.agregarStock(i1, producto.getCantidad());
		}

		return ("redirect:/stock");

	}

	// 1-creo un model, stock, mapa y le asigno el stock al mapa
	// 2-creo un producto y lo asigno al modelo
	// 3-asigno el mapa al modelo y deuvelvo la vista y el modelo.
	@RequestMapping(path = "/stock", method = RequestMethod.GET)
	public ModelAndView stock() {
		//mensaje
		Mensaje mensaje = Mensaje.getInstance();
		if(mensaje.getMensajeClase()!="Stock")
			mensaje.setMensajeProductoTipo(null);
		// 1
		ModelMap model = new ModelMap();
		Stock stock = Stock.getInstance();
		Map<Ingrediente, Integer> mapIngredientes = stock.obtenerStock();
		// 2-
		Producto p1 = new Producto();
		model.put("producto", p1);
		//mensaje
		model.put("mensajeResumen", mensaje.getMensajeResumen());
		model.put("mensajeDetallado",mensaje.getMensajeDetallado());
		model.put("mensajeTipo", mensaje.getMensajeTipo());
		model.put("mensajeProductoTipo",mensaje.getMensajeProductoTipo());
		model.put("mensajeClase",mensaje.getMensajeClase());
		// 3
		model.addAttribute("map", mapIngredientes);
		ModelAndView miVista = new ModelAndView();
		miVista.addAllObjects(model);

		return new ModelAndView("stock", model);
	}


	// 1-creo un modelo y stock
	// 2-creo un ingrediente y lo seteo con producto
	// 3-agrego la cantidad ingresada al stock.
	@RequestMapping(path = "/agregarStock", method = RequestMethod.POST)
	public String agregarAlStock(@ModelAttribute("producto") Producto producto) {
		//Mensaje
		Mensaje mensaje = Mensaje.getInstance();
		mensaje.setMensajeClase("Stock");
		if(producto.getCantidad()>0){
			mensaje.setMensajeResumen("Stock agregado!");
			mensaje.setMensajeDetallado("El stock se ha agregado correctamente al producto.");
			mensaje.setMensajeTipo("Success");
			mensaje.setMensajeProductoTipo(producto.getTipo().toString());
		}
		else{
			mensaje.setMensajeResumen("Error!");
			mensaje.setMensajeDetallado("Debe establecer un numero mayor que 0 para agregarlo al stock.");
			mensaje.setMensajeTipo("Danger");
			mensaje.setMensajeProductoTipo(producto.getTipo().toString());
		}
		// 1
		Stock stock = Stock.getInstance();
		// 2
		Ingrediente i1 = new Ingrediente();
		i1.setNombre(producto.getNombre());
		i1.setPrecio(producto.getPrecio());
		i1.setTipo(producto.getTipo());
		// 3
		stock.agregarStock(i1, producto.getCantidad());

		return "redirect:/stock";
	}

	// 1-creo un modelo y stock
	// 2-creo un ingrediente y lo seteo con producto
	// 3- elimino el stock del ingrediente
	@RequestMapping(path = "/eliminarStock", method = RequestMethod.POST)
	public String eliminarStock(@ModelAttribute("producto") Producto producto) {
		//Mensaje
		Mensaje mensaje = Mensaje.getInstance();
		mensaje.setMensajeClase("Stock");
			mensaje.setMensajeResumen("Stock eliminado!");
			mensaje.setMensajeDetallado("El stock se ha eliminado correctamente.");
			mensaje.setMensajeTipo("Danger");
			mensaje.setMensajeProductoTipo(producto.getTipo().toString());
		// 1
		Stock stock = Stock.getInstance();
		// 2
		Ingrediente i1 = new Ingrediente();
		i1.setNombre(producto.getNombre());
		i1.setPrecio(producto.getPrecio());
		i1.setTipo(producto.getTipo());
		// 3
		stock.eliminarStockDeIngrediente(i1);

		return "redirect:/stock";

	}

}

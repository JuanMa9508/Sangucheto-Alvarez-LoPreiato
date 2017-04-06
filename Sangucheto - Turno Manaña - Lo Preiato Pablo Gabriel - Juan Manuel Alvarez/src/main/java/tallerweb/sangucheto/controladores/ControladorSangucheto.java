package tallerweb.sangucheto.controladores;

import java.util.LinkedList;
import java.util.List;
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
import tallerweb.sangucheto.modelo.Sangucheto;
import tallerweb.sangucheto.modelo.Stock;

@Controller
public class ControladorSangucheto {

		// 1-creo un model, stock, mapa y le asigno el stock al mapa.
		// 2-creo un objeto Sangucheto y asigno el precio del sangucheto a una variable
		// 3-calculo el descuento y asigno el descuento y el total con descuento al modelo
		// 3- creo un producto y lo asigno al modelo.
		// 4-asigno el mapa al modelo y devuelvo la vista y el modelo.
		@RequestMapping(path = "/armarSangucheto", method = RequestMethod.GET)
		public ModelAndView armarSangucheto() {
			//Mensaje
			Mensaje mensaje = Mensaje.getInstance();
			//compruebo que el mensaje provenga de algun metodo de esta clase, si no es asi le establesco null 
			//al tipo de producto del mensaje, para que no pueda entrar en los if de las vistas
			if(mensaje.getMensajeClase()!="Sangucheto")
				mensaje.setMensajeProductoTipo(null);
			// 1
			ModelMap model = new ModelMap();
			Stock stock = Stock.getInstance();
			Map<Ingrediente, Integer> mapIngredientes = stock.obtenerStock();
			// 2
			Sangucheto sangucheto = Sangucheto.getInstance();
			double precioSangucheto = sangucheto.getPrecio();
			double descuento = sangucheto.getDescuento(precioSangucheto);
			//descuento
				model.put("descuento",descuento);
				model.addAttribute("total",(precioSangucheto-descuento));
				//mensaje
				model.put("mensajeResumen", mensaje.getMensajeResumen());
				model.put("mensajeDetallado",mensaje.getMensajeDetallado());
				model.put("mensajeTipo", mensaje.getMensajeTipo());
				model.put("mensajeProductoTipo",mensaje.getMensajeProductoTipo());
				model.put("mensajeClase", mensaje.getMensajeClase());
			//3
			Producto producto = new Producto();
			model.put("producto",producto);
			//4
			model.addAttribute("map", mapIngredientes);
			ModelAndView miVista = new ModelAndView();
			miVista.addAllObjects(model);

			return new ModelAndView("armarSangucheto", model);
		}
		
		//1- creo un ingrediente, lo seteo con el producto.
		//2- creo un objeto stock, y compruebo que haya stock disponibe del ingrediente que quiero agregar.
		//3- creo un sangucheto, agrego el ingrediente al carrito.
		//4- descuento 1 del stock del ingrediente.
		@RequestMapping(path="/agregarAlCarrito", method = RequestMethod.POST)
		public String agregarAlCarrito(@ModelAttribute("producto") Producto producto){
			
			
			//1
			Ingrediente i1 = new Ingrediente();
			i1.setNombre(producto.getNombre());
			i1.setPrecio(producto.getPrecio());
			i1.setTipo(producto.getTipo());
			//2
			Stock stock = Stock.getInstance();
			if(stock.obtenerStockDisponible(i1)>0){
				
			//3
			Sangucheto sangucheto = Sangucheto.getInstance();
			sangucheto.agregarIngrediente(i1);
			//4
			stock.comprarIngrediente(i1, 1);
			//mensaje
			Mensaje mensaje = Mensaje.getInstance();
			mensaje.setMensajeClase("Sangucheto");
			mensaje.setMensajeResumen("Producto agregado!");
			mensaje.setMensajeDetallado("El producto se ha agregado correctamente al carrito.");
			mensaje.setMensajeTipo("Success");
			mensaje.setMensajeProductoTipo(producto.getTipo().toString());
			}
			else
			{
				Mensaje mensaje = Mensaje.getInstance();
				mensaje.setMensajeClase("Sangucheto");
				mensaje.setMensajeResumen("Sin stock!");
				mensaje.setMensajeDetallado("No se ha podido agregar el producto debido a que ya no hay mas stock.");
				mensaje.setMensajeTipo("Danger");
				mensaje.setMensajeProductoTipo(producto.getTipo().toString());
			}
			
			return "redirect:/armarSangucheto";
}
		//1- creo un objeto sangucheto y uno stock.
		//2- recorro la lista ,de condimentos y luego la de ingredientes, que contiene sangucheto, y agrego al stock.
		//3- vacio la lista y redirijo a "armarSangucheto"
		@RequestMapping(path="/cancelarCompra",method=RequestMethod.POST)
		public String cancelarCompra(){
			//mensaje
			Mensaje mensaje = Mensaje.getInstance();
			mensaje.setMensajeClase("Sangucheto");
			mensaje.setMensajeResumen("Compra cancelada!");
			mensaje.setMensajeDetallado("La compra ha sido cancelada.");
			mensaje.setMensajeTipo("Danger");
			mensaje.setMensajeProductoTipo("PRODUCTO");
			//1-
			Sangucheto sangucheto = Sangucheto.getInstance();
			Stock stock = Stock.getInstance();
			//2
			for (Ingrediente item : sangucheto.verCondimentos()) {
				stock.agregarStock(item, 1);
			}
			for (Ingrediente item : sangucheto.verIngredientes()) {
				stock.agregarStock(item, 1);
			}
			//3
			sangucheto.vaciar();
			return "redirect:/armarSangucheto";
		}
		
		//1- Creo un modelo, una vista y un sangucheto
		//2- obtengo las listas de sangucheto y lleno la lista de productos
		//3- asigno la lista, el total modelo y el precio solo del sanguche
		//4- creo una vista, le asigno el modelo y la devuelvo
		@RequestMapping(path="/carrito",method=RequestMethod.POST)
		public ModelAndView carrito(){
			//1
			ModelMap model = new ModelMap();
			List<Ingrediente> listaProductos = new LinkedList<Ingrediente>();
			Sangucheto sangucheto = Sangucheto.getInstance();
			//2

				for (Ingrediente item : sangucheto.verCondimentos()) {
					listaProductos.add(item);
				}

				for (Ingrediente item : sangucheto.verIngredientes()) {
					listaProductos.add(item);
				}
//				}
			//descuento
				double precioSangucheto = sangucheto.getPrecio();
				double descuento = sangucheto.getDescuento(precioSangucheto);
			//3
				model.addAttribute("lista",listaProductos);
				model.put("total", (precioSangucheto-descuento));
				model.put("descuento", descuento);
				model.put("totalSinDescuento",precioSangucheto);
				model.put("precioSanguche", sangucheto.getSanguche());
			//4
			
				ModelAndView miVista = new ModelAndView();
				miVista.addAllObjects(model);
				
				return new ModelAndView("carrito", model);
}
		//1- creo un sangucheto y vacio la lista.
		//2- redirijo a home.
		@RequestMapping(path="/comprar",method=RequestMethod.POST)
		public String comprar(){
			//1
			Sangucheto sangucheto = Sangucheto.getInstance();
			sangucheto.vaciar();
			ModelMap model = new ModelMap();
			ModelAndView miVista = new ModelAndView();
			miVista.addAllObjects(model);
			//2
			return "redirect:/";
		}
		
}

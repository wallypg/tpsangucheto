package tallerweb.sangucheto.controllers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import tallerweb.sangucheto.modelo.Ingrediente;
import tallerweb.sangucheto.modelo.Sanguchetto;
import tallerweb.sangucheto.modelo.Stock;

@Controller
@RequestMapping("/sucursal")
public class Controlador {
	
	private Stock deposito= Stock.getInstance();
	private Sanguchetto sanguche= Sanguchetto.getInstance();
	
	//Muestra la vista para crear productos
	@RequestMapping("/altaProducto")
	public String altaProducto(){
		return "sucursal/altaProducto";
	}
	
	//Crea el producto y lo guarda en el stock general
	@RequestMapping("/crearProducto")
	public String crearProducto(Ingrediente nuevoIngrediente, Model modeloDeProductos){
		String resultado= "/sucursal/vistaErrores";
		
		if(deposito.agregarIngrediente(nuevoIngrediente)){
			modeloDeProductos.addAttribute("ingrediente", nuevoIngrediente);
			resultado= "sucursal/vistaBien";
		}
		return resultado;
	}
	
	//Listado de Stock de cada producto
	@RequestMapping("/verStock")
	public ModelAndView verStock(){
		ModelMap miLista = new ModelMap();		
		miLista.put("mapaIngredientes",deposito.obtenerStock());
		
		ModelAndView miVista= new ModelAndView();
		miVista.addAllObjects(miLista);
		miVista.setViewName("sucursal/verStock");

		return miVista;
	}
	
	//Carga en la vista los datos del ingrediente elegido para agregarle stock
	@RequestMapping("/agregarStock")
	public ModelAndView agregarStock(Ingrediente ingrediente){
		ModelMap mostrarEnLaVista = new ModelMap();
		mostrarEnLaVista.put("datosDelIngrediente", ingrediente);
		mostrarEnLaVista.put("stockActual", deposito.obtenerStockDisponible(ingrediente));
		
		
		ModelAndView laVista= new ModelAndView();
		laVista.addAllObjects(mostrarEnLaVista);
		laVista.setViewName("sucursal/agregarStock");
		
		return laVista;
	}
	
	//Agrega la cantidad de stock indicado
	@RequestMapping("/realizarAgregarStock")
	public String realizarAgregarStock(Ingrediente ingrediente, Integer cantidadAgregar){
		String resultado="/sucursal/vistaErrores";
		
		if(deposito.agregarStock(ingrediente, cantidadAgregar)){
			resultado="/sucursal/vistaBien";
		}
		
		return resultado;
	}
	
	//Ver la vista eliminarStock
	@RequestMapping("/eliminarStock")
	public String eliminarStock(Ingrediente ingrediente, Model modelo){
		modelo.addAttribute("datosIngrediente", ingrediente);
		return "sucursal/eliminarStock";
	}
	
	//Realiza la eliminacion del producto
	@RequestMapping("/realizarEliminarStock")
	public String realizarEliminarStock(Ingrediente ingrediente){
		String resultado= "/sucursal/vistaErrores";
		
		if(deposito.eliminarIngrediente(ingrediente)){
			resultado="/sucursal/vistaBien";
		}
		
		return resultado;
	}
	
	@RequestMapping("/agregarCarrito")
	public String agregarCarrito(Model modelo){
		modelo.addAttribute("productos", deposito.obtenerStock());
		modelo.addAttribute("precioAcumulado", sanguche.getPrecio());
		return "sucursal/agregarCarrito";
	}

	//Agregar un producto al sanguchetto desde la vista agregarCarrito
	@RequestMapping("/realizarComprarIngrediente")
	public String realizarComprarIngrediente(Ingrediente ingrediente, Integer cantidadUnidades, Model modelo){
		Integer i;
		
		if(deposito.comprarIngrediente(ingrediente, cantidadUnidades)){
			for(i=1; i<= cantidadUnidades; i++){
				sanguche.agregarIngrediente(ingrediente);
			}	
			
			modelo.addAttribute("precioAcumulado", sanguche.getPrecio());
			modelo.addAttribute("productos", deposito.obtenerStock());
		}
		return "/sucursal/agregarCarrito";
	}
	
	//Muestra como quedo el carrito
	@RequestMapping("/finalCarrito")
	public String finalCarrito(Model modelo){
		//Tipo ingrediente
		List<Ingrediente> listaTipoIngrediente= sanguche.verIngredientes();
		HashMap<Ingrediente, Integer> comprasPorIngrediente = this.comprasPorProducto(listaTipoIngrediente);
		
		//Tipo condimento
		List<Ingrediente> listaTipoCondimento= sanguche.verCondimentos();
		HashMap<Ingrediente, Integer> comprasPorCondimento = this.comprasPorProducto(listaTipoCondimento);
		
		modelo.addAttribute("mapaProductosIngrediente", comprasPorIngrediente);
		modelo.addAttribute("mapaProductosCondimento", comprasPorCondimento);
		modelo.addAttribute("precioFinal", sanguche.getPrecio());
		
		return "sucursal/finalCarrito";
	}
	
	//Cancela los productos comprados y los devuelve al stock
	@RequestMapping("/cancelarCarrito")
	public String cancelarCarrito(Model modelo){
		HashMap<Ingrediente, Integer> comprasPorIngrediente = this.comprasPorProducto(sanguche.verIngredientes());
		HashMap<Ingrediente, Integer> comprasPorCondimentos = this.comprasPorProducto(sanguche.verCondimentos());
		Integer cantidadStock = deposito.listarIngredientesDisponibles().size();
		Iterator<Ingrediente> iteradorStock = deposito.listarIngredientesDisponibles().iterator();
		Integer i;
		
		for(i = 1; i <= cantidadStock; i++){
			if(iteradorStock.hasNext()){
				Ingrediente proximoEnStock = iteradorStock.next();
				
				if(comprasPorIngrediente.containsKey(proximoEnStock)){
					deposito.agregarStock(proximoEnStock, comprasPorIngrediente.get(proximoEnStock));
				}else if(comprasPorCondimentos.containsKey(proximoEnStock)){
					deposito.agregarStock(proximoEnStock, comprasPorCondimentos.get(proximoEnStock));
				}
			}
		}
		
		sanguche.vaciar();
		modelo.addAttribute("productos", deposito.obtenerStock());
		modelo.addAttribute("precioAcumulado", sanguche.getPrecio());
		
		return "/sucursal/agregarCarrito";
	}
		
	//Metodo PRIVADO para obtener la cantidad de compras por unidad de cada producto
	private HashMap<Ingrediente, Integer> comprasPorProducto(List<Ingrediente> lista){
		Integer cantidadElementos = lista.size();
		Integer i;
		Iterator<Ingrediente> iterador = lista.iterator();
		HashMap<Ingrediente, Integer> tablaFinal = new HashMap<Ingrediente, Integer>();
		
		//lista de ingredientes comprados
		for(i = 1; i <= cantidadElementos; i++){
			if(iterador.hasNext()){
				Ingrediente siguiente = iterador.next();
				
					if(!tablaFinal.containsKey(siguiente)){
						tablaFinal.put(siguiente, 1);
					}else{
						Integer contadorRepetido= tablaFinal.get(siguiente);
						
						tablaFinal.put(siguiente, contadorRepetido + 1);
					}
			}
		}
		
		return tablaFinal;
	}

}
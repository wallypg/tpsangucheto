package tallerweb.sangucheto.controllers;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import tallerweb.sangucheto.modelo.Ingrediente;
import tallerweb.sangucheto.modelo.Stock;

@Controller
@RequestMapping("/sucursal")
public class Controlador {
	
	private Stock deposito= Stock.getInstance();
	
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
	
	/*
	 * @RequestMapping("/crearProducto")
	public String crearProducto(Ingrediente nuevoIngrediente, HttpSession session, Model modeloIngredientes){
	Stock.getInstance().agregarIngrediente(nuevoIngrediente);
	Map mapaIngredientes = Stock.getInstance().obtenerStock();
    modeloIngredientes.addAttribute(mapaIngredientes);
	return "sucursal/verStock";
	}
	*/
	
//    @RequestMapping("/listaIngredientes")
//    public String listarIngredientes(Model modeloIngredientes){
//    Map mapaIngredientes = Stock.getInstance().obtenerStock();
//    modeloIngredientes.addAttribute(mapaIngredientes);
//    return "sucursal/verStock";
//    }
	
	
	//Se pide el stock, no estoy seguro si usar el metodo listarIngredientesDisponibles()
	// o usar obtenerStock() xq este ultimo metodo no dice el precio y tipo (no lo probe)
	@RequestMapping("/verStock")
	public ModelAndView verStock(){
		ModelMap miLista = new ModelMap();		
		miLista.put("mapaIngredientes",deposito.obtenerStock());
		
		ModelAndView miVista= new ModelAndView();
		miVista.addAllObjects(miLista);
		miVista.setViewName("sucursal/verStock");

		return miVista;
	}
	
	@RequestMapping("/agregarCarrito")
	public String agregarCarrito(){
		return "sucursal/agregarCarrito";
	}
	
	@RequestMapping("/eliminarStock")
	public String eliminarStock(){
		return "sucursal/eliminarStock";
	}
	
	@RequestMapping("/finalCarrito")
	public String finalCarrito(){
		return "sucursal/finalCarrito";
	}
	
	/********************************************************************************/
	
	/*FORMULARIO*/
//	@RequestMapping("/nuevo")
//	public String nuevoPajaro() {
//
//		return "sucursal/nuevo";
//	}
	
//
//	@RequestMapping("/crear")
//	public String crear(Pajaro miPajaro , HttpSession session, Model miModelo){
//		ArrayList lista=(ArrayList)session.getAttribute("listaPajaros");
//		if(lista==null){
//			lista = new ArrayList();
//		}
//		lista.add(miPajaro);
//		session.setAttribute("listaPajaros",lista);
//		miModelo.addAttribute("listaPajaros",lista);
//		return "sucursal/creado";
//	}
//	
//	@RequestMapping("/borrar")
//	public String borrar(Integer miPajaro , HttpSession session, Model miModelo){
//		ArrayList lista=(ArrayList)session.getAttribute("listaPajaros");
//		lista.remove(miPajaro.intValue());
//		session.setAttribute("listaPajaros",lista);
//		miModelo.addAttribute("listaPajaros",lista);
//		if(lista==null || lista.size() == 0) {
//			return "sucursal/nuevo";
//		} else{
//		return "sucursal/creado";
//		}
//	}
//	
//	@RequestMapping("/tomarpajaro")
//	public String tomarpajaro(String nombre,String tipo,boolean activo,Integer indice, HttpSession session, Model miModelo){
//		
//		ArrayList lista=(ArrayList)session.getAttribute("listaPajaros");
//		Pajaro miPajaro = new Pajaro(nombre,tipo,activo); 
//		
//		miModelo.addAttribute("miPajaro",miPajaro);
//		miModelo.addAttribute("indice",indice.intValue());
//		return "sucursal/editar";
//	}
//	
//	@RequestMapping("/editar")
//	public String editar(Integer indice,Pajaro miPajaro , HttpSession session, Model miModelo){
//		ArrayList lista=(ArrayList)session.getAttribute("listaPajaros");
//		lista.remove(indice.intValue());
//		lista.add(indice.intValue(),miPajaro);
//		session.setAttribute("listaPajaros",lista);
//		miModelo.addAttribute("listaPajaros",lista);
//		return "sucursal/creado";
//	}
	
	
	
	
	/*
	@RequestMapping("/crear")
	public String crear(@RequestParam("nombre") String nombre, @RequestParam("tipo") String tipo,
			@RequestParam("activo") Boolean activo, Model miModelo) {
		miModelo.addAttribute("nombre",nombre);
		miModelo.addAttribute("tipo",tipo);
		miModelo.addAttribute("activo",activo);
		return "pajaro/creado";
	}
	*/
	
	/*	
	public void crearPajaro(@RequestParam("nombre") String nombre, @RequestParam("tipo") String tipo,
		@RequestParam("activo") Boolean activo, Model miModelo,HttpSession Session) {
		Pajaro miPajaro = new Pajaro(nombre, tipo, activo);
		miModelo.addAttribute("miPajaro" , miPajaro);
		crear(miPajaro,Session,miModelo);
		
	}
	*/
	
	

}
package tallerweb.sangucheto.modelo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Sanguchetto {

	private static Sanguchetto instance = new Sanguchetto();
	private List<Ingrediente> ingredientes = new LinkedList<Ingrediente>();
	
	private Sanguchetto(){}
	
	public static Sanguchetto getInstance(){
		return instance;
	}
	
	/**
	 * Elimina todos los ingredientes del sanguchetto.<br>
	 */
	public void vaciar(){
		// Implementar
		ingredientes.clear();
	}
	
	/**
	 * Agrega un ingrediente al carrito.<br>
	 * @param ingrediente
	 */
	public void agregarIngrediente(Ingrediente ingrediente){
		// Implementar
			ingredientes.add(ingrediente);
	}
	
	/**
	 * Lista todos los ingredientes que forman parte del sanguchetto.<br>
	 * @return
	 */
	public List<Ingrediente> verIngredientes(){
		// Implementar
		//ListaTipoIngrediente: almacena solo los ingredientes del tipo INGREDIENTE
		//Pueden ser INGREDIENTE o CONDIMENTO
		
		List<Ingrediente> listaTipoIngrediente = new LinkedList<Ingrediente>();
		Integer cantidadProductos = ingredientes.size();
		Integer i;
		Iterator<Ingrediente> iteradorProductos = ingredientes.iterator();
		
		for(i=1; i<= cantidadProductos; i++){
			if(iteradorProductos.hasNext()){
				Ingrediente cadaIngrediente= iteradorProductos.next();
				
				if(cadaIngrediente.getTipo() == TipoIngrediente.INGREDIENTE){
					listaTipoIngrediente.add(cadaIngrediente);
				}
			}
		}
	
		return listaTipoIngrediente;
	}
	
	/**
     * Lista todos los condimentos que forman parte del sanguchetto.<br>
     * @return
     */
    public List<Ingrediente> verCondimentos(){
        // Implementar
    	//ListaTipoCondimento: almacena solo los ingredientes del tipo CONDIMENTO
		//Pueden ser INGREDIENTE o CONDIMENTO
		
		List<Ingrediente> listaTipoCondimento = new LinkedList<Ingrediente>();
		Integer cantidadProductos = ingredientes.size();
		Integer i;
		Iterator<Ingrediente> iteradorProductos = ingredientes.iterator();
		
		for(i=1; i<= cantidadProductos; i++){
			if(iteradorProductos.hasNext()){
				Ingrediente cadaCondimento= iteradorProductos.next();
				
				if(cadaCondimento.getTipo() == TipoIngrediente.CONDIMENTO){
					listaTipoCondimento.add(cadaCondimento);
				}
			}
		}
	
		return listaTipoCondimento;
    }
	
	/**
	 * Devuelve el precio total del sanguchetto.<br>
	 * @return
	 */
	public Double getPrecio(){
		// Implementar
		Integer i;
		Integer cantidadDeProductos= ingredientes.size();
		Double precioTotal= 0.0;
		Iterator<Ingrediente> iterador = ingredientes.iterator();
		
		for(i=1; i<= cantidadDeProductos; i++){
			if(iterador.hasNext()){
				precioTotal= precioTotal + iterador.next().getPrecio();
			}
		}
		
		return precioTotal;
	}
}

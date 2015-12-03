package tallerweb.sanguchetto.modelo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tallerweb.sangucheto.modelo.Ingrediente;
import tallerweb.sangucheto.modelo.Sanguchetto;
import tallerweb.sangucheto.modelo.TipoIngrediente;

public class SanguchettoTest {
	
	//Creo ingredientes
	Ingrediente pan = new Ingrediente("Rodaja de pan", 5.5, TipoIngrediente.INGREDIENTE);
	Ingrediente jamon = new Ingrediente("Feta de jamón", 9.0, TipoIngrediente.INGREDIENTE);
	Ingrediente queso = new Ingrediente("Feta de queso", 7.0, TipoIngrediente.INGREDIENTE);
	Ingrediente mayonesa = new Ingrediente("Sobre de mayonesa", 1.5, TipoIngrediente.CONDIMENTO);
	Ingrediente ketchup = new Ingrediente("Sobre de ketchup", 2.0, TipoIngrediente.CONDIMENTO);
	
	//Instancio sanguchetto
	public Sanguchetto unRicoSanguche = Sanguchetto.getInstance();
		

	@Test
	public void testAgregarIngrediente(){
		unRicoSanguche.vaciar();
		unRicoSanguche.agregarIngrediente(pan);
		unRicoSanguche.agregarIngrediente(pan);
		unRicoSanguche.agregarIngrediente(jamon);
		unRicoSanguche.agregarIngrediente(queso);
		unRicoSanguche.agregarIngrediente(ketchup);
		
		Assert.assertEquals(5, unRicoSanguche.verCondimentos().size() + unRicoSanguche.verIngredientes().size());		
	}
	
	@Test
	public void testVerIngredientes(){
		unRicoSanguche.vaciar();
		unRicoSanguche.agregarIngrediente(pan);
		unRicoSanguche.agregarIngrediente(pan);
		unRicoSanguche.agregarIngrediente(jamon);
		unRicoSanguche.agregarIngrediente(queso);
		unRicoSanguche.agregarIngrediente(ketchup);		
		Assert.assertEquals(4, unRicoSanguche.verIngredientes().size());
	}

	@Test
	public void testVerCondimentos(){
		unRicoSanguche.vaciar();
		unRicoSanguche.agregarIngrediente(pan);
		unRicoSanguche.agregarIngrediente(pan);
		unRicoSanguche.agregarIngrediente(jamon);
		unRicoSanguche.agregarIngrediente(queso);
		unRicoSanguche.agregarIngrediente(ketchup);			
		Assert.assertEquals(1, unRicoSanguche.verCondimentos().size());
	}
	
	@Test
	public void testGetPrecio(){
		Assert.assertEquals(29.0, unRicoSanguche.getPrecio(), 0.001);
	}
	
	@Test
	public void testVaciar(){
		Assert.assertEquals(29.0, unRicoSanguche.getPrecio(), 0.001);
		unRicoSanguche.vaciar();
		Assert.assertEquals(0.0, unRicoSanguche.getPrecio(), 0.001);
	}
}

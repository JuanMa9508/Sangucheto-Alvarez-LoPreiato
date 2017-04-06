package tallerweb.sanguchetto.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import tallerweb.sangucheto.modelo.Ingrediente;
import tallerweb.sangucheto.modelo.Sangucheto;
import tallerweb.sangucheto.modelo.TipoIngrediente;

public class SanguchetoTest {

    @Test
    public void testVaciar() {
    	Sangucheto sangucheto = Sangucheto.getInstance();
    	
    	Ingrediente i1 = new Ingrediente();
    	i1.setNombre("Mayonesa");
    	i1.setPrecio(15.5);
    	i1.setTipo(TipoIngrediente.CONDIMENTO);
    	
    	sangucheto.agregarIngrediente(i1);
    	assertTrue(sangucheto.getIngredientes().size() >0);
    	sangucheto.vaciar();
    	assertTrue(sangucheto.getIngredientes().size() == 0);        
    }

    @Test
    public void testAgregarIngrediente() {
       Sangucheto sangucheto = Sangucheto.getInstance();
       sangucheto.vaciar();
       Ingrediente i1 = new Ingrediente();
       i1.setNombre("Mayonesa");
       i1.setPrecio(15.5);
   	   i1.setTipo(TipoIngrediente.CONDIMENTO);
   	   sangucheto.agregarIngrediente(i1);
   	   assertTrue(sangucheto.getIngredientes().size() == 1);
   	
    }

    @Test
    public void testVerIngredientes() {
    	Sangucheto sangucheto = Sangucheto.getInstance();
        sangucheto.vaciar();
        Ingrediente i1 = new Ingrediente();
        i1.setNombre("Mayonesa");
        i1.setPrecio(15.5);
    	   i1.setTipo(TipoIngrediente.CONDIMENTO);
    	   Ingrediente i2 = new Ingrediente();
    	   i2.setNombre("Jamon");
    	   i2.setPrecio(13.5);
    	   i2.setTipo(TipoIngrediente.INGREDIENTE);
    	   sangucheto.agregarIngrediente(i1);
    	   sangucheto.agregarIngrediente(i2);
    	   assertTrue(sangucheto.verIngredientes().size()==1);
    }

    @Test
    public void testVerCondimentos() {
    	Sangucheto sangucheto = Sangucheto.getInstance();
        sangucheto.vaciar();
        Ingrediente i1 = new Ingrediente();
        i1.setNombre("Mayonesa");
        i1.setPrecio(15.5);
    	   i1.setTipo(TipoIngrediente.CONDIMENTO);
    	   Ingrediente i2 = new Ingrediente();
    	   i2.setNombre("Jamon");
    	   i2.setPrecio(13.5);
    	   i2.setTipo(TipoIngrediente.INGREDIENTE);
    	   sangucheto.agregarIngrediente(i1);
    	   sangucheto.agregarIngrediente(i2);
    	   assertTrue(sangucheto.verCondimentos().size()==1);
    }

    @Test
    public void testGetPrecio() {
    	Sangucheto sangucheto = Sangucheto.getInstance();
        sangucheto.vaciar();
        Ingrediente i1 = new Ingrediente();
        i1.setNombre("Mayonesa");
        i1.setPrecio(15.5);
    	   i1.setTipo(TipoIngrediente.CONDIMENTO);
    	   Ingrediente i2 = new Ingrediente();
    	   i2.setNombre("Jamon");
    	   i2.setPrecio(13.5);
    	   i2.setTipo(TipoIngrediente.INGREDIENTE);
    	   sangucheto.agregarIngrediente(i1);
    	   sangucheto.agregarIngrediente(i2);
    	  double precioEsperado=15.5+13.5+50;
    	  assertEquals(precioEsperado, sangucheto.getPrecio(),0.0001 );
    }
}

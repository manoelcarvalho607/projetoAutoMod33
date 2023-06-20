/**
 * 
 */
package br.com.carvalho;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import br.com.carvalho.dao.AcessorioDao;
import br.com.carvalho.dao.CarroDao;
import br.com.carvalho.dao.IAcessorioDao;
import br.com.carvalho.dao.ICarroDao;
import br.com.carvalho.dao.IMarcaDao;
import br.com.carvalho.dao.MarcaDao;
import br.com.carvalho.domain.Acessorio;
import br.com.carvalho.domain.Carro;
import br.com.carvalho.domain.Marca;

/**
 * @author manoel.carvalho
 *
 */
public class CarroTest {
	
	private ICarroDao carroDao;
	private IMarcaDao marcaDao;
	private IAcessorioDao acessorioDao;
	
	public CarroTest() {
		carroDao = new CarroDao();
		marcaDao = new MarcaDao();
		acessorioDao = new AcessorioDao();
	}
	
	
	
	@Test
	public void addCarro() {
		
		
		
		Marca marca = new Marca();
		marca.setCodigo("M20");
		marca.setNome("VOLKS");
		
		marcaDao.create(marca);
		
	
		Carro car = new Carro();
		car.setCodigo("C12");
		car.setNome("PASSAT");
		car.setDescricao("automatico");
		car.setMarca(marca);
		carroDao.create(car);
		
	
		
		Acessorio ac = new Acessorio();
		ac.setCodigo("A05");
		ac.setNome("turbo");
		ac.setDescricao("teste");
		ac.setCarro(car);
		acessorioDao.create(ac);
	
		

	
		
		assertNotNull(car);
		assertNotNull(car.getId());
		
		
		acessorioDao.delete(ac);
		Acessorio acessorio = acessorioDao.readId(ac.getId());
		assertNull(acessorio);
		
		carroDao.deleteCar(car);
		Carro readCar = carroDao.readCarId(car.getId());
		assertNull(readCar);
		
		
		
		marcaDao.delete(marca);
		Marca readModel = marcaDao.readId(marca.getId());
		assertNull(readModel);
	 
		
		
	
	}
	

	

}

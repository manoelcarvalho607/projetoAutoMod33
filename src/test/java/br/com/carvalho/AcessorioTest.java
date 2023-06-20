/**
 * 
 */
package br.com.carvalho;

import static org.junit.Assert.assertNotNull;

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


public class AcessorioTest {
	
	private IAcessorioDao acessorioDao;
	private ICarroDao carroDao;
	private IMarcaDao marcaDao;
	
	public AcessorioTest() {
		acessorioDao = new AcessorioDao();
		carroDao = new CarroDao();
		marcaDao = new MarcaDao();
	}
	
	
	
	@Test
	public void addAcessorio() {
		Carro car = CriarCarro();
		
		Acessorio ac = new Acessorio();
		ac.setCodigo("A01");
		ac.setNome("arcondicionado");
		ac.setDescricao("teste");
		ac.setCarro(car);
		acessorioDao.create(ac);
		
		assertNotNull(ac);
		assertNotNull(ac.getId());
		
	}
	
	
	private Carro CriarCarro() {
		Marca marca = CriarMarca();
		
		Carro car = new Carro();
		car.setCodigo("H01");
		car.setNome("HB20");
		car.setDescricao("automatico");
		car.setMarca(marca);
		carroDao.create(car);
		
		return car;
		
	}
	

	private Marca CriarMarca() {
		Marca marca = new Marca();
		marca.setCodigo("M1");
		marca.setNome("Hyundai");
		
		marcaDao.create(marca);
		
		return marca;
		
	}


}

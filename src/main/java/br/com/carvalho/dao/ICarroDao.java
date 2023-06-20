/**
 * 
 */
package br.com.carvalho.dao;

import java.util.List;

import br.com.carvalho.domain.Carro;

/**
 * @author manoel.carvalho
 *
 */
public interface ICarroDao {
	
	Carro create(Carro carro);
	Carro readCarId(Long id);
	public List<Carro> readAllCar();
	public Carro updateCar(Carro carro);
	public void deleteCar(Carro carro);
	

}

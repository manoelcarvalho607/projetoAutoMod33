/**
 * 
 */
package br.com.carvalho.dao;

import java.util.List;

import br.com.carvalho.domain.Carro;
import br.com.carvalho.domain.Marca;

/**
 * @author manoel.carvalho
 *
 */
public interface IMarcaDao {
	
	Marca create(Marca marca);
	Marca readId(Long id);
	public List<Marca> readAll();
	public Marca update(Marca marca);
	public void delete(Marca marca);

}

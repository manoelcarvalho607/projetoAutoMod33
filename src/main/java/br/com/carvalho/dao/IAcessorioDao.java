/**
 * 
 */
package br.com.carvalho.dao;

import java.util.List;

import br.com.carvalho.domain.Acessorio;
import br.com.carvalho.domain.Carro;

/**
 * @author manoel.carvalho
 *
 */
public interface IAcessorioDao {
	
	Acessorio create(Acessorio acessorio);
	Acessorio readId(Long id);
	public List<Acessorio> readAll();
	public Acessorio update(Acessorio acessorio);
	public void delete(Acessorio acessorio);

}

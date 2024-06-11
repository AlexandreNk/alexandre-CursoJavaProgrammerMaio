package repositorio;

import java.util.List;

import entidade.Cachorro;

public interface CachorroRepositorio {

	public boolean salvarCachorroRepositorio(Cachorro cachorro);
	
	public List<Cachorro> listarGerenteRepositorio();
}

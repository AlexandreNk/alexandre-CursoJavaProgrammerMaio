package repositorio;

import java.util.List;

import entidade.Cachorro;

public interface CachorroRepositorio {

	public boolean salvarCachorroRepositorio(Cachorro cachorro);
	
	public List<Cachorro> listarCachorroRepositorio();
	
	public boolean excluirCachorroRepositorio(String caf);
	
	public boolean alterarCachorroRepositorio(Cachorro cachorro);
	
	public Cachorro buscaCachorroPorCaf(String caf);
	
	
}


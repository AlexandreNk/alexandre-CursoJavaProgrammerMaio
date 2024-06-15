package repositorio;

import java.util.List;

import entidade.Cachorro;
import persistencia.DaoCachorro;

public class CachorroRepositorioImplementacao implements CachorroRepositorio {

	@Override
	public boolean salvarCachorroRepositorio(Cachorro cachorro) {
			DaoCachorro daoCachorro = new DaoCachorro();
			return daoCachorro.salvarCachorro(cachorro);
	}
	
	@Override
	public List<Cachorro> listarCachorroRepositorio() {
		DaoCachorro daoCachorro = new DaoCachorro();
		return daoCachorro.retornaListaCachorros();	
	}

	@Override
	public boolean excluirCachorroRepositorio(String caf) {

		DaoCachorro daoCachorro = new DaoCachorro();
		
		for (Cachorro cachorro:listarCachorroRepositorio()) {
			if(cachorro.getCAF().equals(caf)) {
				return daoCachorro.deletarCachorro(caf);
			}
		}
		return false;
	}

	@Override
	public boolean alterarCachorroRepositorio(Cachorro cachorro) {
		DaoCachorro daoCachorro = new DaoCachorro();
		return daoCachorro.alterarCachorro(cachorro);
	}

	@Override
	public Cachorro buscaCachorroPorCaf(String caf) {
		for(Cachorro cachorro:listarCachorroRepositorio()) {
			if(cachorro.getCAF().equals(caf)) {
				return cachorro;
			}
		}
		return null;
	}
}

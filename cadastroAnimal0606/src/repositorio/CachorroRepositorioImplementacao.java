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
	public List<Cachorro> listarGerenteRepositorio() {
		DaoCachorro daoCachorro = new DaoCachorro();
		return daoCachorro.retornaListaCachorros();	
	}
}

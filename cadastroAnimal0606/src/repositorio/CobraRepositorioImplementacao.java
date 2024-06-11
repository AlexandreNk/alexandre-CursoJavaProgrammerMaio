package repositorio;

import java.util.List;

import entidade.Cobra;
import persistencia.DaoCobra;

public class CobraRepositorioImplementacao implements CobraRepositorio {

	@Override
	public boolean salvarCobraRepositorio(Cobra cobra) {
		DaoCobra daoCobra = new DaoCobra();
		return daoCobra.salvarCobra(cobra);
	}
	
	@Override
	public List<Cobra> listarCobraRepositorio(){
		DaoCobra daoCobra = new DaoCobra();
		return daoCobra.retornaListaCobra();
	}
}

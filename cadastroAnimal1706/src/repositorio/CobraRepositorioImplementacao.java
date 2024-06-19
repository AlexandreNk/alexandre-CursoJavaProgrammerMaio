package repositorio;

import java.util.List;

import entidade.Cobra;
import persistencia.DaoCobra;
import service.EntidadeService;

public class CobraRepositorioImplementacao implements CobraRepositorio {

	@Override
	public boolean salvarCobraRepositorio(Cobra cobra, String peso) {

		DaoCobra daoCobra = new DaoCobra();
		EntidadeService entidadeService = new EntidadeService();

		if (entidadeService.buscarPrecoCobra(peso) == null) {
			return false;
		} else {
			cobra.setPreco(entidadeService.buscarPrecoCobra(peso));
			return daoCobra.salvarCobra(cobra);
		}

	}

	@Override
	public List<Cobra> listarCobraRepositorio() {
		DaoCobra daoCobra = new DaoCobra();
		return daoCobra.retornaListaCobra();
	}

	@Override
	public boolean excluirCobraRepositorio(String caf) {

		DaoCobra daoCobra = new DaoCobra();

		for (Cobra cobra : listarCobraRepositorio()) {
			if (cobra.getCAF().equals(caf)) {
				return daoCobra.deletarCobra(caf);
			}
		}
		return false;
	}

	@Override
	public boolean alterarCobraRepositorio(Cobra cobra) {
		DaoCobra daoCobra = new DaoCobra();
		return daoCobra.alterarCobra(cobra);
	}

	@Override
	public Cobra buscaCobraPorCaf(String caf) {
		for (Cobra cobra : listarCobraRepositorio()) {
			if (cobra.getCAF().equals(caf)) {
				return cobra;
			}
		}
		return null;
	}


}

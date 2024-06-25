package repositorio;

import entidade.Premium;
import persistencia.DaoPremium;
import servico.EntidadeServico;

public class PremiumRepositorioImplementacao {

	public boolean salvarPremiumRepositorio(Premium premium, String qtdeTransacao) {

		DaoPremium daoPremium = new DaoPremium();
		EntidadeServico entidadeServico = new EntidadeServico();

		if (entidadeServico.buscarValorAnuidadePremium(qtdeTransacao) == null) {
			return false;
		} else {
			premium.setValorDaAnuidade(entidadeServico.buscarValorAnuidadePremium(qtdeTransacao));
			return daoPremium.salvarPremium(premium);
		}
	}
}

package repositorio;

import java.util.List;

import entidade.Premium;
import persistencia.DaoPremium;
import servico.EntidadeServico;

public class PremiumRepositorioImplementacao implements PremiumRepositorio {

	@Override
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

	@Override
	public List<Premium> listarPremiumRepositorio() {
		DaoPremium daoPremium = new DaoPremium();
		return daoPremium.retornaListaDePremiums();
	}

	@Override
	public boolean deletaPremiumRepositorio(String cpf) {
		DaoPremium telaPremium = new DaoPremium();
		if (buscaPremiumPorCpf(cpf) != null) {
			return telaPremium.deletarPremium(cpf);
		} else {
			return false;
		}

	}

	@Override
	public boolean alterarPremiumRepositorio(Premium premium) {
		DaoPremium daoPremium = new DaoPremium();
		if (buscaPremiumPorCpf(premium.getCpf()) != null) {
			return daoPremium.alterarPremium(premium);
		} else {
			return false;
		}
	}

	public Premium buscaPremiumPorCpf(String cpf) {
		for (Premium premiumEncontrado : listarPremiumRepositorio()) {
			if (premiumEncontrado.getCpf().equals(cpf)) {
				return premiumEncontrado;
			}
		}
		return null;
	}

}

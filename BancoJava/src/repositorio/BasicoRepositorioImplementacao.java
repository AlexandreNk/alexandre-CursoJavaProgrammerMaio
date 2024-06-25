package repositorio;

import entidade.Basico;
import persistencia.DaoBasico;
import servico.EntidadeServico;

public class BasicoRepositorioImplementacao implements BasicoRepositorio {

	public boolean salvarBasicoRepositorio(Basico basico, String qtdeTransacao) {

		DaoBasico daoBasico = new DaoBasico();
		EntidadeServico entidadeServico = new EntidadeServico();

		if (entidadeServico.buscarValorAnuidadeBasico(qtdeTransacao) == null) {
			return false;
		} else {
			basico.setValorDaAnuidade(entidadeServico.buscarValorAnuidadeBasico(qtdeTransacao));
			return daoBasico.salvarBasico(basico);
		}
	}

}

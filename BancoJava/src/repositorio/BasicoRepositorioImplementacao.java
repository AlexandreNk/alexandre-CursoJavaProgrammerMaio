package repositorio;

import java.util.List;

import entidade.Basico;
import persistencia.DaoBasico;
import servico.EntidadeServico;

public class BasicoRepositorioImplementacao implements BasicoRepositorio {

	@Override
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

	@Override
	public List<Basico> listarBasicoRepositorio() {
		DaoBasico daoBasico = new DaoBasico();
		return daoBasico.retornaListaDeBasicos();
	}

	@Override
	public boolean deletaBasicoRepositorio(String cpf) {
		DaoBasico telaBasico = new DaoBasico();
		if (buscaBasicoPorCpf(cpf) != null) {
			return telaBasico.deletarBasico(cpf);
		} else {
			return false;
		}

	}

	@Override
	public boolean alterarBasicoRepositorio(Basico basico) {
		DaoBasico daoBasico = new DaoBasico();
		if (buscaBasicoPorCpf(basico.getCpf()) != null) {
			return daoBasico.alterarBasico(basico);
		} else {
			return false;
		}
	}

	public Basico buscaBasicoPorCpf(String cpf) {
		for (Basico basicoEncontrado : listarBasicoRepositorio()) {
			if (basicoEncontrado.getCpf().equals(cpf)) {
				return basicoEncontrado;
			}
		}
		return null;
	}

}

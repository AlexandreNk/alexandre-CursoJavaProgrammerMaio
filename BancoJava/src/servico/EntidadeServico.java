package servico;

import javax.swing.JOptionPane;

import entidade.Basico;
import entidade.Premium;
import validacao.EntidadeValidacao;

public class EntidadeServico {

	public Double buscarValorAnuidadeBasico(String qtdeTransacao) {
		Basico basico = new Basico();
		EntidadeValidacao entidadeValidacao = new EntidadeValidacao();

		if (entidadeValidacao.validaqtdetransacao(qtdeTransacao) == null) {
			JOptionPane.showMessageDialog(null, "O valor " + qtdeTransacao + " Não é valido");
		} else {
			return basico.CalcularAnuidade(entidadeValidacao.validaqtdetransacao(qtdeTransacao));
		}

		return null;
	}

	public Double buscarValorAnuidadePremium(String qtdeTransacao) {
		Premium premium = new Premium();
		EntidadeValidacao entidadeValidacao = new EntidadeValidacao();

		if (entidadeValidacao.validaqtdetransacao(qtdeTransacao) == null) {
			JOptionPane.showMessageDialog(null, "O valor " + qtdeTransacao + " Não é valido");
		} else {
			return premium.CalcularAnuidade(entidadeValidacao.validaqtdetransacao(qtdeTransacao));
		}

		return null;
	}

}

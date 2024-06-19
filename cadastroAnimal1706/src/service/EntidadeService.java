package service;

import javax.swing.JOptionPane;

import entidade.Cachorro;
import entidade.Cobra;
import validacao.EntidadeValidacao;

public class EntidadeService {

	public Double buscarPrecoCachorro(String peso) {
		Cachorro cachorro = new Cachorro();
		EntidadeValidacao entidadeValidacao = new EntidadeValidacao();

		if (entidadeValidacao.validaPeso(peso) == null) {
			JOptionPane.showMessageDialog(null, "O valor " + peso + " Não é valido");
		} else {
			return cachorro.calcularPreco(entidadeValidacao.validaPeso(peso));
		}

		return null;
	}

	public Double buscarPrecoCobra(String peso) {
		Cobra cobra = new Cobra();
		EntidadeValidacao entidadeValidacao = new EntidadeValidacao();

		if (entidadeValidacao.validaPeso(peso) == null) {
			JOptionPane.showMessageDialog(null, "O valor " + peso + " Não é valido");
		} else {
			return cobra.calcularPreco(entidadeValidacao.validaPeso(peso));
		}

		return null;
	}

}

package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidade.Basico;
import repositorio.BasicoRepositorioImplementacao;
import tela.TelaFormularioAlteraBasico;
import tela.TelaMenuBasico;

public class TelaSelecionarAlterarBasicoControlador implements ActionListener {

	JFrame telaListarAlterar;
	JTextField cpf;

	public TelaSelecionarAlterarBasicoControlador(JFrame telaListarAlterar, JTextField cpf) {

		this.telaListarAlterar = telaListarAlterar;
		this.cpf = cpf;
	}

	TelaMenuBasico telaBasico = new TelaMenuBasico();
	TelaFormularioAlteraBasico formularioAlteraBasico = new TelaFormularioAlteraBasico();
	BasicoRepositorioImplementacao basicoRepositorioImplementacao = new BasicoRepositorioImplementacao();

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("ALTERAR")) {

			System.out.println("ir para alterar correntista basico");
			Basico basico = basicoRepositorioImplementacao.buscaBasicoPorCpf(cpf.getText());

			if (basico != null) {
				formularioAlteraBasico.chamarTelaCadastroBasico(basico);
				telaListarAlterar.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null, "O CPF " + cpf.getText() + " Não foi Encontrado!!");
			}

		}

		if (e.getActionCommand().equals("MENU")) {
			System.out.println("Voltar para o menu");
			telaBasico.chamarTelaMenuBasico();
			telaListarAlterar.setVisible(false);

		}

	}

}

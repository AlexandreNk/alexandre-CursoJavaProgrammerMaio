package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import repositorio.BasicoRepositorioImplementacao;
import tela.TelaMenuBasico;

public class TelaDeletarBasicoControlador implements ActionListener {

	JFrame telaDeletarBasico;
	JTextField cpf;

	public TelaDeletarBasicoControlador(JFrame telaDeletarBasico, JTextField cpf) {
		this.telaDeletarBasico = telaDeletarBasico;
		this.cpf = cpf;
	}

	BasicoRepositorioImplementacao basicoRepositorioImplementacao = new BasicoRepositorioImplementacao();

	TelaMenuBasico telaTelaMenuBasico = new TelaMenuBasico();

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("DELETAR")) {
			if (basicoRepositorioImplementacao.deletaBasicoRepositorio(cpf.getText())) {
				JOptionPane.showMessageDialog(null, "Basico Deletado!!");
				telaDeletarBasico.setVisible(false);
				telaTelaMenuBasico.chamarTelaMenuBasico();
			}
		}
		if (e.getActionCommand().equals("MENU")) {
			telaDeletarBasico.setVisible(false);
			telaTelaMenuBasico.chamarTelaMenuBasico();
		}

	}

}

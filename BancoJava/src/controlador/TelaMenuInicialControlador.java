package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import tela.TelaMenuBasico;
import tela.TelaMenuPremium;

public class TelaMenuInicialControlador implements ActionListener {

	// Atributos da classe
	JTextField opcao;
	JFrame frameTelaInicial;

	// Telas
	TelaMenuBasico telaMenuBasico = new TelaMenuBasico();
	TelaMenuPremium telaMenuPremium = new TelaMenuPremium();

	public TelaMenuInicialControlador(JTextField opcao, JFrame frameTelaInicial) {
		this.opcao = opcao;
		this.frameTelaInicial = frameTelaInicial;

	}

	@Override // Vamos entrar no polimorfismo
	public void actionPerformed(ActionEvent e) {

		if (opcao.getText().equals("1") || opcao.getText().equals("2")) {
			switch (opcao.getText()) {
			case "1": {
				telaMenuBasico.chamarTelaMenuBasico();
				System.out.println("Direcione para tela do correntista basico");
				frameTelaInicial.setVisible(false);
				break;
			}
			case "2": {
				telaMenuPremium.chamarTelaMenuPremium();	
				System.out.println("Direcione para tela do correntista premium");
				frameTelaInicial.setVisible(false);
				break;
			}
			case "3": {
				System.exit(0);
				break;

			}

			}
		} else {
			JOptionPane.showMessageDialog(null, "A opcão " + opcao.getText() + " Não é valida");

		}

	}
}

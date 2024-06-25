package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaMenuBasicoControlador implements ActionListener {

	JTextField opcao;
	JFrame telaMenuBasico;

	public TelaMenuBasicoControlador(JTextField opcao, JFrame telaMenuBasico) {
		this.opcao = opcao;
		this.telaMenuBasico = telaMenuBasico;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (opcao.getText().equals("B1") || opcao.getText().equals("B2") || opcao.getText().equals("B3")
				|| opcao.getText().equals("B4")) {
			switch (opcao.getText()) {
			case "B1": {
				telaMenuBasico.setVisible(false);
				//telaCadastroBasico.chamarTelaCadastroBasico();
				break;
			}
			case "B2": {
				telaMenuBasico.setVisible(false);
				//telaListarBasico.listarBasico(basicoRepositorioImplemetacao.listarBasicoRepositorio());
				break;
			}
			case "B3": {
				telaMenuBasico.setVisible(false);
				//telaBasico.deletarBasico(basicoRepositorioImplemetacao.listarBasicoRepositorio());
				break;
			}
			case "B4": {
				telaMenuBasico.setVisible(false);
				//telaAlterarBasico.alterarBasico(basicoRepositorioImplemetacao.listarBasicoRepositorio());
				break;
			}
			}

		} else {
			JOptionPane.showMessageDialog(null, "Opção Invalido");
		}

	}

}

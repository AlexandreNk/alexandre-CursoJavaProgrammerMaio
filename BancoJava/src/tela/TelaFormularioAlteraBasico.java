package tela;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.TelaFormularioAlteraBasicoControlador;
import entidade.Basico;

public class TelaFormularioAlteraBasico {

	public void chamarTelaCadastroBasico(Basico basico) {

		GridLayout grid = new GridLayout(0, 1);
		String primeiroCampo = "Digite o nome do Correntista Basico";
		String quintoCampo = "Digite  o limite do saque do Correntista Basico";

		JFrame frameTelaCadastroBasico = new JFrame();// Instanciando um JFrame Vazio

		frameTelaCadastroBasico.setSize(200, 250); // Altura e largura
		JPanel panelTelaCadastroBasico = new JPanel();// Cria o objeto painel

		panelTelaCadastroBasico.setLayout(grid);

		JLabel labelCpf = new JLabel("CPF:" + basico.getCpf());
		panelTelaCadastroBasico.add(labelCpf);

		JLabel labelPrimeiroCampo = new JLabel(primeiroCampo);
		panelTelaCadastroBasico.add(labelPrimeiroCampo);

		JTextField caixaTextoPrimeiroCampo = new JTextField(10);
		caixaTextoPrimeiroCampo.setText(basico.getNome());
		panelTelaCadastroBasico.add(caixaTextoPrimeiroCampo);

		JLabel labelQuintoCampo = new JLabel(quintoCampo);
		panelTelaCadastroBasico.add(labelQuintoCampo);

		JTextField caixaTextoQuintoCampo = new JTextField(10);
		caixaTextoQuintoCampo.setText(basico.getLimiteDeSaque().toString());
		panelTelaCadastroBasico.add(caixaTextoQuintoCampo);

		// JLabel labelTerceiroCampo = new JLabel(terceiroCampo);
		// panelTelaCadastroBasico.add(labelTerceiroCampo);

		// JTextField caixaTextoTerceiroCampo = new JTextField(10);
		// caixaTextoTerceiroCampo.setText(basico.getSetor());
		// panelTelaCadastroBasico.add(caixaTextoTerceiroCampo);

		JButton botaoAlterar = new JButton("Alterar Basico");
		panelTelaCadastroBasico.add(botaoAlterar);

		frameTelaCadastroBasico.add(panelTelaCadastroBasico);
		frameTelaCadastroBasico.setVisible(true);

		TelaFormularioAlteraBasicoControlador alteraBasicoControlador = new TelaFormularioAlteraBasicoControlador(
				caixaTextoPrimeiroCampo, quintoCampo, caixaTextoPrimeiroCampo, frameTelaCadastroBasico);
		botaoAlterar.addActionListener(alteraBasicoControlador);

	}
}

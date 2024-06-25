package tela;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.TelaMenuBasicoControlador;

public class TelaMenuBasico {

	public void chamarTelaMenuBasico() {
		GridLayout grid = new GridLayout(0, 1);

		JFrame frameTelaMenuBasico = new JFrame();// Instanciando um JFrame Vazio

		frameTelaMenuBasico.setSize(200, 200); // Altura e largura
		JPanel panelTelaMenuBasico = new JPanel();// Cria o objeto painel

		JLabel labelOpcaoCadastroBasico = new JLabel("B1 - CADASTRAR CORRENTISTA BASICO");// Cria a label 1
		panelTelaMenuBasico.add(labelOpcaoCadastroBasico);// Adiciona a label 1 no painel

		JLabel labelOpcaoListaBasico = new JLabel("B2 - LISTAR CORRENTISTA BASICO");// Cria a label 1
		panelTelaMenuBasico.add(labelOpcaoListaBasico);// Adiciona a label 1 no painel

		JLabel labelOpcaoDeletarBasico = new JLabel("B3 - DELETAR CORRENTISTA BASICO");// Cria a label 1
		panelTelaMenuBasico.add(labelOpcaoDeletarBasico);// Adiciona a label 1 no painel

		JLabel labelOpcaoAlterarBasico = new JLabel("B4 - ALTERAR CORRENTISTA BASICO");// Cria a label 1
		panelTelaMenuBasico.add(labelOpcaoAlterarBasico);// Adiciona a label 1 no painel

		panelTelaMenuBasico.setLayout(grid);

		JTextField opcaoTexto = new JTextField(10);// Caixa de texto

		panelTelaMenuBasico.add(opcaoTexto);// add o que foi digitado

		JButton botaoEnviar = new JButton("Enviar");
		panelTelaMenuBasico.add(botaoEnviar);

		frameTelaMenuBasico.add(panelTelaMenuBasico);// Adiciona o painel no frame
		frameTelaMenuBasico.setVisible(true);// Deixa visivel

		TelaMenuBasicoControlador basicoControlador = new TelaMenuBasicoControlador(opcaoTexto, frameTelaMenuBasico);
		botaoEnviar.addActionListener(basicoControlador);

	}
}

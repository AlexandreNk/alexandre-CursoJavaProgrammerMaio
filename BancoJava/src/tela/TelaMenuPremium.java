package tela;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.TelaMenuPremiumControlador;

public class TelaMenuPremium {
	public void chamarTelaMenuPremium() {
		GridLayout grid = new GridLayout(0, 1);

		JFrame frameTelaMenuPremium = new JFrame();// Instanciando um JFrame Vazio

		frameTelaMenuPremium.setSize(200, 200); // Altura e largura
		JPanel panelTelaMenuPremium = new JPanel();// Cria o objeto painel

		JLabel labelOpcaoCadastroPremium = new JLabel("P1 - CADASTRAR CORRENTISTA PREMIUM");// Cria a label 1
		panelTelaMenuPremium.add(labelOpcaoCadastroPremium);// Adiciona a label 1 no painel

		JLabel labelOpcaoListaPremium = new JLabel("P2 - LISTAR CORRENTISTA PREMIUM");// Cria a label 1
		panelTelaMenuPremium.add(labelOpcaoListaPremium);// Adiciona a label 1 no painel

		JLabel labelOpcaoDeletarPremium = new JLabel("P3 - DELETAR CORRENTISTA PREMIUM");// Cria a label 1
		panelTelaMenuPremium.add(labelOpcaoDeletarPremium);// Adiciona a label 1 no painel

		JLabel labelOpcaoAlterarPremium = new JLabel("P4 - ALTERAR CORRENTISTA PREMIUM");// Cria a label 1
		panelTelaMenuPremium.add(labelOpcaoAlterarPremium);// Adiciona a label 1 no painel

		panelTelaMenuPremium.setLayout(grid);

		JTextField opcaoTexto = new JTextField(10);// Caixa de texto

		panelTelaMenuPremium.add(opcaoTexto);// add o que foi digitado

		JButton botaoEnviar = new JButton("Enviar");
		panelTelaMenuPremium.add(botaoEnviar);

		frameTelaMenuPremium.add(panelTelaMenuPremium);// Adiciona o painel no frame
		frameTelaMenuPremium.setVisible(true);// Deixa visivel

		TelaMenuPremiumControlador premiumControlador = new TelaMenuPremiumControlador(opcaoTexto, frameTelaMenuPremium);
		botaoEnviar.addActionListener(premiumControlador);

	}
}

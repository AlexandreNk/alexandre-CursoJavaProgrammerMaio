package tela;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controlador.TelaListarCobraControlador;
import entidade.Cobra;

public class TelaListarCobra {

	public void listarCobra(List<Cobra> listaCobra) {
		
		int quantidadeDeLinhas = listaCobra.size();
		
		String[][] tabelaString = new String [quantidadeDeLinhas][4];
		
		int posicaoColuna = 0;
		int posicaoLinha = 0;
		
		for(Cobra cobra : listaCobra) {
			
			tabelaString[posicaoLinha][posicaoColuna] = cobra.getCAF();
			posicaoColuna ++;
			
			tabelaString [posicaoLinha][posicaoColuna] = cobra.getNome();		
			posicaoColuna ++;
			
			tabelaString [posicaoLinha][posicaoColuna] = cobra.getTipoVeneno();			
			posicaoColuna ++;
			
			tabelaString [posicaoLinha][posicaoColuna] = cobra.getPreco().toString();
			//posicaoColuna ++;
			
			//tabelaString[posicaoLinha][posicaoColuna]= cobra.getEndereco().getLogradouro();

			//posicaoLinha ++;
			posicaoColuna = 0;
			
			
		}
		
		String nomeColunas [] = {"CAF", "NOME", "TIPOVENENO","PRECO"};
		
		
		JFrame frameListarCobra = new JFrame();
		
		frameListarCobra.setSize(475,450);
		
		JTable tabelaCobra = new JTable(tabelaString, nomeColunas);
		tabelaCobra.setSize(1000,1000);
		tabelaCobra.setBounds(30, 40, 300, 300);
		
		
		JScrollPane scrollPaneListarCobra = new JScrollPane(tabelaCobra);
		scrollPaneListarCobra.setPreferredSize(new Dimension(400, 160));
		
		JPanel panelListarCobra = new JPanel();
		panelListarCobra.setSize(1000,1000);
		
		JButton botaoMenu = new JButton("MENU");
		
		JButton botaoDetalhar = new JButton("DETALHAR");
		
		JTextField cafTextField = new JTextField(10);

		panelListarCobra.add(cafTextField);
		panelListarCobra.add(botaoDetalhar);

		panelListarCobra.add(scrollPaneListarCobra);
		panelListarCobra.add(botaoMenu);
		frameListarCobra.add(panelListarCobra);
		frameListarCobra.setVisible(true);

		TelaListarCobraControlador cobraControlador = new TelaListarCobraControlador(frameListarCobra,cafTextField);
		botaoMenu.addActionListener(cobraControlador);
		botaoDetalhar.addActionListener(cobraControlador);
		
		
		
	}
}

package tela;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controlador.TelaListarCachorroControlador;
import entidade.Cachorro;

public class TelaListarCachorro {
	
	public void listarCachorro(List<Cachorro> listaCachorro) {
		
		int quantidadeDeLinhas = listaCachorro.size();
		
		String[][] tabelaString = new String [quantidadeDeLinhas][4];
		
		int posicaoColuna = 0;
		int posicaoLinha = 0;
		
		for(Cachorro cachorro : listaCachorro) {
			
			tabelaString[posicaoLinha][posicaoColuna] = cachorro.getCAF();
			posicaoColuna ++;
			
			tabelaString [posicaoLinha][posicaoColuna] = cachorro.getNome();			
			posicaoColuna ++;
			
			tabelaString [posicaoLinha][posicaoColuna] = cachorro.getCorPelo();			
			posicaoColuna ++;
			
			tabelaString [posicaoLinha][posicaoColuna] = cachorro.getPreco().toString();
			//posicaoColuna ++;
			
			//tabelaString[posicaoLinha][posicaoColuna]= cachorro.getEndereco().getLogradouro();

			posicaoLinha ++;
			posicaoColuna = 0;
			
			
		}
		
		String nomeColunas [] = {"CAF", "NOME", "COR_DO_PELO", "PRECO"};
		
		
		JFrame frameListarCachorro = new JFrame();
		
		frameListarCachorro.setSize(475,450);
		
		JTable tabelaCachorro = new JTable(tabelaString, nomeColunas);
		tabelaCachorro.setSize(1000,1000);
		tabelaCachorro.setBounds(30, 40, 300, 300);
		
		
		JScrollPane scrollPaneListarCachorro = new JScrollPane(tabelaCachorro);
		scrollPaneListarCachorro.setPreferredSize(new Dimension(400, 160));
		
		JPanel panelListarCachorro = new JPanel();
		panelListarCachorro.setSize(1000,1000);
		
		JButton botaoMenu = new JButton("MENU");
		
		JButton botaoDetalhar = new JButton("DETALHAR");
		
		JTextField cafTextField = new JTextField(10);

		panelListarCachorro.add(cafTextField);
		panelListarCachorro.add(botaoDetalhar);

		panelListarCachorro.add(scrollPaneListarCachorro);
		panelListarCachorro.add(botaoMenu);
		frameListarCachorro.add(panelListarCachorro);
		frameListarCachorro.setVisible(true);

		TelaListarCachorroControlador cachorroControlador = new TelaListarCachorroControlador(frameListarCachorro,cafTextField);
		botaoMenu.addActionListener(cachorroControlador);
		botaoDetalhar.addActionListener(cachorroControlador);
		
		
		
		
		
		
	}
}

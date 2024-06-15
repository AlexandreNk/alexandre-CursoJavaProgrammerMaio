package tela;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import entidade.Cobra;

public class TelaListaCobra {

	public void listarCobra(List<Cobra> listaCobra) {
		
		int quantidadeDeLinhas = listaCobra.size();
		
		String[][] tabelaString = new String [quantidadeDeLinhas][3];
		
		int posicaoColuna = 0;
		int posicaoLinha = 0;
		
		for(Cobra cobra : listaCobra) {
			
			tabelaString[posicaoLinha][posicaoColuna] = cobra.getCAF();
			posicaoColuna ++;
			
			tabelaString [posicaoLinha][posicaoColuna] = cobra.getNome();
			
			posicaoColuna ++;
			tabelaString [posicaoLinha][posicaoColuna] = cobra.getTipoVeneno();
			
			posicaoLinha ++;
			posicaoColuna = 0;
			
			
		}
		
		String nomeColunas [] = {"CAF", "NOME", "COR_DO_PELO"};
		
		
		JFrame frameListarCobra = new JFrame();
		
		frameListarCobra.setSize(475,450);
		
		JTable tabelaCobra = new JTable(tabelaString, nomeColunas);
		tabelaCobra.setSize(1000,1000);
		tabelaCobra.setBounds(30, 40, 300, 300);
		
		
		JScrollPane scrollPaneListarCobra = new JScrollPane(tabelaCobra);
		scrollPaneListarCobra.setPreferredSize(new Dimension(400, 160));
		
		JPanel panelListarCobra = new JPanel();
		panelListarCobra.setSize(1000,1000);
		
		panelListarCobra.add(scrollPaneListarCobra);
		
		frameListarCobra.add(panelListarCobra);
		frameListarCobra.setVisible(true);
		
		
		
		
	}
}

package controlador;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import entidade.Cachorro;

public class TelaListaCachorro {

	public void listaCachorro(List<Cachorro> listaCachorro) {
		
		int quantidadeLinhas = listaCachorro.size();
		
		String[][] tabelaString = new String [quantidadeLinhas][5];
		
		int posicaoColuna =0;
		int posicaoLinha = 0;
		
		for(Cachorro cachorro : listaCachorro) {
			
			tabelaString[posicaoLinha][posicaoColuna] = cachorro.getNome();
			posicaoColuna ++;
			
			tabelaString[posicaoLinha][posicaoColuna] = cachorro.getCAF();
			posicaoColuna ++;
			
			tabelaString[posicaoLinha][posicaoColuna]= cachorro.getCorPelo();
			posicaoColuna ++;

			tabelaString[posicaoLinha][posicaoColuna]= cachorro.getPreco().toString();
			posicaoColuna ++;
			
			tabelaString[posicaoLinha][posicaoColuna]= cachorro.getEndereco().getLogradouro();
			posicaoLinha ++;

			posicaoColuna= 0;
		}
		
		String nomeColunas[] = {"Nome","CAF","CorPelo", "Preco", "Logradouro" };
		
		JFrame frameListaCachorro = new JFrame();
		
		frameListaCachorro.setSize(500, 600);
		
		JTable tabelaCachorro = new JTable(tabelaString,nomeColunas);
		
		tabelaCachorro.setBounds(30,40,300,300);
		
		JScrollPane scrollPaneListaCachorro = new JScrollPane(tabelaCachorro);
		
		JPanel panelListaCachorro = new JPanel();
		
		panelListaCachorro.add(scrollPaneListaCachorro);
		
		frameListaCachorro.add(panelListaCachorro);	
		frameListaCachorro.setVisible(true);
		
	}
	
}

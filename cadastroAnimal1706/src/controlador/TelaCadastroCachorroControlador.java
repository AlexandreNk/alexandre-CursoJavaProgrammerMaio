package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidade.Cachorro;
import enuns.CachorroEnum;
import repositorio.CachorroRepositorioImplementacao;
import tela.TelaMenuCachorro;

public class TelaCadastroCachorroControlador implements ActionListener {

	JTextField caixaTextoPrimeiroCampoRecebidoNome;
	JTextField caixaTextoSegundoCampoRecebidoCaf;
	JComboBox<CachorroEnum> caixaSelecaoCor;
	JTextField peso;
	JFrame frameTelaCadastroCachorro;

	//ManipuladorArquivo manipuladorArquivo = new ManipuladorArquivo();
	//	DaoCachorro daoCachorro = new DaoCachorro();
	CachorroRepositorioImplementacao cachorroRepositorioImp = new CachorroRepositorioImplementacao();
	TelaMenuCachorro telaCachorro = new TelaMenuCachorro();
	

	public TelaCadastroCachorroControlador(JTextField caixaTextoPrimeiroCampoRecebidoNome,
			JTextField caixaTextoSegundoCampoRecebidoCaf, JComboBox<CachorroEnum> caixaSelecaoCor,
			JFrame frameTelaCadastroCachorro, JTextField caixaTextoQuartoCampoRecebidoSetor) {
		this.caixaTextoPrimeiroCampoRecebidoNome = caixaTextoPrimeiroCampoRecebidoNome;
		this.caixaTextoSegundoCampoRecebidoCaf = caixaTextoSegundoCampoRecebidoCaf;
		this.caixaSelecaoCor = caixaSelecaoCor;
		this.peso = caixaTextoQuartoCampoRecebidoSetor;
		this.frameTelaCadastroCachorro = frameTelaCadastroCachorro;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		registrarArquivo();
		/*14/06/2024
		System.out.println("O nome do cachorro: " + caixaTextoPrimeiroCampoRecebidoNome.getText());
		System.out.println("O Caf: " + caixaTextoSegundoCampoRecebidoCaf.getText());
		System.out.println("A cor do pelo: " + caixaTextoTerceiroCampoRecebidoCorPelo.getText());
		*/
		frameTelaCadastroCachorro.setVisible(false);
		telaCachorro.chamarTelaMenuCachorro();

	}

	public void registrarArquivo() {
		Cachorro cachorro = new Cachorro();
		cachorro.setNome(caixaTextoPrimeiroCampoRecebidoNome.getText());
		cachorro.setCAF(caixaTextoSegundoCampoRecebidoCaf.getText());
		cachorro.setCorPelo(caixaSelecaoCor.getSelectedItem().toString());

		//14/06/2024 manipuladorArquivo.registrarCachorro(cachorro);
		// daoCachorro.salvarCachorro(cachorro);

		if (cachorroRepositorioImp.salvarCachorroRepositorio(cachorro, peso.getText())) {
			JOptionPane.showMessageDialog(null, "Salvou com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Não salvou!");
		}
	}

}

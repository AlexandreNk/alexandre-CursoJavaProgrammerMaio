package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import repositorio.CachorroRepositorioImplementacao;
import tela.TelaCadastroCachorro;
import tela.TelaDeletarCachorro;
import tela.TelaListarCachorro;
import tela.TelaSelecionarAlterarCachorro;

public class TelaMenuCachorroControlador implements ActionListener {

	JTextField opcaoRecebida;
	JFrame frameTelaMenuCachorro;

	TelaCadastroCachorro cadastroCachorro = new TelaCadastroCachorro();
	TelaListarCachorro telaListarCachorro = new TelaListarCachorro();
	TelaDeletarCachorro telaDeletarCachorro = new TelaDeletarCachorro();
	TelaSelecionarAlterarCachorro alterarSelecionarCachorro = new TelaSelecionarAlterarCachorro();
	
	CachorroRepositorioImplementacao cachorroRepositorio = new CachorroRepositorioImplementacao();

	// DaoCachorro daoCachorro = new DaoCachorro();
	// List<Cachorro> listCachorro = new ArrayList<Cachorro>();

	public TelaMenuCachorroControlador(JTextField opcaoRecebida, JFrame frameTelaMenuCachorro) {
		this.opcaoRecebida = opcaoRecebida;
		this.frameTelaMenuCachorro = frameTelaMenuCachorro;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (opcaoRecebida.getText().equals("G1") || opcaoRecebida.getText().equals("G2") || opcaoRecebida.getText().equals("G3") || opcaoRecebida.getText().equals("G4")) {
			switch (opcaoRecebida.getText()) {
			case "G1": {
				cadastroCachorro.chamarTelaCadastroCachorro();
				System.out.println("Direcione para cadastro de cachorros");
				frameTelaMenuCachorro.setVisible(false);
				break;
			}
			case "G2": {
				// cadastroCachorro.imprimirCachorro(daoCachorro.retornaListaCachorros());
				frameTelaMenuCachorro.setVisible(false);
				telaListarCachorro.listarCachorro(cachorroRepositorio.listarCachorroRepositorio());
				System.out.println("Direcione para lista de cachorros");
				break;
			}
			case "G3": {
				frameTelaMenuCachorro.setVisible(false);
				telaDeletarCachorro.chamarTelaDeletarCachorro(cachorroRepositorio.listarCachorroRepositorio());
				System.out.println("Direcione para deletar cachorro");
				break;
			}
			case "G4": {
				frameTelaMenuCachorro.setVisible(false);
				alterarSelecionarCachorro.chamarTelaDeletarCachorro(cachorroRepositorio.listarCachorroRepositorio());
				System.out.println("Direcione para alterar o cachorro");
				break;
			}
			case "SAIR": {
				System.exit(0);
				break;
			}

			}
		} else {
			JOptionPane.showMessageDialog(null, "A opção " + opcaoRecebida.getText() + " não é válida");
		}

	}

}

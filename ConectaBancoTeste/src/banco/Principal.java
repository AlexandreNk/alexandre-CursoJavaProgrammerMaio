package banco;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {

		ConectaBanco conexao = new ConectaBanco();

		DaoPessoa daoPessoa = new DaoPessoa();
		
		boolean resultado = daoPessoa.salvarPessoaNobanco();
		
		if(resultado) {
			JOptionPane.showConfirmDialog(null, "Deu certo");
		}else {
			JOptionPane.showConfirmDialog(null, "Deu errado");
		}
				
		
	}

}



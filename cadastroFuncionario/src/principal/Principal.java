package principal;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		
		int soma, num1 = 0, num2 = 0;

        num1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um numero: "));
        num2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um numero: "));

        soma = num1 + num2;

        JOptionPane.showMessageDialog(null, "A soma é: " + soma);

	}

}

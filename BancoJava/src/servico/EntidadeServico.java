package servico;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import entidade.Basico;
import entidade.Premium;
import validacao.EntidadeValidacao;

public class EntidadeServico {

	public Double buscarValorAnuidadeBasico(String qtdeTransacao) {
		Basico basico = new Basico();
		EntidadeValidacao entidadeValidacao = new EntidadeValidacao();

		if (entidadeValidacao.validaqtdetransacao(qtdeTransacao) == null) {
			JOptionPane.showMessageDialog(null, "O valor " + qtdeTransacao + " Não é valido");
		} else {
			return basico.CalcularAnuidade(entidadeValidacao.validaqtdetransacao(qtdeTransacao));
		}

		return null;
	}

	public Double buscarValorAnuidadePremium(String qtdeTransacao) {
		Premium premium = new Premium();
		EntidadeValidacao entidadeValidacao = new EntidadeValidacao();

		if (entidadeValidacao.validaqtdetransacao(qtdeTransacao) == null) {
			JOptionPane.showMessageDialog(null, "O valor " + qtdeTransacao + " Não é valido");
		} else {
			return premium.CalcularAnuidade(entidadeValidacao.validaqtdetransacao(qtdeTransacao));
		}

		return null;
	}

	public void gerarPdfDetalharPremium(Premium premium) {
		String caminhoArquivo = System.getProperty("user.dir") + "\\" + "RelatorioDetalharPremium-" + premium.getNome()
				+ ".pdf";
		// Caminho do arquivo com o nome do premium
		Document document = new Document();
		// Objeto java do Document que vai ser manipulado

		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(caminhoArquivo));
			writer.setPageEvent(new RodapeTemplate());
			// Objeto gerador de PDF usando o cabeçalho e rodapé da classe
			// CabecalhoRodapeTemplate()

			document.open();// Abre Manipulação do objeto Document
			document.add(new Paragraph("Empresa: IMPACTA", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14)));
			// Adiciona nome da empresa no cabeçalho
			document.add(new Paragraph("Relatorio de Detalhe do Correntista Premium",
					FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14)));
			// Adiciona o nome do relatorio
			document.add(new Paragraph(" "));// pular uma linha

			if (premium != null) {

				PdfPTable table = new PdfPTable(2);// Cria objeto da tabela com a quantidade de colunas
				table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
				table.setWidthPercentage(100);// Ocupação da tabela na pagina

				table.addCell("CPF");// Primeiro item da primeira linha
				table.addCell(premium.getCpf());// segundo item da primeira linha

				table.addCell("Nome");
				table.addCell(premium.getNome());

				table.addCell("Valor_Anuidade");
				table.addCell(premium.getValorDaAnuidade().toString());

				table.addCell("Cep");
				table.addCell(premium.getEndereco().getCep());

				table.addCell("Localidade");
				table.addCell(premium.getEndereco().getLocalidade());

				table.addCell("Logradouro");
				table.addCell(premium.getEndereco().getLogradouro());

				table.addCell("Bairro");
				table.addCell(premium.getEndereco().getBairro());

				table.addCell("Uf");
				table.addCell(premium.getEndereco().getUf());

				table.addCell("Siafi");
				if (premium.getEndereco().getSiafi() == null) {

					table.addCell("Não informado");
				} else {
					table.addCell(premium.getEndereco().getSiafi());
				}

				document.add(table);

			}

			document.close();

			File pdfArquivo = new File(caminhoArquivo);

			if (pdfArquivo.exists()) {
				if (Desktop.isDesktopSupported()) {
					Desktop.getDesktop().open(pdfArquivo);
				} else {
					System.out.println("PDF gerado mas não foi possivel abrir");
				}

			} else {
				System.out.println("PDF gerado mas não foi possivel encontrar");
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void gerarPdfDetalharBasico(Basico basico) {
		String caminhoArquivo = System.getProperty("user.dir") + "\\" + "RelatorioDetalharBasico-" + basico.getNome()
				+ ".pdf";
		// Caminho do arquivo com o nome do premium
		Document document = new Document();
		// Objeto java do Document que vai ser manipulado

		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(caminhoArquivo));
			writer.setPageEvent(new RodapeTemplate());
			// Objeto gerador de PDF usando o cabeçalho e rodapé da classe
			// CabecalhoRodapeTemplate()

			document.open();// Abre Manipulação do objeto Document
			document.add(new Paragraph("Empresa: IMPACTA", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14)));
			// Adiciona nome da empresa no cabeçalho
			document.add(new Paragraph("Relatorio de Detalhe do Correntista Basico",
					FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14)));
			// Adiciona o nome do relatorio
			document.add(new Paragraph(" "));// pular uma linha

			if (basico != null) {

				PdfPTable table = new PdfPTable(2);// Cria objeto da tabela com a quantidade de colunas
				table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
				table.setWidthPercentage(100);// Ocupação da tabela na pagina

				table.addCell("CPF");// Primeiro item da primeira linha
				table.addCell(basico.getCpf());// segundo item da primeira linha

				table.addCell("Nome");
				table.addCell(basico.getNome());

				table.addCell("Valor_Anuidade");
				table.addCell(basico.getValorDaAnuidade().toString());

				table.addCell("Cep");
				table.addCell(basico.getEndereco().getCep());

				table.addCell("Localidade");
				table.addCell(basico.getEndereco().getLocalidade());

				table.addCell("Logradouro");
				table.addCell(basico.getEndereco().getLogradouro());

				table.addCell("Bairro");
				table.addCell(basico.getEndereco().getBairro());

				table.addCell("Uf");
				table.addCell(basico.getEndereco().getUf());

				table.addCell("Siafi");
				if (basico.getEndereco().getSiafi() == null) {

					table.addCell("Não informado");
				} else {
					table.addCell(basico.getEndereco().getSiafi());
				}

				document.add(table);

			}

			document.close();

			File pdfArquivo = new File(caminhoArquivo);

			if (pdfArquivo.exists()) {
				if (Desktop.isDesktopSupported()) {
					Desktop.getDesktop().open(pdfArquivo);
				} else {
					System.out.println("PDF gerado mas não foi possivel abrir");
				}

			} else {
				System.out.println("PDF gerado mas não foi possivel encontrar");
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}

}

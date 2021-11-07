package pdfs;

import classes.Piloto;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public abstract class Pdf {
    
    public static boolean gerar() {
        // Criando documento formato A4
        Document document = new Document(PageSize.A4);
        
        try {
            // Decidindo o caminho de destino após o pdf ser gerado
            String dirCurrent = new File(".").getCanonicalPath();
            String destPdf = dirCurrent + "/src/pdfs/arquivo.pdf";
            
            // Montando a instancia de iText para escrever o arquivo
            PdfWriter.getInstance(document, new FileOutputStream(destPdf));
            
            // Abrindo o domento
            document.open();
            
            // Criando logo no canto superior esquerdo
            Image logo = Image.getInstance(dirCurrent + "/src/assets/Logo_menor.jpg");
            logo.setAlignment(Element.PARAGRAPH);
            
            // Criando titulo do pdf
            Font fontTitle = new Font(Font.FontFamily.UNDEFINED, 20, Font.BOLD, BaseColor.BLACK);
            Phrase titlePhrase = new Phrase(20F, "Relatório de sorteio", fontTitle);
            Paragraph title = new Paragraph(titlePhrase);
            title.setIndentationLeft(130f);
            title.setLeading(40f);
            
            // Montando o cabeçalho
            document.add(logo);
            document.add(title);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            
            Font fontSubTitle = new Font(Font.FontFamily.UNDEFINED, 18, Font.BOLDITALIC, BaseColor.BLACK);
            Font fontSorteio = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.BLACK);
            
            if (listas.Pilotos.pilotosSabado.get(0).getTrilha() != null) {
                // Criando seção de sorteios de sábado
                Phrase subTitleSaturdayPhrase = new Phrase(18F, "\nSábado", fontSubTitle);
                Paragraph subTitleSaturday = new Paragraph(subTitleSaturdayPhrase);
                subTitleSaturday.setAlignment(Element.ALIGN_LEFT);
                document.add(subTitleSaturday);

                // Adicionando sorteios de sabádo
                StringBuilder sbSorteioSabado = new StringBuilder();
                for (Piloto p : listas.Pilotos.pilotosSabado) {
                    sbSorteioSabado.append(p.toString());
                }

                Phrase sorteioSabadoPhrase = new Phrase(12F, sbSorteioSabado.toString(), fontSorteio);
                Paragraph sorteioSabado = new Paragraph(sorteioSabadoPhrase);
                document.add(Chunk.NEWLINE);
                document.add(Chunk.NEWLINE);
                document.add(sorteioSabado);
            }
            
            if (listas.Pilotos.pilotosDomingo.get(0).getTrilha() != null) {
                // Criando seção de sorteios de domingo
                Phrase subTitleSundayPhrase = new Phrase(18F, "\nDomingo", fontSubTitle);
                Paragraph subTitleSunday = new Paragraph(subTitleSundayPhrase);
                subTitleSunday.setAlignment(Element.ALIGN_LEFT);
                document.add(Chunk.NEWLINE);
                document.add(Chunk.NEWLINE);
                document.add(subTitleSunday);

                // Adicionando sorteios de domingo
                StringBuilder sbSorteioDomingo = new StringBuilder();
                for (Piloto p : listas.Pilotos.pilotosDomingo) {
                    sbSorteioDomingo.append(p.toString());
                }

                Phrase sorteioDomingoPhrase = new Phrase(12F, sbSorteioDomingo.toString(), fontSorteio);
                Paragraph sorteioDomingo = new Paragraph(sorteioDomingoPhrase);
                document.add(Chunk.NEWLINE);
                document.add(Chunk.NEWLINE);
                document.add(sorteioDomingo);
            }
            
            return true;
        } catch (IOException | DocumentException e) {
            
            // Exceções que podem ser geradas
            System.out.println(e.getMessage());
            return false;
        } finally {
            
            // Fechando o arquivo após a inscrição
            document.close();
        }
    }
}
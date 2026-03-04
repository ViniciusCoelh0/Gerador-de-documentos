package org.Program.Service;

import org.Program.Enum.Alinhamento;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileOutputStream;
import java.io.IOException;

public class DocumentService {

    private ParagraphAlignment converterAlinhamento (Alinhamento alinhamento){
        return switch (alinhamento){
            case DIREITA -> ParagraphAlignment.RIGHT;
            case CENTRO -> ParagraphAlignment.CENTER;
            case ESQUERDA -> ParagraphAlignment.LEFT;
        };
    }

    public void adicionarParagrafo(
            XWPFDocument documento,
            String texto,
            EstiloFonte estilo
    ){

        XWPFParagraph paragrafo = documento.createParagraph();
        paragrafo.setAlignment(estilo.getAlinhamento());

        XWPFRun run = paragrafo.createRun();
        run.setText(texto);
        run.setFontSize(estilo.getTamanho());
        run.setFontFamily(estilo.getFonte());
        run.setBold(estilo.isNegrito());
        run.setItalic(estilo.isItalico());

    }

    public void adicionarTitulo(
            XWPFDocument documento,
            String titulo,
            int tamanhoTitulo,
            Alinhamento opcaoAlinhamento) {

        ParagraphAlignment alinhamento = converterAlinhamento(opcaoAlinhamento);

        EstiloFonte estilo = new EstiloFonte(
                tamanhoTitulo,
                "Arial",
                true,
                false,
                alinhamento
        );
        adicionarParagrafo(documento, titulo, estilo);
    }

    public void adicionarSubtitulo(
            XWPFDocument documento,
            String subtitulo,
            int tamanhoTexto
    ){

        EstiloFonte estilo = new EstiloFonte(
                tamanhoTexto,
                "Calibri",
                true,
                false,
                ParagraphAlignment.LEFT
        );
        adicionarParagrafo(documento, subtitulo, estilo);
    }

    public void adicionarTexto(
            XWPFDocument documento,
            String texto,
            int tamanhoTexto) {

        EstiloFonte estilo = new EstiloFonte(
                tamanhoTexto,
                "Times New Roman",
                false,
                false,
                ParagraphAlignment.BOTH
        );

        adicionarParagrafo(documento, texto, estilo);

    }
//    public void gerarDocumentoCompleto(String titulo, String subtitulo, String texto){
//
//        try(XWPFDocument documento = new XWPFDocument();
//            FileOutputStream out = new FileOutputStream("documento.docx"))
//        {
//            adicionarTitulo(documento, titulo, 22, Alinhamento.CENTRO);
//            adicionarSubtitulo(documento, subtitulo, 14);
//            adicionarTexto(documento, texto, 12);
//
//            documento.write(out);
//
//        } catch (IOException e) {
//            throw new RuntimeException("Erro ao gerar documento", e);
//        }
//    }
}

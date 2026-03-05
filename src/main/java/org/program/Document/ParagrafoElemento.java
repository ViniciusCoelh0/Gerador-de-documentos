package org.program.Document;

import org.program.Style.EstiloFonte;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class ParagrafoElemento implements ElementoDocumento{

    private final String texto;
    private final EstiloFonte estilo;

    public ParagrafoElemento(String texto, EstiloFonte estilo) {
        this.texto = texto;
        this.estilo = estilo;
    }

    @Override
    public void aplicar(XWPFDocument document) {
        XWPFParagraph paragrafo = document.createParagraph();
        paragrafo.setAlignment(estilo.getAlinhamento());

        XWPFRun run = paragrafo.createRun();
        run.setText(texto);
        run.setFontSize(estilo.getTamanho());
        run.setFontFamily(estilo.getFonte());
        run.setBold(estilo.isNegrito());
        run.setItalic(estilo.isItalico());
        paragrafo.setSpacingAfter(200);
        paragrafo.setSpacingBefore(200);

    }
}

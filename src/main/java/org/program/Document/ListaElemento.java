package org.program.Document;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum;
import org.program.Style.EstiloFonte;
import org.apache.poi.xwpf.usermodel.*;

import java.math.BigInteger;
import java.util.List;

public class ListaElemento implements ElementoDocumento{

    private final List<String> itens;
    private final EstiloFonte estilo;

    public ListaElemento(List<String> itens, EstiloFonte estilo){
        this.itens = itens;
        this.estilo = estilo;
    }

    @Override
    public void aplicar(XWPFDocument document) {
        XWPFNumbering numbering = document.createNumbering();

        CTAbstractNum ctAbstractNum = CTAbstractNum.Factory.newInstance();
        ctAbstractNum.setAbstractNumId(BigInteger.valueOf(0));

        XWPFAbstractNum abstractNum = new XWPFAbstractNum(ctAbstractNum);
        BigInteger abstractNumId = numbering.addAbstractNum(abstractNum);

        BigInteger numId = numbering.addNum(abstractNumId);

        for(String item : itens){

            XWPFParagraph paragrafo = document.createParagraph();
            paragrafo.setNumID(numId);

            XWPFRun run = paragrafo.createRun();
            run.setText(item);
            run.setFontSize(estilo.getTamanho());
            run.setFontFamily(estilo.getFonte());
            run.setBold(estilo.isNegrito());
            run.setItalic(estilo.isItalico());

        }
    }

    //    private final List<String> itens;
//    private final EstiloFonte estilo;
//
//    public ListaElemento(List<String> itens, EstiloFonte estilo) {
//        this.itens = itens;
//        this.estilo = estilo;
//    }
//
//    @Override
//    public void aplicar(XWPFDocument document) {
//        XWPFNumbering numbering = document.createNumbering();
//
//        BigInteger numId = numbering.addNum(numbering.addAbstractNum(new XWPFAbstractNum()));
//
//        for (String item : itens){
//
//            XWPFParagraph paragrafo = document.createParagraph();
//            paragrafo.setNumID(numId);
//            paragrafo.setAlignment(estilo.getAlinhamento());
//
//            XWPFRun run = paragrafo.createRun();
//            run.setText(item);
//            run.setFontSize(estilo.getTamanho());
//            run.setFontFamily(estilo.getFonte());
//            run.setBold(estilo.isNegrito());
//            run.setItalic(estilo.isItalico());
//        }
//    }
}

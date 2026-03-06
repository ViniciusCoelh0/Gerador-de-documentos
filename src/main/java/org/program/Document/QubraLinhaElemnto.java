package org.program.Document;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class QubraLinhaElemnto implements ElementoDocumento{

    @Override
    public void aplicar(XWPFDocument document) {
        document.createParagraph();
    }
}

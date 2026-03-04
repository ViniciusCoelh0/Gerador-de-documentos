package org.Program.Builder;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.security.PublicKey;

public class DocumentBuilder {

    private XWPFDocument document;

    public DocumentBuilder(){
        this.document = new XWPFDocument();
    }

    public DocumentBuilder titulo(String texto){
        // Vai usar o Estilofonte.titulo();
        return this; // <- Usado para criar encadeamento
    }

    public DocumentBuilder subtitulo(String texto){
        return this;
    }

    public DocumentBuilder paragrafo(String texto){
        return this;
    }

    public void criar(String nomeArquivo){
        // Salva o documento
    }

}

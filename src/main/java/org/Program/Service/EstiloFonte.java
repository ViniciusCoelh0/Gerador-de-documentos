package org.Program.Service;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;

// Possivel criar um BUIDER aqui também gerando encurtamento

public class EstiloFonte {
        private String texto;
        private String fonte;
        private int tamanho;
        private boolean negrito;
        private boolean italico;
        private ParagraphAlignment alinhamento;

    public EstiloFonte(int tamanhoTitulo, String arial, boolean b, boolean negrito, ParagraphAlignment alinhamento) {
        this.tamanho = tamanho;
        this.fonte = fonte;
        this.negrito = negrito;
        this.italico = italico;
        this.alinhamento = alinhamento;

    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getFonte() {
        return fonte;
    }

    public void setFonte(String fonte) {
        this.fonte = fonte;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public boolean isNegrito() {
        return negrito;
    }

    public void setNegrito(boolean negrito) {
        this.negrito = negrito;
    }

    public boolean isItalico() {
        return italico;
    }

    public void setItalico(boolean italico) {
        this.italico = italico;
    }

    public ParagraphAlignment getAlinhamento() {
        return alinhamento;
    }

    public void setAlinhamento(ParagraphAlignment alinhamento) {
        this.alinhamento = alinhamento;
    }
}

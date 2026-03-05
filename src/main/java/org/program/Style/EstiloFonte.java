package org.program.Style;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;

public final class EstiloFonte {
        private String fonte;
        private int tamanho;
        private boolean negrito;
        private boolean italico;
        private ParagraphAlignment alinhamento;

    private EstiloFonte(Builder builder) {
        this.fonte = builder.fonte;
        this.tamanho = builder.tamanho;
        this.negrito = builder.negrito;
        this.italico = builder.italico;
        this.alinhamento = builder.alinhamento;
    }

    public static class Builder{
        private String fonte = "Arial";
        private int tamanho = 12;
        private boolean negrito = false;
        private boolean italico = false;
        private ParagraphAlignment alinhamento = ParagraphAlignment.LEFT;


        public Builder fonte(String fonte){
            this.fonte = fonte;
            return this;
        }

        public Builder tamanho(int tamanho){
            if(tamanho <= 0){
                throw new IllegalArgumentException("Tamanho deve ser positivo");
            }
            this.tamanho = tamanho;
            return this;
        }

        public Builder negrito(boolean negrito){
            this.negrito = negrito;
            return this;
        }

        public Builder italico(boolean italico){
            this.italico = italico;
            return this;
        }

        public Builder alinhamento(ParagraphAlignment alinhamento){
            this.alinhamento = alinhamento;
            return this;
        }

        public EstiloFonte build(){
            return new EstiloFonte(this);
        }
    }

    public String getFonte() {
        return fonte;
    }

    public int getTamanho() {
        return tamanho;
    }

    public boolean isNegrito() {
        return negrito;
    }

    public boolean isItalico() {
        return italico;
    }

    public ParagraphAlignment getAlinhamento() {
        return alinhamento;
    }
}

package org.program.Builder;

import org.program.Document.ElementoDocumento;
import org.program.Document.ListaElemento;
import org.program.Document.ParagrafoElemento;
import org.program.Document.QubraLinhaElemnto;
import org.program.Style.EstiloFonte;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import javax.print.Doc;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DocumentBuilder {

    private final List<ElementoDocumento> elementos = new ArrayList<>();

    //Titulo
    public DocumentBuilder titulo(String texto){
        EstiloFonte estilo = new EstiloFonte.Builder()
                .tamanho(22)
                .negrito(true)
                .build();

        return titulo(texto, estilo);
    }

    //Overload
    public DocumentBuilder titulo(String texto, EstiloFonte estilo){
        elementos.add(new ParagrafoElemento(texto, estilo));
        return this;
    }

    //-------------

    //Paragrafos
    public DocumentBuilder paragrafo(String texto){
        EstiloFonte estilo = new EstiloFonte.Builder()
                .tamanho(12)
                .build();

        return paragrafo(texto, estilo);
    }

    //Overload
    public DocumentBuilder paragrafo(String texto, EstiloFonte estilo){
        elementos.add(new ParagrafoElemento(texto, estilo));
        return this;
    }

    //-------------

    //Subtitulo
    public DocumentBuilder subtitulo(String texto){
        EstiloFonte estilo = new EstiloFonte.Builder()
                .tamanho(16)
                .negrito(true)
                .build();

        return subtitulo(texto, estilo);
    }

    //Overload
    public DocumentBuilder subtitulo(String texto, EstiloFonte estilo){
        elementos.add(new ParagrafoElemento(texto, estilo));
        return this;
    }

    //-------------

    //Quebra de linha
    public DocumentBuilder quebraLinha(String texto){
        elementos.add(new QubraLinhaElemnto());
        return this;
    }

    //Lista
    public DocumentBuilder lista(List<String> itens){
        EstiloFonte estilo = new EstiloFonte.Builder()
                .tamanho(12)
                .build();

        return lista(itens, estilo);
    }

    public DocumentBuilder lista(List<String> itens, EstiloFonte estilo){
        elementos.add(new ListaElemento(itens, estilo));
        return this;
    }

    //-------------

    public void criar(String nomeArquivo){
        try (XWPFDocument documento = new XWPFDocument();
        FileOutputStream out = new FileOutputStream(nomeArquivo + ".docx")){

            for (ElementoDocumento elemento : elementos){
                elemento.aplicar(documento);
            }
            documento.write(out);

        } catch (IOException e) {
            throw new RuntimeException("Erro ao gerar documento", e);
        }
    }

}

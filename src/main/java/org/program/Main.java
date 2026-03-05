package org.program;

import org.program.Builder.DocumentBuilder;
import org.program.Style.EstiloFonte;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        DocumentBuilder db = new DocumentBuilder();

        EstiloFonte titulo = new EstiloFonte.Builder()
                .fonte("Roboto")
                .tamanho(28)
                .negrito(true)
                .alinhamento(ParagraphAlignment.CENTER)
                .build();

        EstiloFonte subtitulo = new EstiloFonte.Builder()
                .fonte("Arial")
                .tamanho(18)
                .negrito(true)
                .italico(true)
                .build();

        EstiloFonte estilo1 = new EstiloFonte.Builder()
                .fonte("Courier New")
                .tamanho(16)
                .italico(true)
                .build();

        EstiloFonte estilo2 = new EstiloFonte.Builder()
                .fonte("Courier New")
                .tamanho(16)
                .build();

       db.titulo("Documento de Teste", titulo)
                .subtitulo("Subtitulo")
                .paragrafo("Parágrafo estilizado", estilo1)
               .paragrafo("Parágrafo estilizado", estilo2)
                .criar("teste.docx");


    }
}
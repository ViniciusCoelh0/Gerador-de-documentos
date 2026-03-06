package org.program;

import org.program.Builder.DocumentBuilder;
import org.program.Style.EstiloFonte;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;

import java.io.IOException;
import java.nio.file.Path;
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

        Path caminho = Path.of("C:/DEV/JAVA/eclipse/LPP/FormatadorDeTexto/Arquivos/"); //<-- Se quiser criar ele em uma pasta especifica, colocar o caminho aqui

        System.out.println();

       db.titulo("Documento de Teste", titulo)
                .subtitulo("Subtitulo")
                .paragrafo("Parágrafo estilizado", estilo1)
               .paragrafo("Parágrafo estilizado", estilo2)
                .criar(caminho.toString() + "arquivo");

        System.out.println("Documento gerado com sucesso!");
    }
}
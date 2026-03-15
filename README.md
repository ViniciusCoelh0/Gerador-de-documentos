# Document Formatter

A small Java project to generate and format **.docx documents programmatically** using the **Apache POI** library.

The goal of this project is to practice **Object-Oriented Programming (OOP)**, **software architecture**, and **design patterns** while building a useful utility for document generation.

---

## Features

- Generate `.docx` documents programmatically
- Apply different **text styles**
- Create:
  - Titles
  - Subtitles
  - Paragraphs
- Fluent **Builder API** for easy document creation
- Customizable **font styles**

---

## Technologies

- **Java**
- **Apache POI**
- **Maven**

---

## Installation

Clone the repository:

```bash
https://github.com/ViniciusCoelh0/Gerador-de-documentos.git

```
---
## Example Usage

```
// TITLE
EstiloFonte titulo = new EstiloFonte.Builder()
                .fonte("Roboto")
                .tamanho(28)
                .negrito(true)
                .alinhamento(ParagraphAlignment.CENTER)
                .build();

// SUBTITLE
        EstiloFonte subtitulo = new EstiloFonte.Builder()
                .fonte("Arial")
                .tamanho(18)
                .negrito(true)
                .italico(true)
                .build();


// Paragraph
        EstiloFonte estilo1 = new EstiloFonte.Builder()
                .fonte("Courier New")
                .tamanho(16)
                .italico(true)
                .build();

        EstiloFonte estilo2 = new EstiloFonte.Builder()
                .fonte("Courier New")
                .tamanho(16)
                .build();

// Printing
       db.titulo("Documento de Teste", titulo)
                .subtitulo("Subtitulo")
                .paragrafo("Parágrafo estilizado", estilo1)
                .paragrafo("Parágrafo estilizado", estilo2)
                .criar("exemple.docx");

// List
       db.titulo("Documento de Teste")
                .paragrafo("Exemplo de lista:")
                .lista(itens)
                .criar("teste.docx");


```

---

## Author

**Vinicius Dantas**

**Computer Engineering Student**

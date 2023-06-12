package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class PrincipalLlista {
    public static void main(String[] args) throws IOException {
        ArrayList<ArticlesCompra> llistaCompra = reader();
        generateXML(llistaCompra);
    }

    private static ArrayList<ArticlesCompra> reader() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<ArticlesCompra> llistaCompra = new ArrayList<>();

        String descripcio = reader.readLine();
        double quantitat = Double.parseDouble(reader.readLine());
        String unitat = reader.readLine();
        String seccio = reader.readLine();

        ArticlesCompra article = new ArticlesCompra(descripcio, quantitat, unitat, seccio);
        llistaCompra.add(article);

        return llistaCompra;
    }

    private static void generateXML(ArrayList<ArticlesCompra> llistaCompra) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.newDocument();
            Element rootElement = doc.createElement("llistacompra");
            doc.appendChild(rootElement);

            for (ArticlesCompra article : llistaCompra) {
                Element articleElement = doc.createElement("article");
                rootElement.appendChild(articleElement);

                Element descripcioElement = doc.createElement("descripcio");
                descripcioElement.appendChild(doc.createTextNode(article.getDescripcio()));
                articleElement.appendChild(descripcioElement);

                Element quantitatElement = doc.createElement("quantitat");
                quantitatElement.appendChild(doc.createTextNode(Double.toString(article.getQuantitat())));
                articleElement.appendChild(quantitatElement);

                Element unitatElement = doc.createElement("unitat");
                unitatElement.appendChild(doc.createTextNode(article.getUnitat()));
                articleElement.appendChild(unitatElement);

                Element seccioElement = doc.createElement("seccio");
                seccioElement.appendChild(doc.createTextNode(article.getSeccio()));
                articleElement.appendChild(seccioElement);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("llista_compra.xml"));

            transformer.transform(source, result);
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
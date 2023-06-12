package org.example;

public class ArticlesCompra {
    private String Descripcio;
    private double Quantitat;
    private String Unitat;
    private String Seccio;

    public ArticlesCompra() {
    }

    public ArticlesCompra(String descripcio, double quantitat, String unitat, String seccio) {
        Descripcio = descripcio;
        Quantitat = quantitat;
        Unitat = unitat;
        Seccio = seccio;
    }

    public String getDescripcio() {
        return Descripcio;
    }

    public void setDescripcio(String descripcio) {
        Descripcio = descripcio;
    }

    public double getQuantitat() {
        return Quantitat;
    }

    public void setQuantitat(double quantitat) {
        Quantitat = quantitat;
    }

    public String getUnitat() {
        return Unitat;
    }

    public void setUnitat(String unitat) {
        Unitat = unitat;
    }

    public String getSeccio() {
        return Seccio;
    }

    public void setSeccio(String seccio) {
        Seccio = seccio;
    }
}

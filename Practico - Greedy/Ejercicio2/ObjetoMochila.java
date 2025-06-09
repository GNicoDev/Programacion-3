package Ejercicio2;

public class ObjetoMochila {
    private double peso;
    private double valor;

    public ObjetoMochila(double peso, double valor) {
        this.peso = peso;
        this.valor = valor;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getPromValorPeso(){
        return this.valor/this.peso;
    }
}

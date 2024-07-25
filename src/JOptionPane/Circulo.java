package JOptionPane;

public class Circulo implements Figura{
    private float raio;
    private float area;
    private float perimetro;

    public void calcularArea() {
        area = (float) ((raio * raio) * 3.14);
    }

    public void calcularPerimetro() {
        perimetro = (float) (2 * 3.14 * raio);
    }

    public Circulo(float raio) {
        this.raio = raio;
    }

    public float getRaio() {
        return raio;
    }
    public void setRaio(float raio) {
        this.raio = raio;
    }

    public float getPerimetro() {
        return perimetro;
    }
    public void setPerimetro(float perimetro) {
        this.perimetro = perimetro;
    }

    public float getArea() {
        return area;
    }
    public void setArea(float area) {
        this.area = area;
    }
}
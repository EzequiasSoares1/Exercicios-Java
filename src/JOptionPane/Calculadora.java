package JOptionPane;

import javax.swing.*;

public class Calculadora {
    public static void main(String[] args) {
        do {
            String opcao = capturarTeclado("Deseja calcular: \n 1 - circulo \n 2 - retangulo \n 3 - Sair");

            if (opcao.equals("1")) {
                calcularCirculo();
            }else if(opcao.equals("2")){
                calcularRetangulo();
            }else if(opcao.equals("3")){
                break;
            }else{
                imprimirMensagem("valor invalido");
            }

        } while (true);

    }
    public static void calcularCirculo(){
       String raio = capturarTeclado("Qual o valor do raio do circulo:");

       if (!eNumerico(raio)) {
           imprimirMensagem("valor invalido");
       }else{
           Circulo circulo = new Circulo(Float.parseFloat(raio));
           circulo.calcularPerimetro();
           circulo.calcularArea();
           imprimirMensagem("Area: "+circulo.getArea()+"\n Perimetro: " +circulo.getPerimetro());
       }


    }
    public static void calcularRetangulo(){
        String lado1 = capturarTeclado("Qual o tamanho do lado 1 do retangulo:");
        String lado2 = capturarTeclado("Qual o tamanho do lado 1 do retangulo:");

        if (!eNumerico(lado1) && !eNumerico(lado2)) {
            imprimirMensagem("valor invalido");
        }else{
            Retangulo retangulo = new Retangulo(Float.parseFloat(lado1), Float.parseFloat(lado2));
            retangulo.calcularPerimetro();
            retangulo.calcularArea();
            imprimirMensagem("Area: "+retangulo.getArea()+"\n Perimetro: " +retangulo.getPerimetro());
        }
    }
    public static boolean eNumerico(String str) {
        return str.matches("[0-9]*");
    }

    public static void imprimirMensagem(String mensagem){
        JOptionPane.showMessageDialog(null, mensagem);
    }
    public static String capturarTeclado(String texto){
        return JOptionPane.showInputDialog(texto);
    }
}

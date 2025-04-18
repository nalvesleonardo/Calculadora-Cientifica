package Model;

public class calcModel {

    public static double soma(double valor1, double valor2) {
        return valor1 + valor2;
    }

    public static double subtracao(double valor1, double valor2) {
        return valor1 - valor2;
    }

    public static double multiplicacao(double valor1, double valor2) {
        return valor1 * valor2;
    }

    public static double divisao(double valor1, double valor2) {
        if (valor2 == 0) {
            throw new ArithmeticException("Divisão por zero não é permitida.");
        }
        return valor1 / valor2;
    }

    public static double quadrado(double valor1) {
        return Math.pow(valor1, 2);
    }

    public static double cubo(double valor1) {
        return Math.pow(valor1, 3);
    }

    public static double raiz(double valor1) {
        if (valor1 < 0) {
            throw new ArithmeticException("Raiz de número negativo não é permitida.");
        }
        return Math.sqrt(valor1);
    }

    public static double fatorial(int valor1) {
        if (valor1 < 0) {
            throw new ArithmeticException("Fatorial de número negativo não é permitido.");
        }
        double resultado = 1;
        for (int i = 1; i <= valor1; i++) {
            resultado *= i;
        }
        return resultado;
    }

    public static double porcentagem(double valor1, double valor2) {
        return (valor1 * valor2) / 100;
    }

    public static double seno(double valor1) {
        return Math.sin(valor1);
    }

    public static double cossseno(double valor1) {
        return Math.cos(valor1);
    }

    public static double tangente(double valor1) {
        return Math.tan(valor1);
    }

    public static double inverso(double valor1) {
        return Math.pow(valor1, -1);
    }

    public static double log(double valor1) {
        return Math.log(valor1);
    }

    public static double exp(double valor1, double valor2) {
        return valor1 * (Math.pow(10, valor2));
    }

    public static double secante(double valor1){
        return Math.pow((Math.cos(valor1)), -1);
    }
}
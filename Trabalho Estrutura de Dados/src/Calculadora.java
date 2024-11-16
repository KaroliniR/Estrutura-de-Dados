import java.util.Scanner;

public class Calculadora {
    private PilhaGenerica<Double> pilhaValores;
    private PilhaGenerica<Character> pilhaOperadores;

    public Calculadora() {
        pilhaValores = new PilhaGenerica<>();
        pilhaOperadores = new PilhaGenerica<>();
    }

    public void empilharValor(double valor) {
        pilhaValores.empilhar(valor);
    }

    public void empilharOperador(char operador) {
        pilhaOperadores.empilhar(operador);
    }

    public void realizarCalculo() {
        if (pilhaValores.estaVazia()) {
            System.out.println("Cálculo não possível: faltam valores.");
            return;
        }
        if (pilhaValores.estaVazia() || pilhaOperadores.estaVazia()) {
            System.out.println("Cálculo não possível: " +
                    (pilhaValores.estaVazia() ? "faltam valores." : "faltam operadores."));
            return;
        }

        double valor2 = pilhaValores.desempilhar();
        double valor1 = pilhaValores.desempilhar();
        char operador = pilhaOperadores.desempilhar();
        double resultado;

        switch (operador) {
            case '+':
                resultado = valor1 + valor2;
                break;
            case '-':
                resultado = valor1 - valor2;
                break;
            case '*':
                resultado = valor1 * valor2;
                break;
            case '/':
                if (valor2 == 0) {
                    System.out.println("Cálculo não possível: divisão por zero.");
                    pilhaValores.empilhar(valor1);
                    pilhaValores.empilhar(valor2);
                    pilhaOperadores.empilhar(operador);
                    return;
                }
                resultado = valor1 / valor2;
                break;
            default:
                System.out.println("Operador inválido.");
                return;
        }
        pilhaValores.empilhar(resultado);
    }

    public void imprimirPilhas() {
        System.out.println("Pilha de Valores:");
        pilhaValores.imprimir();
        System.out.println("Pilha de Operadores:");
        pilhaOperadores.imprimir();
    }
}

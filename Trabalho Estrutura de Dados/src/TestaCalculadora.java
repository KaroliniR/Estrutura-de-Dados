import java.util.Scanner;

public class TestaCalculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculadora calculadora = new Calculadora();
        int opcao;

        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Empilhar valor");
            System.out.println("2. Empilhar operador");
            System.out.println("3. Realizar cálculo");
            System.out.println("4. Imprimir pilhas");
            System.out.println("0. Sair");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor real: ");
                    double valor = scanner.nextDouble();
                    calculadora.empilharValor(valor);
                    break;
                case 2:
                    System.out.print("Digite o operador (+, -, *, /): ");
                    char operador = scanner.next().charAt(0);
                    if ("+-*/".indexOf(operador) != -1) {
                        calculadora.empilharOperador(operador);
                    } else {
                        System.out.println("Operador inválido.");
                    }
                    break;
                case 3:
                    calculadora.realizarCalculo();
                    break;
                case 4:
                    calculadora.imprimirPilhas();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}

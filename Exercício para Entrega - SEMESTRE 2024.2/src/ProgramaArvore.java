import java.util.LinkedList;
import java.util.Scanner;

public class ProgramaArvore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();

        System.out.println("Digite valores para inserir na árvore binária de busca (0 para parar):");
        while (true) {
            int valor = scanner.nextInt();
            if (valor == 0) break;
            arvore.insere(valor);
        }

        System.out.println("Escolha uma opção:");
        System.out.println("1 - Inverter subárvores.");
        System.out.println("2 - Verificar se outra árvore é igual.");
        System.out.println("3 - Armazenar elementos em lista ordenada.");
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                if (arvore.raiz != null) {
                    arvore.raiz.inverte();
                    System.out.println("Subárvores invertidas!");
                } else {
                    System.out.println("Árvore vazia!");
                }
                break;
            case 2:
                ArvoreBinariaBusca outraArvore = new ArvoreBinariaBusca();
                System.out.println("Digite valores para a outra árvore (0 para parar):");
                while (true) {
                    int valor = scanner.nextInt();
                    if (valor == 0) break;
                    outraArvore.insere(valor);
                }
                boolean iguais = arvore.raiz != null && arvore.raiz.iguais(outraArvore.raiz);
                System.out.println("As árvores são " + (iguais ? "iguais" : "diferentes") + "!");
                break;
            case 3:
                LinkedList<Integer> listaOrdenada = arvore.paraListaOrdenada();
                System.out.println("Elementos na lista ordenada: " + listaOrdenada);
                break;
            default:
                System.out.println("Opção inválida!");
        }

        scanner.close();
    }
}

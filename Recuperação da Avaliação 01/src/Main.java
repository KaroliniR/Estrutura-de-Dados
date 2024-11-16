public class Main {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();

        lista.insereOrdenado(10);
        lista.insereOrdenado(6);
        lista.insereOrdenado(23);
        lista.insereOrdenado(10); // Duplicado
        lista.insereOrdenado(16);

        System.out.println("Lista original:");
        lista.imprimeLista(); // Saída = 6 10 16 23

        ListaDuplamenteEncadeada listaPares = lista.retornaListaPares();

        System.out.println("Lista com pares:");
        listaPares.imprimeLista(); // Saída: 6 10 16
    }
}

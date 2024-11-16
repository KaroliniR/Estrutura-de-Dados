public class ListaEncadeadaGenerica<T> {
    private class Nodo {
        T valor;
        Nodo proximo;

        Nodo(T valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    private Nodo topo;
    private int tamanho;

    public ListaEncadeadaGenerica() {
        this.topo = null;
        this.tamanho = 0;
    }

    public void empilhar(T valor) {
        Nodo novoNodo = new Nodo(valor);
        novoNodo.proximo = topo;
        topo = novoNodo;
        tamanho++;
    }

    public T desempilhar() {
        if (topo == null) {
            throw new IllegalStateException("Pilha vazia!");
        }
        T valor = topo.valor;
        topo = topo.proximo;
        tamanho--;
        return valor;
    }

    public T verTopo() {
        if (topo == null) {
            throw new IllegalStateException("Pilha vazia!");
        }
        return topo.valor;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public void imprimir() {
        Nodo atual = topo;
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }
}

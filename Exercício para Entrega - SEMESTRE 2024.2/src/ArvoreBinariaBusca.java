import java.util.LinkedList;

class ArvoreBinariaBusca {
    NodoArvore raiz;

    public ArvoreBinariaBusca() {
        this.raiz = null;
    }

    public void insere(int valor) {
        this.raiz = insereRecursivo(this.raiz, valor);
    }

    private NodoArvore insereRecursivo(NodoArvore nodo, int valor) {
        if (nodo == null) {
            return new NodoArvore(valor);
        }
        if (valor < nodo.valor) {
            nodo.esquerda = insereRecursivo(nodo.esquerda, valor);
        } else if (valor > nodo.valor) {
            nodo.direita = insereRecursivo(nodo.direita, valor);
        }
        return nodo;
    }

    public LinkedList<Integer> paraListaOrdenada() {
        LinkedList<Integer> lista = new LinkedList<>();
        percursoSimetrico(this.raiz, lista);
        return lista;
    }

    private void percursoSimetrico(NodoArvore nodo, LinkedList<Integer> lista) {
        if (nodo != null) {
            percursoSimetrico(nodo.esquerda, lista);
            lista.add(nodo.valor);
            percursoSimetrico(nodo.direita, lista);
        }
    }
}

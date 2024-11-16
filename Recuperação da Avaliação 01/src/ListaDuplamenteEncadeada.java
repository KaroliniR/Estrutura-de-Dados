public class ListaDuplamenteEncadeada {
    private class No {
        Integer valor;
        No anterior;
        No proximo;

        No(Integer valor) {
            this.valor = valor;
            this.anterior = null;
            this.proximo = null;
        }
    }

    private No cabeca;
    private No cauda;

    public ListaDuplamenteEncadeada() {
        this.cabeca = null;
        this.cauda = null;
    }

    public boolean insereOrdenado(Integer valor) {
        if (valor == null) {
            return false;
        }

        No novoNo = new No(valor);

        if (cabeca == null) {
            cabeca = cauda = novoNo;
            return true;
        }

        if (valor < cabeca.valor) {
            novoNo.proximo = cabeca;
            cabeca.anterior = novoNo;
            cabeca = novoNo;
            return true;
        }

        No atual = cabeca;
        while (atual != null) {
            if (atual.valor.equals(valor)) {
                return false;
            } else if (valor < atual.valor) {
                novoNo.proximo = atual;
                novoNo.anterior = atual.anterior;
                if (atual.anterior != null) {
                    atual.anterior.proximo = novoNo;
                }
                atual.anterior = novoNo;
                return true;
            }
            atual = atual.proximo;
        }

        cauda.proximo = novoNo;
        novoNo.anterior = cauda;
        cauda = novoNo;
        return true;
    }

    public ListaDuplamenteEncadeada retornaListaPares() {
        ListaDuplamenteEncadeada listaPares = new ListaDuplamenteEncadeada();

        No atual = cabeca;
        while (atual != null) {
            if (atual.valor % 2 == 0) {
                listaPares.insereOrdenado(atual.valor);
            }
            atual = atual.proximo;
        }

        return listaPares;
    }

    // Método para imprimir a lista
    public void imprimeLista() {
        No atual = cabeca;
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }
}

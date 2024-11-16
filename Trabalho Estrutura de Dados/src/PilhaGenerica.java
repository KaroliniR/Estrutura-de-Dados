public class PilhaGenerica<T> {
    private ListaEncadeadaGenerica<T> lista;

    public PilhaGenerica() {
        lista = new ListaEncadeadaGenerica<>();
    }

    public void empilhar(T valor) {
        lista.empilhar(valor);
    }

    public T desempilhar() {
        return lista.desempilhar();
    }

    public T verTopo() {
        return lista.verTopo();
    }

    public boolean estaVazia() {
        return lista.estaVazia();
    }

    public void imprimir() {
        lista.imprimir();
    }
}

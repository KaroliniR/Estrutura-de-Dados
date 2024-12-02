class NodoArvore {
    int valor;
    NodoArvore esquerda, direita;

    public NodoArvore(int valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }

    public void inverte() {
        NodoArvore temp = this.esquerda;
        this.esquerda = this.direita;
        this.direita = temp;

        if (this.esquerda != null) this.esquerda.inverte();
        if (this.direita != null) this.direita.inverte();
    }

    public boolean iguais(NodoArvore outro) {
        if (outro == null) return false;
        if (this.valor != outro.valor) return false;

        boolean esquerdaIgual = (this.esquerda == null && outro.esquerda == null) ||
                (this.esquerda != null && this.esquerda.iguais(outro.esquerda));
        boolean direitaIgual = (this.direita == null && outro.direita == null) ||
                (this.direita != null && this.direita.iguais(outro.direita));

        return esquerdaIgual && direitaIgual;
    }
}

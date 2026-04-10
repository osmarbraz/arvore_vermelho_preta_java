
/** 
 * Classe que representa um nó da árvore vermelho-preto.
 * Cada nó armazena uma chave, referências para filhos e pai,
 * além de um atributo de cor (vermelho ou preto).
 *
 */
public class No {

    /**
     *  Valor chave armazenado no nó.
     */
    private int chave;

    /**
     * Referência para o filho da esquerda.
     */
    private No esquerda;

    /**
     *  Referência para o filho da direita.
     */
    private No direita;

    /**
     * Referência para o nó pai.
     */
    private No pai;

    /**
     * Cor do nó (true = vermelho, false = preto).
     */
    private boolean cor;

    // Constantes para facilitar leitura do código
    public static final boolean VERMELHO = true;
    public static final boolean PRETO = false;

    /**
     * Construtor sem parâmetros. 
     * cria um nó com chave 0.
     */
    public No() {
        this(0);
    }

    /**
     * Construtor com parâmetros.
     * Inicializa o nó com chave e cor vermelha (padrão do Cormen).
     */
    public No(int c) {
        this.chave = c;
        this.esquerda = null;
        this.direita = null;
        this.pai = null;
        this.cor = VERMELHO; // novo nó sempre inicia vermelho
    }

    /**
     * Recuperador da chave.
     *
     * Recupera a chave de um nó.
     *
     * @return O valor da chave.
     */
    public int getChave() {
        return chave;
    }

    /**
     * Modificador da chave.
     *
     * Modifica a chave do nó.
     *
     * @param k Valor a ser atualizado.
     */
    public void setChave(int k) {
        chave = k;
    }

    /**
     * Recuperador do nó da esquerda.
     *
     * Recupera o nó da esquerda.
     *
     * @return O nó da esquerda.
     */
    public No getEsquerda() {
        return esquerda;
    }

    /**
     * Modificador do nó da esquerda.
     *
     * Modifica o atributo esquerda do nó atual.
     *
     * @param esquerda O nó da esquerda.
     */
    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    /**
     * Recuperador do nó da direita.
     *
     * Recupera o nó da direita.
     *
     * @return O nó da direita.
     */
    public No getDireita() {
        return direita;
    }

    /**
     * Modificador do nó da direita.
     *
     * Modifica o atributo direita do nó atual.
     *
     * @param direita O nó da direita.
     */
    public void setDireita(No direita) {
        this.direita = direita;
    }

    /**
     * Recuperador do nó pai.
     *
     * Recupera o nó pai.
     *
     * @return O nó da pai.
     */
    public No getPai() {
        return pai;
    }

    /**
     * Modificador do nó pai.
     *
     * Modifica o atributo pai do nó atual.
     *
     * @param pai O nó pai.
     */
    public void setPai(No pai) {
        this.pai = pai;
    }

    /**
     * Retorna a cor do nó.
     *
     * @return Verdadeiro (Vermelho) ou Falso(Preto) do no.
     */
    public boolean getCor() {
        return cor;
    }

    /**
     * Modificador da cor
     *
     * @param cor Um valor boleando para a cor do nó.
     */
    public void setCor(boolean cor) {
        this.cor = cor;
    }

    /**
     * Retorna o valor em String dos dados do nó.
     *
     * @return Uma string com o valor do dado do nó.
     */
    public String paraString() {
        return "OID: " + this + " / esquerda:" + esquerda + " / chave: " + chave + " / direita: " + direita + " / pai: " + pai + " /Cor:" + cor;
    }
}

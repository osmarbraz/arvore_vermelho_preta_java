
import java.util.LinkedList;
import java.util.Queue;

/**
 * Árvore Vermelho e Preto.
 *
 * A árvore vermelho-preto é uma árvore binária de busca auto-balanceada na qual
 * cada nó possui uma cor, vermelha ou preta, e deve obedecer a um conjunto de
 * propriedades estruturais: a raiz é sempre preta, todas as folhas (nós NIL)
 * são pretas, nós vermelhos não podem ter filhos vermelhos e, para cada nó,
 * todos os caminhos até as folhas descendentes contêm o mesmo número de nós
 * pretos. Essas restrições garantem que a árvore permaneça aproximadamente
 * balanceada, limitando sua altura e assegurando que operações fundamentais
 * como busca, inserção e remoção sejam realizadas com eficiência em tempo
 * logarítmico.
 */
public class ArvoreVermelhoPreto {

    /**
     * Nó de início da árvore.
     */
    private No raiz;

    /**
     * Nó de fim(Nulo) da árvore.
     */
    private No NIL;

    /**
     * Construtor com parâmetro. Cria o nó sentinela NIL (folha) e inicializa a
     * raiz como NIL.
     */
    public ArvoreVermelhoPreto() {
        setNIL(new No(0));
        NIL.setCor(No.PRETO); // NIL sempre preto
        NIL.setEsquerda(NIL);
        NIL.setDireita(NIL);
        NIL.setPai(NIL);
        setRaiz(NIL); // árvore começa vazia
    }

    /**
     * Recuperador de início.
     *
     * @return O nó do início da árvore.
     */
    public No getRaiz() {
        return raiz;
    }

    /**
     * Modificador de raiz.
     *
     * @param raiz Um nó a ser atribuído ao início da árvore.
     */
    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }

    /**
     * Recuperador de NIL.
     *
     * @return O nó do NIL da árvore.
     */
    public No getNIL() {
        return NIL;
    }

    /**
     * Modificador de NIL.
     *
     * @param NIL Um nó a ser atribuído ao NIL da árvore.
     */
    public void setNIL(No NIL) {
        this.NIL = NIL;
    }

    /**
     * Caminhamento em pré-ordem na sub-árvore.
     *
     * @param _raiz Início da sub-árvore.
     */
    private void listarPreOrdem(No _raiz) {
        //Se _raiz não for nulo
        if (_raiz != NIL) {
            //Visita a chave do nó _raiz
            System.out.print(_raiz.getChave() + " ");

            //Percorre o filho da esquerda
            listarCentralOrdem(_raiz.getEsquerda());

            //Percorre o filho da direita
            listarCentralOrdem(_raiz.getDireita());
        }
    }

    /**
     * Caminhamento em pré-ordem na árvore.
     *
     */
    public void listarPreOrdem() {
        this.listarPreOrdem(this.getRaiz());
    }

    /**
     * Caminhamento em central(in)-ordem na sub-árvore.
     *
     * @param _raiz Início da sub-árvore.
     */
    public void listarCentralOrdem(No _raiz) {
        //Se _raiz não for nulo
        if (_raiz != NIL) {
            //Percorre o filho da esquerda
            listarCentralOrdem(_raiz.getEsquerda());

            //Visita a chave do nó _raiz
            System.out.print(_raiz.getChave() + " ");

            //Percorre o filho da direita
            listarCentralOrdem(_raiz.getDireita());
        }

    }

    /**
     * Caminhamento em central(in)-ordem na árvore.
     *
     */
    public void listarCentralOrdem() {
        this.listarCentralOrdem(this.getRaiz());
    }

    /**
     * Caminhamento em pós-ordem na sub-árvore.
     *
     * @param _raiz Início da sub-árvore.
     */
    private void listarPosOrdem(No _raiz) {
        //Se _raiz não for nulo
        if (_raiz != NIL) {
            //Percorre o filho da esquerda
            listarCentralOrdem(_raiz.getEsquerda());

            //Percorre o filho da direita
            listarCentralOrdem(_raiz.getDireita());

            //Visita a chave do nó _raiz
            System.out.print(_raiz.getChave() + " ");
        }
    }

    /**
     * Caminhamento em pós-ordem na árvore.
     *
     */
    public void listarPosOrdem() {
        this.listarPosOrdem(this.getRaiz());
    }

    /**
     * Caminhamento em nível na sub-árvore.
     *
     * @param _raiz Início da sub-árvore.
     */
    private void listarEmNilvel(No _raiz) {
        //Se _raiz não for nulo
        if (_raiz == null) {
            System.out.println("Árvore vazia.");
            return;
        }

        Queue<No> fila = new LinkedList<>();
        fila.add(_raiz);

        while (!fila.isEmpty()) {
            int tamanhoNivel = fila.size();

            // percorre um nível completo
            for (int i = 0; i < tamanhoNivel; i++) {
                No atual = fila.poll();

                // imprime chave + cor
                String cor = atual.getCor() ? "Vermelho" : "Preto";
                System.out.print(atual.getChave() + "(" + cor + ") ");

                if (atual.getEsquerda() != NIL) {
                    fila.add(atual.getEsquerda());
                }

                if (atual.getDireita() != NIL) {
                    fila.add(atual.getDireita());
                }
            }

            // quebra de linha ao final de cada nível
            System.out.println();
        }
    }

    /**
     * Caminhamento em nível na árvore.
     *
     */
    public void listarEmNilvel() {
        this.listarEmNilvel(this.getRaiz());
    }

    /**
     * Caminhamento em nível na sub-árvore.
     *
     * @param _raiz Início da sub-árvore.
     */
    private void listarEmNilvelDetalhado(No _raiz) {
        //Se _raiz não for nulo
        if (_raiz == null) {
            System.out.println("Árvore vazia.");
            return;
        }

        Queue<No> fila = new LinkedList<>();
        fila.add(_raiz);

        while (!fila.isEmpty()) {
            int tamanhoNivel = fila.size();

            // percorre um nível completo
            for (int i = 0; i < tamanhoNivel; i++) {
                No atual = fila.poll();

                // imprime chave + cor
                String cor = atual.getCor() ? "Vermelho" : "Preto";
                System.out.print(atual.paraString());

                if (atual.getEsquerda() != NIL) {
                    fila.add(atual.getEsquerda());
                }

                if (atual.getDireita() != NIL) {
                    fila.add(atual.getDireita());
                }
            }

            // quebra de linha ao final de cada nível
            System.out.println();
        }
    }

    /**
     * Caminhamento em nível na árvore.
     *
     */
    public void listarEmNilvelDetalhado() {
        this.listarEmNilvelDetalhado(this.getRaiz());
    }

    /**
     * Atualiza um dado na árvore.
     *
     * @param antigo Dado a ser removido.
     * @param novo Novo dado a ser inserido.
     * @return
     */
    public boolean atualizar(int antigo, int novo) {
        //Remove o nó antigo
        if (remover(antigo)) {
            //Insere o novo nó
            inserir(novo);
            return true;
        }
        return false;
    }

    /**
     * Rotacionar a esquerda
     *
     * Baseado no método LEFT-ROTATE(T; x) Thomas H. Cormen Página 265. Move o
     * nó x para baixo e seu filho direito (y) sobe. Mantém a propriedade de
     * árvore binária de busca.
     *
     * @param x
     */
    private void rotacionarEsquerda(No x) {
        // y será o novo pai de x
        No y = x.getDireita();
        //transforma a subárvore à esquerda de y na subárvore à direita de x
        x.setDireita(y.getEsquerda());

        if (y.getEsquerda() != NIL) {
            y.getEsquerda().setPai(x);
        }

        //Liga o pai de x a y
        y.setPai(x.getPai());

        // Atualiza ligação com o pai de x
        if (x.getPai() == NIL) {
            raiz = y;
        } else {
            if (x == x.getPai().getEsquerda()) {
                x.getPai().setEsquerda(y);
            } else {
                x.getPai().setDireita(y);
            }
        }
        //Coloca x à esquerda de y
        y.setEsquerda(x);
        x.setPai(y);
    }

    /**
     * Rotacionar a direita
     *
     * Baseado no método RIGHT-ROTATE(T; x) Thomas H. Cormen Página 265. Move o
     * nó y para baixo e seu filho esquerda (x) sobe. Mantém a propriedade de
     * árvore binária de busca.
     *
     * @param x
     */
    private void rotacionarDireita(No y) {
        No x = y.getEsquerda();
        y.setEsquerda(x.getDireita());

        if (x.getDireita() != NIL) {
            x.getDireita().setPai(y);
        }

        x.setPai(y.getPai());

        if (y.getPai() == NIL) {
            raiz = x;
        } else {
            if (y == y.getPai().getDireita()) {
                y.getPai().setDireita(x);
            } else {
                y.getPai().setEsquerda(x);
            }
        }

        x.setDireita(y);
        y.setPai(x);
    }

    /**
     * Correção de inserção
     *
     * Baseado no método RB-INSERT-FIXUP(T; z) Thomas H. Cormen Página 268.
     * Corrige violações das propriedades da árvore vermelho-preto após uma
     * inserção.
     * Casos: 1 - Tio vermelho → recoloração 
     *        2 - Triângulo → rotação 
     *        3 - Linha → rotação + recoloração
     *
     * @param z
     */
    private void correcaoDeInsercao(No z) {
        while (z.getPai().getCor() == No.VERMELHO) {

            // Caso: pai é filho esquerdo
            if (z.getPai() == z.getPai().getPai().getEsquerda()) {
                No y = z.getPai().getPai().getDireita(); // tio

                if (y.getCor() == No.VERMELHO) {
                    // CASO 1: recoloração
                    z.getPai().setCor(No.PRETO);
                    y.setCor(No.PRETO);
                    z.getPai().getPai().setCor(No.VERMELHO);
                    z = z.getPai().getPai();

                } else {
                    if (z == z.getPai().getDireita()) {
                        // CASO 2: rotação esquerda
                        z = z.getPai();
                        rotacionarEsquerda(z);
                    }

                    // CASO 3: rotação direita
                    z.getPai().setCor(No.PRETO);
                    z.getPai().getPai().setCor(No.VERMELHO);
                    rotacionarDireita(z.getPai().getPai());
                }
            // Caso espelhado (lado direito)
            } else {
                No y = z.getPai().getPai().getEsquerda();

                if (y.getCor() == No.VERMELHO) {
                    // CASO 1 (espelhado)
                    z.getPai().setCor(No.PRETO);
                    y.setCor(No.PRETO);
                    z.getPai().getPai().setCor(No.VERMELHO);
                    z = z.getPai().getPai();

                } else {
                    if (z == z.getPai().getEsquerda()) {
                        // CASO 2 (espelhado)
                        z = z.getPai();
                        rotacionarDireita(z);
                    }

                    // CASO 3 (espelhado)
                    z.getPai().setCor(No.PRETO);
                    z.getPai().getPai().setCor(No.VERMELHO);
                    rotacionarEsquerda(z.getPai().getPai());
                }
            }
        }
        // garante que a raiz seja preta
        raiz.setCor(No.PRETO);
    }

    /**
     * Inserção em sub-árvore vermelho e Preto.
     *
     * Baseado no método RB-INSERT(T; z) Thomas H. Cormen Página 268.
     *
     * @param k Chave a ser inserida.
     */
    public void inserir(int key) {

        // novo nó
        No z = new No(key);
        z.setEsquerda(NIL);
        z.setDireita(NIL);
        z.setPai(NIL);
        // pai do nó a ser inserido
        No y = NIL;
        No x = raiz;

        // Busca posição de inserção
        while (x != NIL) {
            y = x;
            if (z.getChave() < x.getChave()) {
                x = x.getEsquerda();
            } else {
                x = x.getDireita();
            }
        }

        z.setPai(y);

        // Insere o nó na árvore
        if (y == NIL) {
            raiz = z;
        } else {
            if (z.getChave() < y.getChave()) {
                y.setEsquerda(z);
            } else {
                y.setDireita(z);
            }
        }

        z.setEsquerda(NIL);
        z.setDireita(NIL);
        // Inicializa como vermelho (regra do Cormen)
        z.setCor(No.VERMELHO);

        // Corrige possíveis violações
        correcaoDeInsercao(z);
    }

    /**
     * Procura um dado na árvore binária.
     *
     * @param _raiz Raiz de uma subárvore.
     * @param dado O valor de um nó a ser procurado na lista.
     * @return Verdadeiro se encontrou o dado na árvore binária.
     */
    public No procurar(No _raiz, int dado) {
        if (_raiz != NIL) {
            //Se dado igual a _raiz então encontrou
            if (dado == _raiz.getChave()) {
                return (_raiz);
            } else {
                //Se o dado é menor que o valor do nó em _raiz
                if (dado < _raiz.getChave()) {
                    //Procura na subárvore da esquerda
                    return (procurar(_raiz.getEsquerda(), dado));
                } else {
                    //Se o dado é maior que o valor do nó em _raiz
                    if (dado > _raiz.getChave()) {
                        //Procura na subárvore da direita
                        return (procurar(_raiz.getDireita(), dado));
                    }
                }
            }
        }
        return null;
    }

    /**
     * Método auxiliar para procurar uma chave na árvore.
     *
     * Não precisa especificar a raiz.
     *
     * @param k Chave a ser procurada na árvore.
     * @return O nó encontrado ou null.
     */
    public No procurar(int k) {
        return this.procurar(this.getRaiz(), k);
    }

    /**
     * Excluir árvore recursivamente apartir de _raiz.
     *
     * @param _raiz Início da árvore a ser excluida.
     * @return Retorna nul para o nó apgado.
     */
    private No apagar(No _raiz) {
        if (_raiz != null) {
            if (_raiz.getEsquerda() != NIL) {
                apagar(_raiz.getEsquerda());
            }
            if (_raiz.getDireita() != NIL) {
                apagar(_raiz.getDireita());
            }
        }
        return NIL;
    }

    /**
     * Apaga a árvore apartir da raiz.
     */
    public void apagar() {
        this.setRaiz(apagar(this.getRaiz()));
    }

    /**
     * Encontra a chave com o valor mínimo na árvore.
     *
     * @param _raiz Início da árvore.
     * @return A chave miníma da árvore.
     */
    private int getValorMinimo(No _raiz) {
        if (_raiz == null) {
            return -1;
        } else {
            if (_raiz.getEsquerda() == NIL) {
                //retona a chave com o valor mínimo de x
                return _raiz.getChave();
            } else {
                //Procura no próximo filho
                return getValorMinimo(_raiz.getEsquerda());
            }
        }
    }

    /**
     * Encontra a chave com o valor mínimo da raiz.
     *
     * @return A chave mínima da árvore.
     */
    public int getValorMinimo() {
        return getValorMinimo(this.getRaiz());
    }

    /**
     * Encontra a chave com o valor máximo na árvore.
     *
     * @param _raiz Início da árvore.
     * @return A chave máxima da árvore.
     */
    private int getValorMaximo(No _raiz) {
        if (_raiz == NIL) {
            return -1;
        } else {
            if (_raiz.getDireita() == NIL) {
                //retona a chave com o valor mínimo de x
                return _raiz.getChave();
            } else {
                //Procura no próximo filho
                return getValorMaximo(_raiz.getDireita());
            }
        }
    }

    /**
     * Encontra a chave com o valor máximo na árvore.
     *
     * @return A chave máxima da árvore.
     */
    public int getValorMaximo() {
        return this.getValorMaximo(this.getRaiz());
    }

    /**
     * Conta os nós de uma árvore binária.
     *
     * @param _raiz
     * @return A quantidade de nós da árvore.
     */
    public int contarNo(No _raiz) {
        int cont = 0;
        //Verifica se a árvore não é nula
        if (_raiz != NIL) {
            cont = cont + contarNo(_raiz.getDireita());
            cont = cont + contarNo(_raiz.getEsquerda());
            cont = cont + 1;
        }
        return cont;
    }

    /**
     * Conta os nós da árvore.
     *
     * @return A quantidade de nós da árvore.
     */
    public int contarNo() {
        return this.contarNo(this.getRaiz());
    }

    /**
     * Retorna uma String com os valores dos nós folhas da árvore binária.
     *
     * @param _raiz Uma raiz de uma subárvore.
     * @return Uma String com os valores dos nós folhas da árvore binária.
     */
    public String encontrarFolhas(No _raiz) {
        String str = "";
        if (_raiz != NIL) {
            str = str + encontrarFolhas(_raiz.getEsquerda());
            if ((_raiz.getEsquerda() == null) && (_raiz.getDireita() == null)) {
                str = str + " " + _raiz.getChave() + " - ";
            }
            str = str + encontrarFolhas(_raiz.getDireita());
        }
        return str;
    }

    /**
     * Retorna uma String com os valores dos nós folhas da raiz árvore binária.
     *
     * @return Uma String com os valores dos nós folhas da árvore binária.
     */
    public String encontrarFolhas() {
        return encontrarFolhas(this.getRaiz());
    }

    /**
     * Encontra a getAltura da árvore binária.
     *
     * @param _raiz Raiz de uma subárvore.
     * @return A getAltura da árvore binária.
     */
    public int getAltura(No _raiz) {
        if (_raiz == NIL) {
            return 0;
        } else {
            int esquerda = getAltura(_raiz.getEsquerda());
            int direita = getAltura(_raiz.getDireita());
            if (esquerda > direita) {
                return 1 + esquerda;
            } else {
                return 1 + direita;
            }
        }
    }

    /**
     * Encontra a getAltura da árvore.
     *
     * @return A getAltura da árvore.
     */
    public int getAltura() {
        return this.getAltura(this.getRaiz());
    }

    /**
     * Exclui um nó corrigindo.
     *
     * Baseado no método RB-DELETE-FIXUP(T, x) Thomas H. Cormen Página 276.
     *
     * @param x
     */
    private void excluirCorrigindo(No x) {

        while (x != raiz && x.getCor() == No.PRETO) {

            if (x == x.getPai().getEsquerda()) {
                No w = x.getPai().getDireita();

                // CASO 1
                if (w.getCor() == No.VERMELHO) {
                    w.setCor(No.PRETO);
                    x.getPai().setCor(No.VERMELHO);
                    rotacionarEsquerda(x.getPai());
                    w = x.getPai().getDireita();
                }

                // CASO 2
                if (w.getEsquerda().getCor() == No.PRETO
                        && w.getDireita().getCor() == No.PRETO) {
                    w.setCor(No.VERMELHO);
                    x = x.getPai();
                } else {

                    // CASO 3
                    if (w.getDireita().getCor() == No.PRETO) {
                        w.getEsquerda().setCor(No.PRETO);
                        w.setCor(No.VERMELHO);
                        rotacionarDireita(w);
                        w = x.getPai().getDireita();
                    }

                    // CASO 4
                    w.setCor(x.getPai().getCor());
                    x.getPai().setCor(No.PRETO);
                    w.getDireita().setCor(No.PRETO);
                    rotacionarEsquerda(x.getPai());
                    x = raiz;
                }

            } else {
                // ESPELHO
                No w = x.getPai().getEsquerda();

                // CASO 1
                if (w.getCor() == No.VERMELHO) {
                    w.setCor(No.PRETO);
                    x.getPai().setCor(No.VERMELHO);
                    rotacionarDireita(x.getPai());
                    w = x.getPai().getEsquerda();
                }

                // CASO 2
                if (w.getDireita().getCor() == No.PRETO
                        && w.getEsquerda().getCor() == No.PRETO) {
                    w.setCor(No.VERMELHO);
                    x = x.getPai();
                } else {

                    // CASO 3
                    if (w.getEsquerda().getCor() == No.PRETO) {
                        w.getDireita().setCor(No.PRETO);
                        w.setCor(No.VERMELHO);
                        rotacionarEsquerda(w);
                        w = x.getPai().getEsquerda();
                    }

                    // CASO 4
                    w.setCor(x.getPai().getCor());
                    x.getPai().setCor(No.PRETO);
                    w.getEsquerda().setCor(No.PRETO);
                    rotacionarDireita(x.getPai());
                    x = raiz;
                }
            }
        }

        x.setCor(No.PRETO);
    }

    /**
     * Método que retorno o menor nó.
     *
     * Baseado no método TREE-MINIMUM(z) Thomas H. Cormen Página 274.
     *
     * @param x
     * @return
     */
    private No getNoMenor(No x) {
        while (x.getEsquerda() != NIL) {
            x = x.getEsquerda();
        }
        return x;
    }

    /**
     * Método transplabtar.
     *
     * Baseado no método RB-TRANSPLAT(T, u, z) Thomas H. Cormen Página 274.
     *
     * @param u
     * @param v
     */
    private void transplante(No u, No v) {
        if (u.getPai() == NIL) {
            raiz = v;
        } else if (u == u.getPai().getEsquerda()) {
            u.getPai().setEsquerda(v);
        } else {
            u.getPai().setDireita(v);
        }

        v.setPai(u.getPai());
    }

    /**
     * Metodo remover.
     *
     * Baseado no método RB-DELETE(T, z) Thomas H. Cormen Página 275.
     *
     * @param z
     */
    private void remover(No z) {
        No y = z;
        boolean corOriginalY = y.getCor();
        No x;

        if (z.getEsquerda() == NIL) {
            x = z.getDireita();
            transplante(z, z.getDireita());

        } else {

            if (z.getDireita() == NIL) {
                x = z.getEsquerda();
                transplante(z, z.getEsquerda());

            } else {
                y = getNoMenor(z.getDireita());
                corOriginalY = y.getCor();
                x = y.getDireita();

                if (y.getPai() == z) {
                    x.setPai(y);
                } else {
                    transplante(y, y.getDireita());
                    y.setDireita(z.getDireita());
                    y.getDireita().setPai(y);
                }

                transplante(z, y);
                y.setEsquerda(z.getEsquerda());
                y.getEsquerda().setPai(y);
                y.setCor(z.getCor());
            }
        }
        if (corOriginalY == No.PRETO) {
            excluirCorrigindo(x);
        }
    }

    /**
     * Remove uma chave da sub-árvore.
     *
     * Utiliza uma rotina recursiva.
     *
     * @param _raiz Raiz da sub-árvore.
     * @param k Chave a ser removida.
     */
    public boolean remover(int k) {
        if (raiz == null) {
            return false;
        }

        No no = procurar(k);

        if (no != NIL) {
            remover(no);
            return true;
        } else {
            return false;
        }
    }

}

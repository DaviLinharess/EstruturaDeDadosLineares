public class ArvoreBinariaPesquisa {
    private No raiz;
    private int tamanho;

    public ArvoreBinariaPesquisa() {
        this.raiz = null;
        this.tamanho = 0;
    }

    public No raiz() {
        return raiz;
    }

    public int tamanho() {
        return tamanho;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public No pai(No no) {
        return no.getPai();
    }

    public No filhoEsquerdo(No no) {
        return no.getEsquerdo();
    }

    public No filhoDireito(No no) {
        return no.getDireito();
    }

    public boolean isRaiz(No no) {
        return no == raiz;
    }

    public boolean isExterno(No no) {
        return no.ehExterno();
    }

    public boolean isInterno(No no) {
        return no.ehInterno();
    }



    public No busca(int chave) {
        return treeSearch(chave, raiz);
    }

    private No treeSearch(int chave, No v) {    // usa a key e a raiz como parametro
        if( v == null) {
            return null;
        }

        if (chave == v.getElemento()) {
            return v;
        }

        if (chave < v.getElemento()) {
            return treeSearch(chave, v.getEsquerdo());
        } else {
            return treeSearch(chave, v.getDireito());
        }
    }

    public void inserir(int chave) {
        if(raiz == null) {
            raiz = new No(chave, null);
            tamanho++;
            return;
        }
        inserirRec(chave,raiz);
    }

    private void inserirRec(int chave, No v) {
        if (chave < v.getElemento()) {
            if(v.getEsquerdo() == null) {
                No novo = new No(chave, v);
                v.setEsquerdo(novo);
                tamanho++;
            } else {
                inserirRec(chave, v.getEsquerdo());
            }
        } else { // chave >= v.getElemento()
            if (v.getDireito() == null) {
                No novo = new No(chave, v);
                v.setDireito(novo);
                tamanho++;
            } else {
                inserirRec(chave, v.getDireito());
            }
        }
    }

    public void remover(int chave) {
        No v = busca(chave);
        if (v != null) {
            removerNo(v);
            tamanho--;
        }
    }

    private void removerNo(No v) {

        if(v.getEsquerdo() == null) {               //se nao tem filho esquerdo
            trocarSubarvore(v, v.getDireito());     // substitui v pelo seu filho direito
        } else if (v.getDireito() == null) {        //se nao tem filho direito
            trocarSubarvore(v, v.getEsquerdo());    // substitui v pelo seu filho esquerdo
        }

        else {                                      //se tiver 2 filhos
            No sucessor = minimo(v.getDireito());   // vai retornar o menor valor maior que "v"

            if (sucessor.getPai() != v) {                           //se sucessor não for filho direto de "v"
                trocarSubarvore(sucessor, sucessor.getDireito());   //
                sucessor.setDireito(v.getDireito());
                sucessor.getDireito().setPai(sucessor);
            }

            trocarSubarvore(v, sucessor);
            sucessor.setEsquerdo(v.getEsquerdo());
            sucessor.getEsquerdo().setPai(sucessor);
        }
    }

    private No minimo (No v) {
        while (v.getEsquerdo() != null) {
            v = v.getEsquerdo();
        }
        return v;
    }

    private void trocarSubarvore(No u, No v) {
        if (u.getPai() == null) {
            raiz = v;
        }
        else if (u == u.getPai().getEsquerdo()) {
            u.getPai().setEsquerdo(v);
        } 
        else {
            u.getPai().setDireito(v);
        }

        if (v != null) {
            v.setPai(u.getPai());
        }
    }
}
package abb;

public class ArvBin {

    public NoABB raiz;

    public NoABB inserir(NoABB atual, NoABB novo)
    {
        if (atual == null)
        {
            return novo;
        }
        else if (novo.RGM < atual.RGM)
        {
            atual.esq = inserir(atual.esq, novo); //recursao
        }
        else
        {
            atual.dir = inserir(atual.dir, novo); //recursao
        }
        return atual;
    }

    public void inserirNo(NoABB novo)
    {
        raiz = inserir(raiz, novo);
    }

    public void exibirIn() {
        if(raiz != null) {
            System.out.println("Exibindo elementos da arvore IN-ORDER:");
            exibirArvoreIn(raiz);
        }
        else
            System.out.println("\nArvore vazia!");
    }
    private void exibirArvoreIn(NoABB atual)
    {

        if (atual != null)
        {
            exibirArvoreIn(atual.esq);
            System.out.print(atual.RGM + ": " + atual.NomeAluno + " ");
            exibirArvoreIn(atual.dir);
        }

    }

    public void exibirPre() {
        if(raiz != null) {
            System.out.println("\nExibindo elementos da arvore PRE-ORDER:");
            exibirArvorePre(raiz);
        }
        /*else
            System.out.println("Arvore vazia!");*/
    }

    private void exibirArvorePre(NoABB atual) {
        if (atual != null) {
            System.out.print(atual.RGM + ": " + atual.NomeAluno + " ");
            exibirArvorePre(atual.esq);
            exibirArvorePre(atual.dir);
        }
    }

    public void exibirPos() {
        if(raiz != null) {
            System.out.println("\nExibindo elementos da arvore POS-ORDEM:");
            exibirArvorePos(raiz);
        }
        /*else
            System.out.println("Arvore vazia!");*/
    }

    private void exibirArvorePos(NoABB atual) {
        if (atual != null) {
            exibirArvorePos(atual.esq);
            exibirArvorePos(atual.dir);
            System.out.print(atual.RGM + ": " + atual.NomeAluno + " ");
        }
    }






    public void excluirNo(int item){
        try{
            NoABB atual = raiz;
            NoABB pai = null, filho = null, temp = null;

            while (atual != null && atual.RGM != item){
                pai = atual;
                if(item<atual.RGM)
                    atual = atual.esq;
                else
                    atual = atual.dir;
            }
            if(atual == null)
                System.out.println("Elemento não localizado!");

            if(pai == null) {
                if (atual.dir == null)
                    raiz = atual.esq;
                else if (atual.esq == null)
                    raiz = atual.dir;
                else {
                    for (temp = atual, filho = atual.esq; filho.dir != null; temp = filho, filho = filho.dir) ;
                    if (filho != atual.esq) {
                        temp.dir = filho.esq;
                        filho.esq = raiz.esq;
                    }
                    filho.dir = raiz.dir;
                    raiz = filho;
                }
            }
            else if (atual.dir==null){
                if(pai.esq==atual)
                    pai.esq=atual.esq;
                else
                    pai.dir=atual.esq;
            }
            else if (atual.esq==null){
                if(pai.esq==atual)
                    pai.esq=atual.dir;
                else
                    pai.dir=atual.dir;
            }
            else {
                for(temp=atual, filho = atual.esq; filho.dir!=null; temp=filho, filho=filho.dir);
                if(filho!= atual.esq){
                    temp.dir=filho.esq;
                    filho.esq=atual.esq;
                }
                filho.dir = atual.dir;
                if(pai.esq==atual)
                    pai.esq=filho;
                else
                    pai.dir=filho;
            }
        } catch (NullPointerException erro){
            //elemento nao encontrado
        }
    }

    public void localizarNo(int item){

        try{
            NoABB atual = raiz;
            NoABB pai = null, filho = null, temp = null;

            while (atual != null && atual.RGM != item){
                pai = atual;
                if(item<atual.RGM)
                    atual = atual.esq;
                else
                    atual = atual.dir;
            }
            if(atual == null)
                System.out.println("Elemento não localizado!");
            else
                System.out.println("Aluno encontrado!\nRGM: "+ item + " Aluno: "+ atual.NomeAluno);
        } catch (NullPointerException erro){
            //elemento nao encontrado
        }


    }


}

package abb;

public class NoABB
{
    int RGM;
    String NomeAluno;
    NoABB esq, dir;

    public NoABB (int RGM, String NomeAluno)
    {
        this.RGM = RGM;
        this.NomeAluno = NomeAluno;
        esq = dir = null;
    }
}

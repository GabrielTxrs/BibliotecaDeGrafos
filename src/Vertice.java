public class Vertice
{
    private String rotulo;
    private int indice;
    private int grau;
    private boolean flag;

    public Vertice(int indice)
    {
        setIndice(indice);
        setRotulo("v"+String.valueOf(indice));
        setGrau(0);
        setFlag(false);
    }
    public Vertice(int indice, String rotulo)
    {
        setIndice(indice);
        setRotulo(rotulo);
        setGrau(0);
        setFlag(false);
    }
    public String getRotulo() {
        return rotulo;
    }

    public void setRotulo(String rotulo) {
        this.rotulo = rotulo;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public int getGrau() {
        return grau;
    }

    public void setGrau(int grau) {
        this.grau = grau;
    }
    public void incrementarGrau() {
        this.grau++;
    }
    public void decrementarGrau() {
        this.grau--;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

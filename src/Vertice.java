import java.util.List;
import java.util.ArrayList;

public class Vertice
{
    private String rotulo;
    private int indice;
    private int grau;
    private boolean flag;
    private List<Vertice> verticesVizinhos;

    public Vertice(int indice)
    {
        setIndice(indice);
        setRotulo("v"+String.valueOf(indice));
        setGrau(0);
        setFlag(false);
        this.verticesVizinhos = new ArrayList<>();
    }
    public Vertice(int indice, String rotulo)
    {
        setIndice(indice);
        setRotulo(rotulo);
        setGrau(0);
        setFlag(false);
        this.verticesVizinhos = new ArrayList<>();
    }
    public List<Vertice> verticesVizinhos(){return verticesVizinhos;}
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

    public boolean addVerticeVizinho(Vertice vertice) {
        return verticesVizinhos.add(vertice);
    }
    public boolean removeVerticeVizinho(Vertice vertice)
    {
        return verticesVizinhos.remove(vertice);
    }
    public Vertice getVerticeVizinho(int i) {
       return verticesVizinhos.get(i);
    }
    public Vertice getVerticeVizinho(String rotulo) {
        int marcador = -1;
        for (int i = 0; i < verticesVizinhos.size(); i++) {

            if(verticesVizinhos.get(i).getRotulo() == rotulo) {
                marcador = i;
            }
        }
        if (marcador == -1) {
            throw new IllegalArgumentException("Rotulo invalido");
        }
        return verticesVizinhos.get(marcador);
    }
}

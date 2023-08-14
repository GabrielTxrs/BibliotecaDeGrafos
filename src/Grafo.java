import java.util.*;

public class Grafo
{
    private int numVertices;
    private List<Vertice> vertices;
    private int numArestas;
    private List<Aresta> arestas;
    private Map<Vertice, List<Vertice>> listaAdj;
    private boolean matriz;
    private int[][] matrizAdj;

    public Grafo(int numVertices, boolean matriz)
    {
        this.numArestas = 0;
        this.numVertices = numVertices;
        this.matriz = matriz;
        if (matriz){
            matrizAdj = new int[numVertices][numVertices];
        }
        else {
            this.listaAdj = new HashMap<>();
        }
        this.arestas = new LinkedList<>();
        this.vertices = new LinkedList<>();
    }
    void adicionarVertice(int indice, String rotulo) {
        listaAdj.put(new Vertice(indice, rotulo), new LinkedList());
    }





}

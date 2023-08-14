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
    public void adicionarVertice(int indice, String rotulo) {
        listaAdj.put(new Vertice(indice, rotulo), new LinkedList());
        vertices.add(new Vertice(indice, rotulo));
    }
    public void removeVertice(int indice, String rotulo){
        Vertice vertice = new Vertice(indice, rotulo);
        listaAdj.values().stream().forEach(e -> e.remove(vertice));
        listaAdj.remove(vertice);
        vertices.remove(vertice);
    }
    public void adicionarAresta(int vertice1, int vertice2) {
        Vertice v1 = new Vertice(vertice1);
        Vertice v2 = new Vertice(vertice2);



    }


    public void imprimirGrafo()
    {
        System.out.println("Numero de vertices: " + numVertices);
        System.out.println("Numero de arestas: " + numArestas + "\n");

        System.out.println("Estrutura de dados: \nLista de Adjacencia\n");

        for (int x = 0; x < numVertices; x++)
        {
            System.out.print("Vertice " + vertices.get(x).getRotulo() + ": ");
            for (Vertice vertice : listaAdj.keySet())
            {
                listaAdj.get(vertice);
            }
            System.out.println();
        }
    }






}

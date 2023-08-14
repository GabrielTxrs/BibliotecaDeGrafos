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
    public void removeVertice(int indice, String rotulo) {
        Vertice v = new Vertice(indice, rotulo);
        listaAdj.values().stream().forEach(e -> e.remove(v));
        listaAdj.remove(v);
        vertices.remove(v);
    }
    public void adicionarAresta(int origem, int destino) {
       Vertice vorigem = vertices.get(origem-1);
       Vertice vdestino = vertices.get(destino-1);
       List<Vertice> v1 = new LinkedList<>();
       List<Vertice> v2 = new LinkedList<>();
       v1.add(vdestino);
       v2.add(vorigem);
       listaAdj.put(vorigem, v1);
       listaAdj.put(vdestino, v2);

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
                System.out.print(listaAdj.values());
            }
            System.out.println();

        }
    }






}

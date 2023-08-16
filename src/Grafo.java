import java.util.*;

public class Grafo
{
    private int numVertices;
    private List<Vertice> vertices;
    private int numArestas;
    private List<Aresta> arestas;
    private List<List<Vertice>> listaAdj;
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
            listaAdj = new LinkedList<>();
            for (int i = 0; i < numVertices; i++)
            {
                listaAdj.add(i,new LinkedList<>());
            }
        }
        arestas = new LinkedList<>();
        vertices = new LinkedList<>();
    }
    public void adicionarVertice(int indice, String rotulo)
    {
        vertices.add(new Vertice(indice, rotulo));
    }
    //JGraphT biblioteca de grafos em java
    public void removerVertice(int indice)
    {
        if(numArestas > 1)
        {
            for (int i = 0; i < numVertices; i++)
            {
                while(listaAdj.get(i).remove(getVertice(indice)));
            }
        }
        vertices.remove(indice-1);
        numVertices--;
    }
    public Vertice getVertice(int i)
    {
        return vertices.get(i-1);
    }
    public void imprimirVertice(int i)
    {
        System.out.println(vertices.get(i-1).getIndice());
        System.out.println(vertices.get(i-1).getRotulo());
    }
    public void adicionarAresta(int origem, int destino)
    {
        if(origem == destino) {
            listaAdj.get(origem-1).add(getVertice(destino));
        }
        else {
            listaAdj.get(origem-1).add(getVertice(destino));
            listaAdj.get(destino-1).add(getVertice(origem));
        }
        arestas.add(new Aresta(getVertice(origem), getVertice(destino)));
        numArestas++;
    }
    public void imprimirGrafo()
    {
        System.out.println("Numero de vertices: " + numVertices);
        System.out.println("Numero de arestas: " + numArestas + "\n");

        System.out.println("Estrutura de dados: \nLista de Adjacencia\n");

        for (int x = 0; x < numVertices; x++)
        {
            System.out.print("Vertice " + vertices.get(x).getRotulo() + ": ");
            System.out.println();
        }
        if(numArestas > 1)
        {
            System.out.println("Arestas");
            for (Aresta aresta: arestas) {
                aresta.getAresta(aresta);
            }
        }


    }






}

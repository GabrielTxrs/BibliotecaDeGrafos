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
    public void adicionarVertice(int indice, String rotulo) {

        vertices.add(new Vertice(indice, rotulo));
    }
    //JGraphT biblioteca de grafos em java
    public void removerVertice(String rotulo) {
        if(numVertices > 1) {
            List<Aresta> arestasremovidas = new LinkedList<>();
            for (int i = 0; i < arestas.size(); i++) {
                if ((arestas.get(i).getVertice1().getRotulo() == rotulo) || (arestas.get(i).getVertice2().getRotulo() == rotulo))
                {
                    arestasremovidas.add(arestas.get(i));
                }
            }
            for (Aresta aresta : arestasremovidas) {
                arestas.remove(aresta);
                numArestas--;
            }
            for (int i = 0; i < numVertices; i++)
            {
                while(listaAdj.get(i).remove(getVertice(rotulo)));
            }
        }
        vertices.remove(getVertice(rotulo));
        numVertices--;
    }
    public Vertice getVertice(int i)
    {
        return vertices.get(i-1);
    }
    public Vertice getVertice(String rotulo)
    {
        int marcador = -1;
        for (int i = 0; i < numVertices ;i++)
        {
            if(vertices.get(i).getRotulo() == rotulo)
            {
                marcador = i;
            }
        }
        return vertices.get(marcador);
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
    public void adicionarAresta(int origem, int destino, String rotulo)
    {
        if(origem == destino) {
            listaAdj.get(origem-1).add(getVertice(destino));
        }
        else {
            listaAdj.get(origem-1).add(getVertice(destino));
            listaAdj.get(destino-1).add(getVertice(origem));
        }
        arestas.add(new Aresta(getVertice(origem), getVertice(destino), rotulo));
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
            for(Vertice vertice: listaAdj.get(x))
            {
                System.out.print(vertice.getRotulo()+" ");
            }

            System.out.println();
        }
        if(numArestas > 1)
        {
            System.out.println("\nArestas: ");
            for (Aresta aresta: arestas) {
                aresta.getAresta(aresta);
            }
        }
        System.out.println();
    }






}

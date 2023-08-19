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
                listaAdj.add(i, new LinkedList<>());
            }
        }
        arestas = new LinkedList<>();
        vertices = new LinkedList<>();
    }
    public void adicionarVertice(int indice, String rotulo) {

        vertices.add(new Vertice(indice, rotulo));
    }

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
            getVertice(origem).addVerticeVizinho(getVertice(destino));
        }
        else {
            listaAdj.get(origem-1).add(getVertice(destino));
            listaAdj.get(destino-1).add(getVertice(origem));
            getVertice(origem).addVerticeVizinho(getVertice(destino));
            getVertice(destino).addVerticeVizinho(getVertice(origem));
        }
        arestas.add(new Aresta(getVertice(origem), getVertice(destino)));
        numArestas++;
    }
    public void adicionarAresta(int origem, int destino, String rotulo)
    {
        if(origem == destino) {
            listaAdj.get(origem-1).add(getVertice(destino));
            getVertice(origem).addVerticeVizinho(getVertice(destino));
        }
        else {
            listaAdj.get(origem-1).add(getVertice(destino));
            listaAdj.get(destino-1).add(getVertice(origem));
            getVertice(origem).addVerticeVizinho(getVertice(destino));
            getVertice(destino).addVerticeVizinho(getVertice(origem));
        }
        arestas.add(new Aresta(getVertice(origem), getVertice(destino), rotulo));
        numArestas++;
    }
    public void removerAresta(int origem, int destino)
    {
        listaAdj.get(origem-1).remove(getVertice(destino));
        listaAdj.get(destino-1).remove(getVertice(origem));

        getVertice(origem).removeVerticeVizinho(getVertice(destino));
        getVertice(destino).removeVerticeVizinho(getVertice(origem));

        int marcador = -1;
        for (int i = 0; i < arestas.size();i++)
        {
            if(arestas.get(i).getVertice1().getIndice() == origem && arestas.get(i).getVertice2().getIndice() == destino)
            {
                marcador = i;
                break;
            }
        }
        arestas.remove(marcador);
        numArestas--;
    }

    public void removerAresta(String rotulo)
    {
        int origem = -1;
        int destino = -1;
        for (Aresta aresta : arestas)
        {
            if (aresta.getRotulo() == rotulo)
            {
                origem  = aresta.getVertice1().getIndice();
                destino = aresta.getVertice2().getIndice();
                arestas.remove(aresta);
                break;
            }
        }
        listaAdj.get(origem-1).remove(getVertice(destino));
        listaAdj.get(destino-1).remove(getVertice(origem));
        if (origem == -1 || destino == -1)
        {
            throw new IllegalArgumentException("Aresta nao existe.");
        }
        numArestas--;
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
        if(numArestas > 0)
        {
            System.out.println("\nArestas: ");
            for (Aresta aresta: arestas) {
                aresta.getAresta(aresta);
            }
        }
        System.out.println();
    }
    public Passeio criarPasseioVertice(List<Vertice> verticesPasseio) {

        int saida = 0;

        for(Vertice verticePasseio : verticesPasseio)
        {
            if(vertices.get(saida).getRotulo() == verticePasseio.getRotulo() || vertices.get(saida).getRotulo() == verticePasseio.getRotulo()) {
                saida++;
            }
        }
        if(saida == verticesPasseio.size()) {
            return new Passeio(verticesPasseio.size(), verticesPasseio);
        }
        else {
            System.out.println("Passeio com Vertices Invalidos");
            return new Passeio();
        }
    }
    public Passeio criarPasseioAresta(List<Aresta> arestasPasseio) {
        int saida = 0;

        for(Aresta arestaPasseio : arestasPasseio)
        {
            if((arestas.get(saida).getVertice1().getRotulo() == arestaPasseio.getVertice1().getRotulo()) || (arestas.get(saida).getVertice1().getRotulo() == arestaPasseio.getVertice2().getRotulo())) {
                saida++;
            }
        }
        if(saida == arestasPasseio.size()) {
            return new Passeio(arestasPasseio, arestasPasseio.size());
        }
        else {
            System.out.println("Passeio com Vertices Invalidos");
            return new Passeio();
        }
    }
}
import java.util.*;

public class Grafo
{
    private int numVertices;
    private List<Vertice> vertices;
    private int numArestas;
    private List<Aresta> arestas;
    private boolean matriz;
    private int[][] matrizAdj;

    public Grafo(int numVertices, boolean matriz)
    {
        this.numArestas = 0;
        this.numVertices = numVertices;
        this.matriz = matriz;
        if (matriz) {
            matrizAdj = new int[numVertices][numVertices];
        }
        arestas = new ArrayList<>();
        vertices = new ArrayList<>();
    }
    public void adicionarVertice(int indice, String rotulo) {

        vertices.add(new Vertice(indice, rotulo));
    }

    public void removerVertice(String rotulo)
    {
        if(numVertices > 1) {

            List<Aresta> arestasremovidas = new ArrayList<>();

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

            for (int i = 0; i < vertices.size(); i++)
            {
                int j = 0;
                while(vertices.get(i).removeVerticeVizinho(getVertice(rotulo)))
                {
                    j++;
                }
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
            getVertice(origem).addVerticeVizinho(getVertice(destino));
        }
        else {
            getVertice(origem).addVerticeVizinho(getVertice(destino));
            getVertice(destino).addVerticeVizinho(getVertice(origem));
        }
        arestas.add(new Aresta(getVertice(origem), getVertice(destino)));
        numArestas++;
    }
    public void adicionarAresta(int origem, int destino, String rotulo)
    {
        if(origem == destino) {
            getVertice(origem).addVerticeVizinho(getVertice(destino));
        }
        else {
            getVertice(origem).addVerticeVizinho(getVertice(destino));
            getVertice(destino).addVerticeVizinho(getVertice(origem));
        }
        arestas.add(new Aresta(getVertice(origem), getVertice(destino), rotulo));
        numArestas++;
    }
    public void removerAresta(int origem, int destino)
    {
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
        if (origem == -1 || destino == -1) {
            throw new IllegalArgumentException("Aresta nao existe.");
        }
        else {
            getVertice(origem).removeVerticeVizinho(getVertice(destino));
            getVertice(destino).removeVerticeVizinho(getVertice(origem));
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
            for(Vertice vertice: vertices.get(x).verticesVizinhos())
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
        // teste para saber se os vertices passados estao contidos no grafo
        if(saida == verticesPasseio.size()) {
            List<Aresta> arestasPasseio = new ArrayList<>();

            for(Vertice vertice : verticesPasseio)
            {
                for (Aresta aresta : arestas)
                {
                    if((aresta.getVertice1().getRotulo() == vertice.getRotulo()) || (aresta.getVertice2().getRotulo() == vertice.getRotulo()))
                    {
                        arestasPasseio.add(aresta);
                    }
                }
            }
            return new Passeio(arestasPasseio, arestasPasseio.size());
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
    public void buscaEmProfundidade(int vertice)
    {
        boolean[] visitados = new boolean[numVertices];

        getVertice(vertice).setFlag(true);
        System.out.print(getVertice(vertice).getRotulo() + " ");

        for(Vertice vertex : getVertice(vertice).verticesVizinhos())
        {
            if(!vertex.getFlag())
            {
                buscaEmProfundidade(vertex.getIndice());
            }
        }
    }
    public Passeio buscaEmProfundidade(int origem, int destino) {
        boolean[] visitados = new boolean[numVertices];
        List<Vertice> passeio = new ArrayList<>();
        Passeio result = new Passeio();

        buscaAuxiliar(origem, destino, visitados, passeio, result);

        return result;
    }

    private void buscaAuxiliar(int verticeAtual, int destino, boolean[] visitados, List<Vertice> passeio, Passeio saida) {

        visitados[verticeAtual - 1] = true; // -1 pois o indice do array e diferente do indice passado no parametro
        passeio.add(getVertice(verticeAtual));

        if (verticeAtual == destino) {
            saida.addAllVerticesPasseio(passeio);
            return;
        }

        for (Vertice verticeVizinho : getVertice(verticeAtual).verticesVizinhos()) {

            if (!visitados[verticeVizinho.getIndice() - 1]) {

                buscaAuxiliar(verticeVizinho.getIndice(), destino, visitados, passeio, saida);
            }
        }

        passeio.remove(passeio.size() - 1);
    }
    public boolean isConexo() {
        // Modifica o flag de todos os vértices
        for (Vertice vertice : vertices) {
            vertice.setFlag(false);
        }

        // Escolhe um vértice inicial
        Vertice verticeInicial = vertices.get(0);

        // Realiza a busca em profundidade (DFS) para marcar vértices alcançáveis
        dfsConexo(verticeInicial);

        // Verifica se todos os vértices foram marcados como alcançáveis
        for (Vertice vertice : vertices) {
            if (!vertice.getFlag()) {
                return false;
            }
        }
        return true;
    }
    private void dfsConexo(Vertice vertice) {
        vertice.setFlag(true);

        for (Vertice vizinho : vertice.verticesVizinhos()) {

            if (!vizinho.getFlag()) {

                dfsConexo(vizinho);
            }
        }
    }

}
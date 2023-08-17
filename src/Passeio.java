import java.util.LinkedList;
import java.util.List;

public class Passeio
{
    private List<Vertice> verticesp;
    private List<Aresta> arestasp;
    private int numeroDeArestas;

    public Passeio(List<Aresta> edges, int numeroDeArestas)
    {
        this.numeroDeArestas = numeroDeArestas;
        this.verticesp = new LinkedList<>();
        this.arestasp = edges;
        for (Aresta edge : edges)
        {
            this.verticesp.add(edge.getVertice1());
            this.verticesp.add(edge.getVertice2());
        }
    }
    public Passeio(int numeroDeArestas, List<Vertice> vertex)
    {
        this.numeroDeArestas = numeroDeArestas;
        this.verticesp = new LinkedList<>();
        this.arestasp = new LinkedList<>();

        for (Vertice vertice : vertex)
        {
            verticesp.add(vertice);
        }

    }
    public void imprimirPasseio()
    {
        for (Aresta aresta : arestasp)
        {
            System.out.print(aresta.getVertice1().getRotulo()+", "+aresta.getRotulo()+", ");
        }
    }

}

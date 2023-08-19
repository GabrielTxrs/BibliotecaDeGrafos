import java.util.LinkedList;
import java.util.List;

public class Passeio
{
    private List<Vertice> verticesp;
    private List<Aresta> arestasp;
    private int numeroDeArestas;

    public Passeio()
    {
        this.verticesp = null;
        this.arestasp = null;
        this.numeroDeArestas = 0;

    }
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
        this.verticesp = vertex;
        this.arestasp = new LinkedList<>();

    }
    public void imprimirPasseio()
    {
        for (int i = 0; i < arestasp.size(); i++)
        {
            System.out.print(arestasp.get(i).getVertice1().getRotulo());
            System.out.print(", ");
            System.out.print(arestasp.get(i).getRotulo());
            if(i != arestasp.size()-1)
            {
                System.out.print(", ");
            }
        }
    }

}

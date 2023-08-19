import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        Grafo grafo1 = new Grafo(5,false);

        grafo1.adicionarVertice(1,"v1");
        grafo1.adicionarVertice(2,"v2");
        grafo1.adicionarVertice(3,"v3");
        grafo1.adicionarVertice(4,"v4");
        grafo1.adicionarVertice(5,"v5");

        grafo1.adicionarAresta(1,2, "a");
        grafo1.adicionarAresta(2,3, "b");
        grafo1.adicionarAresta(3,4, "c");
        grafo1.adicionarAresta(4,5, "d");

        grafo1.imprimirGrafo();

        List<Aresta> passeioAresta = new ArrayList<>();

        passeioAresta.add(new Aresta(grafo1.getVertice(1),grafo1.getVertice(2),"a"));
        passeioAresta.add(new Aresta(grafo1.getVertice(2),grafo1.getVertice(3),"b"));
        passeioAresta.add(new Aresta(grafo1.getVertice(3),grafo1.getVertice(4),"c"));
        passeioAresta.add(new Aresta(grafo1.getVertice(4),grafo1.getVertice(5),"d"));

        Passeio passeio1 = new Passeio(passeioAresta, 4);

        System.out.println("Exercicio 5.2 ");
        grafo1.criarPasseioAresta(passeioAresta).imprimirPasseio();

        System.out.println("\nExercicio 5.3 ");
        grafo1.criarPasseioAresta(passeioAresta).inverterPasseio();

        System.out.println("\nExercicio 5.4 ");
        System.out.println("\ni = 0\nj = 2");
        passeio1.obterSecaoPasseio(0,2).imprimirPasseio();

        System.out.println("\ni = 1\nj = 2");
        passeio1.obterSecaoPasseio(1,2).imprimirPasseio();

        System.out.println("\ni = 2\nj = 3");
        passeio1.obterSecaoPasseio(2,3).imprimirPasseio();


    }
}
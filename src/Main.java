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

        //grafo1.imprimirGrafo();

        grafo1.removerAresta(2,3);

        //grafo1.imprimirGrafo();

        List<Aresta> passeioAresta = new ArrayList<>();

        passeioAresta.add(new Aresta(grafo1.getVertice(1),grafo1.getVertice(2),"a"));
        passeioAresta.add(new Aresta(grafo1.getVertice(2),grafo1.getVertice(3),"b"));
        passeioAresta.add(new Aresta(grafo1.getVertice(3),grafo1.getVertice(4),"c"));
        passeioAresta.add(new Aresta(grafo1.getVertice(4),grafo1.getVertice(5),"d"));

        Passeio passeio1 = new Passeio(passeioAresta, 4);

       // passeio1.obterSecaoPasseio(0,2).imprimirPasseio();

       // passeio1.inverterPasseio();

        //grafo1.criarPasseioAresta(passeioAresta).imprimirPasseio();


        List<Vertice> passeioVertice = new ArrayList<>();

        passeioVertice.add(new Vertice(1, "v1"));
        passeioVertice.add(new Vertice(2, "v2"));
        passeioVertice.add(new Vertice(3, "v3"));
        passeioVertice.add(new Vertice(4, "v4"));
        passeioVertice.add(new Vertice(5, "v5"));

        Passeio passeiov1 = new Passeio(passeioVertice.size(), passeioVertice);

        //passeiov1.imprimirPasseio();

        passeiov1.inverterPasseio();

        //grafo1.criarPasseioVertice(passeioVertice).imprimirPasseio();

        //passeio1.imprimirPasseio();

    }
}
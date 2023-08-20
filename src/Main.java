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

        System.out.println("\nExercicio 5.5 e 5.6, pois nossa funcao sempre gera um caminho\ne todo caminho e um passeio ");

        Grafo grafo2 = new Grafo(5, false);

        grafo2.adicionarVertice(1,"v1");
        grafo2.adicionarVertice(2,"v2");
        grafo2.adicionarVertice(3,"v3");
        grafo2.adicionarVertice(4,"v4");
        grafo2.adicionarVertice(5,"v5");

        grafo2.adicionarAresta(1,2,"a1");

        grafo2.adicionarAresta(2,3,"a2");

        grafo2.adicionarAresta(3,4,"a3");

        grafo2.adicionarAresta(4,5,"a4");

        grafo2.adicionarAresta(5,1,"a5");

        grafo2.adicionarAresta(5,2,"a6");

        grafo2.adicionarAresta(4,2,"a7");

        System.out.println("\nv = 1\nx = 4");
        grafo2.buscaEmProfundidade(1,4).imprimirPasseio();

        System.out.println("\nv = 5\nx = 1");
        grafo2.buscaEmProfundidade(5,1).imprimirPasseio();

        System.out.println("\nExercicio 5.7");

        Grafo grafo3 = new Grafo(3,false);
        grafo3.adicionarVertice(1,"v1");
        grafo3.adicionarVertice(2,"v2");
        grafo3.adicionarVertice(3,"v3");

        grafo3.adicionarAresta(1,2);
        grafo3.adicionarAresta(2,3);
        grafo3.adicionarAresta(3,1);

        System.out.println(grafo3.isCiclic(1,1));
        //

/*
        Grafo grafo4 = new Grafo(3, false);

        grafo4.adicionarVertice(1,"v1");
        grafo4.adicionarVertice(2,"v2");
        grafo4.adicionarVertice(3,"v3");
        grafo4.adicionarVertice(4,"v4");

        grafo4.adicionarAresta(1,2,"a");
        grafo4.adicionarAresta(3,4,"b");

        System.out.println("\nExercicio 5.12 ");
        if(grafo4.isConexo()){
            System.out.println("O grafo 3 e conexo");
        }
        else {
            System.out.println("O grafe 3 nao e conexo");
        }
        if(grafo2.isConexo()){
            System.out.println("O Grafo 2 nao e conexo");
        }
        else {
            System.out.println("O Grado 2 nao e conexo");
        }*/


    }
}
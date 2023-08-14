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

        grafo1.imprimirGrafo();
    }
}
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.HashMap;

class Graph{

    private Map<Integer,List<Integer>> adjLists;
    private boolean directed;
    private int vertices;
    private boolean[] visited;
    private Queue<Integer> queue;

    Graph (int v, boolean directed){
        this.vertices = v;
        this.directed = directed;
        this.visited = new boolean[vertices];
        this.queue = new LinkedList<Integer>();
        this.adjLists = new HashMap<Integer,List<Integer>>();

        //Adding a linked list for each vertex.
        for (int i = 0; i<vertices; i++){
            adjLists.put(i, new LinkedList<Integer>());
        }
    }


    //Depth-first search.
    public void depthFirstSearch(int v){

        visited[v] = true;
        System.out.print(v+" ");

        for (int w : adjLists.get(v)){
            if (!visited[w]){
                depthFirstSearch(w);
            }
        }
    }

    //Breadth-first search.
    public void breadthFirstSearch(int v){

        queue.add(v);

        while(!queue.isEmpty()){
            
            v = queue.remove();

            if(!visited[v]){
                for (int w: adjLists.get(v)){
                    if (!visited[w]){
                        queue.add(w);
                    }
                }
            }
            if(!visited[v]){
                System.out.print(v+" ");
            }
            visited[v] = true;
        }
    }

    //Adding an edge between vertices.
    public void addEdge(int source, int destination){
        adjLists.get(source).add(destination);
        if (!directed){
            adjLists.get(destination).add(source); 
        }
    }


    //Display all edges.
    public void displayEdges(){
        for(int i = 0; i<vertices; i++){
            System.out.println("Vertex "+i+" is connected to vertices: "+adjLists.get(i));
        }
    }

    //Count edges.
    public int countEdges(){
        int totalEdges = 0;
        for(int i = 0; i<vertices; i++){
            totalEdges += adjLists.get(i).size();
        }
        return totalEdges/2;
    }

    //Count vertices.
    public int countVertices(){
        return vertices;
    }


    public static void main(String[] args){

        //New undirected graph with 6 vertices.
        boolean is_directed = false;
        Graph g = new Graph(9, is_directed);

        //Adding edges.
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(0, 8);
        g.addEdge(1, 7);
        g.addEdge(2, 3);
        g.addEdge(2, 5);
        g.addEdge(2, 7);
        g.addEdge(3, 4);
        g.addEdge(5, 6);

        //Displaying edges.
        g.displayEdges();

        //Depth-first search.
        System.out.println("");
        System.out.print("Depth-first search: ");
        g.depthFirstSearch(0);

        //Re-initializing visited.
        g.visited = new boolean[g.vertices];
        System.out.println("");
        System.out.print("Breadth-first search: ");
        g.breadthFirstSearch(0);


    }
    
}
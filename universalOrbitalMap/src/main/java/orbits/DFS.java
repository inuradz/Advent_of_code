package orbits;


import java.util.HashSet;
import java.util.Set;

/**
 * Completes a Depth First Search for finding the shortest path
 */
public class DFS {

    private Set<String> visisted;
    private Graph graph;

    DFS(Graph g, String start){
        visisted = new HashSet<>();
        graph =  g;
        visitNode(start);
    }

    private void visitNode(String node){

    }


}

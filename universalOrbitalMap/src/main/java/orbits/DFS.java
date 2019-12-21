package orbits;


import java.util.*;

/**
 * Completes a Depth First Search for finding the shortest path
 */
public class DFS {

    private Set<String> visisted;
    private Graph graph;
    private Graph spanningTree;
    private String start;

    DFS(Graph g, String start){
        visisted = new HashSet<>();
        graph =  g;
        spanningTree =  new Graph();
        this.start = start;
        visisted.add(start);
        visitNode(start);
        //System.out.println(spanningTree);
    }

    private void visitNode(String node){
        for( Edge e: graph.getOutgoingEdges(node)){
            //Check to see if it has already been visited
            if(!visisted.contains(e.getTo())){
                spanningTree.addEdge(e.getTo(),e.getFrom());
                visisted.add(e.getTo());
                visitNode(e.getTo());
            }
        }
    }

    public List<Edge> getPath(String node){
        List<Edge> path = new ArrayList<>();
        String location = node;
        while(!location.equals(start)){
            Edge reverseLink = spanningTree.getOutgoingEdges(location).get(0);
            path.add(reverseLink.reverseLink());
            location = reverseLink.getTo();
        }
        Collections.reverse(path);
        return path;
    }



}

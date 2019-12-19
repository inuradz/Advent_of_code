package orbits;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class Graph {

    Map<String, List<Edge>> graph;

    Graph(){
        this.graph = new HashMap<>();
    }

    void addEdge(String from, String to){
        Edge e = new Edge(to,from,1);
        graph.computeIfAbsent(from,k -> new LinkedList<>()).add(e);
    }



    public List<Edge> getOutgoingEdges(String node){
        return graph.get(node);
    }

}

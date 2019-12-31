package orbits;

import java.util.List;
import java.util.Scanner;

public class TotalOrbits {

    Graph graph;

    TotalOrbits(Graph g){
        this.graph = g;
    }

    Integer getOrbitsAroundPoint(String node, Integer depth){
        List<Edge> le = graph.getOutgoingEdges(node);
        Integer orbits = depth;
        if(le != null){
            for(Edge e:le){
                orbits += getOrbitsAroundPoint(e.getTo(),depth+1);
            }
        }
        return orbits;
    }

    Integer getOrbits(){
        //COM is the starting point for all orbits
        return getOrbitsAroundPoint("COM",0);
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        Scanner s = new Scanner(System.in);
        String line;
        TotalOrbits p = new TotalOrbits(g);
        while (s.hasNext()){
            line = s.next();
            String[] links = line.split("\\)");
            g.addEdge(links[0],links[1]);
        }
        System.out.println(p.getOrbits());
    }
}

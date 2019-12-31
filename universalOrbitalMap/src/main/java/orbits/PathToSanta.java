package orbits;

import java.util.List;
import java.util.Scanner;

public class PathToSanta {
    Graph graph;

    PathToSanta(Graph g){
        this.graph = g;
    }

    List<Edge> findPathFrom(String start){
        DFS d = new DFS(this.graph,start);
        return d.getPath("SAN");
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        Scanner s = new Scanner(System.in);
        String line;
        while (s.hasNext()){
            line = s.next();
            String[] links = line.split("\\)");
            g.addEdge(links[0],links[1]);
            g.addEdge(links[1],links[0]);
        }
        PathToSanta p = new PathToSanta(g);
        List<Edge> path = p.findPathFrom("YOU");
        System.out.println(path);
        System.out.println(path.size()-2);

    }
}

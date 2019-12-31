package orbits;

public class Edge {

    private String from;
    private String to;
    private Integer length;

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public Integer getLength() {
        return length;
    }

    Edge(String to, String from, Integer length){
        this.to = to;
        this.from = from;
        this.length = length;
    }

    public Edge reverseLink(){
        return new Edge(this.from,this.to,this.length);
    }

    @Override
    public String toString() {
        return String.format("(%s -> %s:%d)",this.from,this.to,this.length);
    }
}

package crossed;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Parser {

    NumberPlane plane;

    Parser(){
        plane = new NumberPlane(100000,100000);
    }

    private int getNumberFromCommand(String command){
        return Integer.parseInt(command.substring(1));
    }

    void addWire(String wire){
        String[] split = wire.split(",");
        int x = 0;
        int y = 0;
        int i;
        int distance = 0;
        for(String command:split){
            switch (command.charAt(0)){
                case 'R':
                    for(i=0;i<getNumberFromCommand(command);i++){
                        x += 1;
                        distance++;
                        plane.set(x,y,distance);
                    }
                    break;
                case 'L':
                    for(i=0;i<getNumberFromCommand(command);i++){
                        x -= 1;
                        distance++;
                        plane.set(x,y,distance);
                    }
                    break;
                case 'U':
                    for(i=0;i<getNumberFromCommand(command);i++){
                        y += 1;
                        distance++;
                        plane.set(x,y,distance);
                    }
                    break;
                case 'D':
                    for(i=0;i<getNumberFromCommand(command);i++){
                        y -= 1;
                        distance++;
                        plane.set(x,y,distance);
                    }
                    break;
            }
        }
    }

    int manhattanDistance(int x, int y){
        return Math.abs(x) + Math.abs(y);
    }

    int checkCrossingManhattan(String wire){
        String[] split = wire.split(",");
        int x = 0;
        int y = 0;
        int shortest = 1999999999;
        int i;
        for(String command:split){
            switch (command.charAt(0)){
                case 'R':
                    for(i=0;i<getNumberFromCommand(command);i++){
                        //Do something
                        x += 1;
                        if(plane.get(x,y) != null && manhattanDistance(x,y) < shortest){
                            shortest = manhattanDistance(x,y);
                        }
                    }
                    break;
                case 'L':
                    for(i=0;i<getNumberFromCommand(command);i++){
                        //Do something
                        x -= 1;
                        if(plane.get(x,y) != null && manhattanDistance(x,y) < shortest){
                            shortest = manhattanDistance(x,y);
                        }
                    }
                    break;
                case 'U':
                    for(i=0;i<getNumberFromCommand(command);i++){
                        //Do something
                        y += 1;
                        if(plane.get(x,y) != null && manhattanDistance(x,y) < shortest){
                            shortest = manhattanDistance(x,y);
                        }
                    }
                    break;
                case 'D':
                    for(i=0;i<getNumberFromCommand(command);i++){
                        //Do something
                        y -= 1;
                        if(plane.get(x,y) != null && manhattanDistance(x,y) < shortest){
                            shortest = manhattanDistance(x,y);
                        }
                    }
                    break;
            }
        }
        return shortest;
    }

    int checkCrossingWireDistance(String wire){
        String[] split = wire.split(",");
        int x = 0;
        int y = 0;
        int shortest = 1999999999;
        int i;
        int distance = 0;
        for(String command:split){
            switch (command.charAt(0)){
                case 'R':
                    for(i=0;i<getNumberFromCommand(command);i++){
                        //Do something
                        x += 1;
                        distance++;
                        if(plane.get(x,y) != null && (distance+plane.get(x,y)) < shortest){
                            shortest = (distance+plane.get(x,y));
                        }
                    }
                    break;
                case 'L':
                    for(i=0;i<getNumberFromCommand(command);i++){
                        //Do something
                        x -= 1;
                        distance++;
                        if(plane.get(x,y) != null && (distance+plane.get(x,y)) < shortest){
                            shortest = (distance+plane.get(x,y));
                        }
                    }
                    break;
                case 'U':
                    for(i=0;i<getNumberFromCommand(command);i++){
                        //Do something
                        y += 1;
                        distance++;
                        if(plane.get(x,y) != null && (distance+plane.get(x,y)) < shortest){
                            shortest = (distance+plane.get(x,y));
                        }
                    }
                    break;
                case 'D':
                    for(i=0;i<getNumberFromCommand(command);i++){
                        //Do something
                        y -= 1;
                        distance++;
                        if(plane.get(x,y) != null && (distance+plane.get(x,y)) < shortest){
                            shortest = (distance+plane.get(x,y));
                        }
                    }
                    break;
            }
        }
        return shortest;
    }

    public int findManhattanCrossingDistanceFromOrigin(String wire1, String wire2){
        addWire(wire1);
        return checkCrossingManhattan(wire2);
    }

    public int findWireDistance(String wire1, String wire2){
        addWire(wire1);
        return checkCrossingWireDistance(wire2);
    }

    public static void main(String[] args) {
        Parser p = new Parser();
        Scanner s = new Scanner(System.in);
        String wire1 = s.next();
        String wire2 = s.next();
        System.out.println(p.findWireDistance(wire1,wire2));
    }
}

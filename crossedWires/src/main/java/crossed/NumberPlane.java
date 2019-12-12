package crossed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberPlane {
    List<Map<Integer,Integer>> numberPlane;
    Integer midpointX;
    Integer midpointY;


    NumberPlane(int maxX, int maxY){
        numberPlane = new ArrayList<Map<Integer,Integer>>(2*maxX+1);
        int i;
        int j;
        for(i=0;i<2*maxX+1;i++){
            Map<Integer,Integer> y = new HashMap<Integer, Integer>();
            numberPlane.add(y);
        }
        midpointX = maxX;
        midpointY = maxY;
    }

    public void set(int x, int y,int element){

        numberPlane.get(midpointX+x).computeIfAbsent(midpointY+y,(k) -> element);
    }

    public Integer get(int x,int y){
        return numberPlane.get(midpointX+x).get(midpointY+y);
    }

}

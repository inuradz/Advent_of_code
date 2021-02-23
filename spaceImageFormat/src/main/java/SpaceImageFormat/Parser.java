package SpaceImageFormat;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Parser {

    SpaceImageFormat s;

    Parser(SpaceImageFormat image){
        s = image;
    }

    Integer findLeastZero(){
        Integer i;
        Integer minLayer = 0;
        Integer minZeroCount = Integer.MAX_VALUE;
        Integer count = 0;
        for(i = 0; i < s.getNumberOfLayers();i++){
            count = 0;
            for(List<Integer> row: s.getLayer(i)){
                for(Integer digit : row){
                    if(digit == 0){
                        count++;
                    }
                }
            }
            if(count < minZeroCount){
                minLayer = i;
                minZeroCount = count;
            }
        }
        return minLayer;
    }

    Integer part1Solution(){
        Integer layerNumber = this.findLeastZero();
        List<List<Integer>> layer = s.getLayer(layerNumber);
        Integer numOfOne = 0;
        Integer numOfTwo = 0;
        for(List<Integer> l : layer){
            for(Integer i : l){
                if(i == 1){
                    numOfOne++;
                } else if(i == 2){
                    numOfTwo++;
                }
            }
        }
        return numOfOne*numOfTwo;
    }

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        List<Integer> digits = new LinkedList<>();
        for(String num : s.next().split("")){
            digits.add(Integer.parseInt(num));
        }
        SpaceImageFormat r = new SpaceImageFormat(6,25,digits);
        Parser p = new Parser(r);
        System.out.println(p.part1Solution());
        File outputfile = new File("saved.png");
        ImageIO.write(r.getImage(), "png", outputfile);
    }
}

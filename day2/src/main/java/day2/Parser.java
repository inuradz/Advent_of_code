package day2;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Parser {

    static int getResult(int noun,int verb, List<Integer> assembly){
        List<Integer> l = new LinkedList<Integer>(assembly);
        l.set(1,noun);
        l.set(2,verb);
        StateMachine s = new StateMachine(l);
        return s.getState().get(0);
    }

    public static void main(String[] args) {
        List<Integer> l = new LinkedList<Integer>();
        Scanner scanner = new Scanner(System.in);
        for(String num : scanner.next().split(",")){
            l.add(Integer.parseInt(num));
        }

        int noun;
        int verb;
        int result;
        for(noun=0;noun<=99;noun++){
            for(verb=0;verb<=99;verb++){
                result = getResult(noun,verb,l);
                if (result == 19690720){
                    System.out.println(100 * noun + verb);
                }
            }
        }
    }
}

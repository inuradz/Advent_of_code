package intcode;

import java.io.ByteArrayInputStream;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class RunMachine {

    public static void main(String[] args) {
        List<Integer> l = new LinkedList<Integer>();
        Scanner scanner = new Scanner(System.in);
        for(String num : scanner.next().split(",")){
            l.add(Integer.parseInt(num));
        }
        ByteArrayInputStream b = new ByteArrayInputStream("1".getBytes());
        IntCodeVM vm = new IntCodeVM(b,System.out,l);
    }
}

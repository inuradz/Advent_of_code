package intcode;

import java.io.ByteArrayInputStream;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
        ByteArrayInputStream in = new ByteArrayInputStream("5".getBytes());
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(b);
        IntCodeVM vm = new IntCodeVM(in,out,l);
        System.out.println(b.toString());
    }
}

package intcode;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

/**
 * A new VM to handle the intcode assembly with other features
 */
public class IntCodeVM {

    InputStream input;
    Scanner in;
    PrintStream out;
    List<Integer> memory;
    Integer instructionPointer;
    Stack<Integer> data_stack;

    IntCodeVM(InputStream input, PrintStream output, Collection<Integer> instructions){
        this.input = input;
        in = new Scanner(input);
        out = output;
        memory = new ArrayList<Integer>(instructions);
        instructionPointer = 0;
        data_stack = new Stack<Integer>();
        this.run();
    }

    List<Integer> getState(){
        return memory;
    }

    void loadNumber(Integer address){
        data_stack.push(memory.get(address));
        instructionPointer++;
    }

    void loadNumberFromAddress(Integer address){
        data_stack.push(memory.get(memory.get(address)));
        instructionPointer++;
    }

    void stackNumber(Character mode){
        if(mode == '0'){
            loadNumberFromAddress(this.instructionPointer);
        } else {
            loadNumber(this.instructionPointer);
        }
    }


    void loadNextIntegersSequence(String instruction,Integer numbers){
        int i;
        for(i = 0;i<numbers;i++){
            stackNumber(instruction.charAt(2-i));
        }
    }

    /***
     *
     * @return Whether or not an endstate has been reached
     */
    boolean interpretInstruction(){
        String instruction = String.format("%05d",memory.get(instructionPointer));
        System.out.println(instruction);
        instructionPointer++;
        switch (instruction.substring(3)){
            case "01":
                //This is an addition operation
                loadNextIntegersSequence(instruction,2);
                loadNumber(this.instructionPointer);
                memory.set(data_stack.pop(),data_stack.pop()+data_stack.pop());
                break;
            case "02":
                //This is a multiplication operation
                loadNextIntegersSequence(instruction,2);
                loadNumber(this.instructionPointer);
                memory.set(data_stack.pop(),data_stack.pop()*data_stack.pop());
                break;
            case "03":
                //Read in an integer
                loadNumber(this.instructionPointer);
                memory.set(data_stack.pop(),in.nextInt());
                break;
            case "04":
                //Outputs an integer
                loadNumber(this.instructionPointer);
                out.print(memory.get(data_stack.pop()));
                break;
            case "99":
                return true;
            default:
                throw new IllegalArgumentException("Unknow argument" + instruction);
        }
        return false;
    }

    public void run(){
        while(!interpretInstruction()){
            //Do nothing, this can be used to show other stuff is need be
        }
    }
}

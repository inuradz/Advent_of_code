package intcode;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.*;
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

    static Logger log = LogManager.getLogger(IntCodeVM.class);

    IntCodeVM(InputStream input, PrintStream output, Collection<Integer> instructions){
        this.input = input;
        in = new Scanner(input);
        out = output;
        memory = new ArrayList<Integer>(instructions);
        instructionPointer = 0;
        data_stack = new Stack<Integer>();
        log.debug("Start Memory state  {}",memoryStateString());
        this.run();
        log.debug("Finish Memory state {}",memoryStateString());
    }

    List<Integer> getState(){
        return memory;
    }

    String memoryStateString(){
        StringBuilder sb = new StringBuilder();
        Boolean start = true;
        sb.append("[");
        Integer counter = 0;
        for(Integer i: memory){
            if(!start){
                sb.append(", ");
            }
            sb.append(String.format("%s:%s",counter,i));
            counter++;
            start = false;
        }
        sb.append("]");
        return sb.toString();
    }

    void loadNumber(Integer address){
        log.info("Loading Direct Value {}",memory.get(address));
        data_stack.push(memory.get(address));
        instructionPointer++;
    }

    void loadNumberFromAddress(Integer address){
        log.info("Loading Value From Memory Address {} which contains {}",memory.get(address),memory.get(memory.get(address)));
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
        instructionPointer++;
        switch (instruction.substring(3)){
            case "01":
                //This is an addition operation
                log.info("Running add instruction | {} | at location {}",instruction,instructionPointer);
                loadNextIntegersSequence(instruction,2);
                loadNumber(this.instructionPointer);
                memory.set(data_stack.pop(),data_stack.pop()+data_stack.pop());
                break;
            case "02":
                //This is a multiplication operation
                log.info("Running multiply instruction | {} | at location {}",instruction,instructionPointer);
                loadNextIntegersSequence(instruction,2);
                loadNumber(this.instructionPointer);
                memory.set(data_stack.pop(),data_stack.pop()*data_stack.pop());
                break;
            case "03":
                //Read in an integer
                log.info("Reading in an integer | {} | at location {}",instruction,instructionPointer);
                loadNumber(this.instructionPointer);
                memory.set(data_stack.pop(),in.nextInt());
                break;
            case "04":
                //Outputs an integer
                log.info("Outputting an integer | {} | at location {}",instruction,instructionPointer);
                loadNextIntegersSequence(instruction,1);
                out.print(data_stack.pop());
                break;
            case "99":
                log.info("STOP instruction | {} | at location {}",instruction,instructionPointer);
                return true;
            default:
                throw new IllegalArgumentException("Unknow argument" + instruction);
        }
        return false;
    }

    public void run(){
        while(!interpretInstruction()){
            //Do nothing, this can be used to show other stuff is need be
            log.debug("Memory state  {}",memoryStateString());
        }
    }
}

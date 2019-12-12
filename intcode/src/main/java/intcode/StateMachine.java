package intcode;
import javax.swing.plaf.nimbus.State;
import java.math.*;
import java.util.*;

/**
 * This is designed to complete day2 challenge
 */

public class StateMachine {

    private List<Integer> state;
    private int instructionPointer;

    StateMachine(List<Integer> start){
        super();
        state = new ArrayList<Integer>(start);
        instructionPointer = 0;
        processState();
    }

    private int getFromLocationPointer(int location){
        return this.state.get(this.state.get(location));
    }

    private  void putIntoPointerLocation(int location,int value){
        this.state.set(this.state.get(location),value);
    }

    private void processState(){
        int result;
        switch (this.state.get(instructionPointer)){
            case 1:
                result = getFromLocationPointer(instructionPointer+1)+getFromLocationPointer(instructionPointer+2);
                putIntoPointerLocation(instructionPointer+3,result);
                instructionPointer += 4;
                processState();
                break;
            case 2:
                result = getFromLocationPointer(instructionPointer+1)*getFromLocationPointer(instructionPointer+2);
                putIntoPointerLocation(instructionPointer+3,result);
                instructionPointer += 4;
                processState();
                break;
            case 99:
                //Done
                break;
            default:
                //This is an error state
                throw new IllegalArgumentException("Unknown character inserted");
        }
    }

    public List<Integer> getState() {
        return state;
    }

    @Override
    public String toString() {
        String s = "";
        Iterator<Integer> it = this.state.iterator();
        while(it.hasNext()){
            Integer i = it.next();
            s += i.toString();
            if(it.hasNext()){
                s += ",";
            }
        }
        return s;
    }
}

package secure;
import java.math.*;
import java.util.*;

public class Passwords {

    public boolean validPasswordPart1(String num){
        int prevNum = 0;
        boolean doubles = false;
        boolean notStart = false;
        int currNum;
        for (char c : num.toCharArray()){
            currNum = c - '0';
            if(currNum < prevNum){
                return false;
            }
            if(currNum == prevNum && notStart){
                doubles = true;
            }
            prevNum = currNum;
            notStart = true;
        }
        return doubles;
    }


    public boolean validPasswordPart2(String num) {
        Deque<Integer> q = new LinkedList<Integer>();
        boolean doubles = false;
        Integer currNum;
        Integer prevNum = null;
        for (char c : num.toCharArray()){
            currNum = c - '0';
            if(prevNum != null) {
                if (currNum < prevNum) {
                    return false;
                }
                //Checks to see if we have seen this number beforehand add adds all the same ones to a queue
                //This queue is then checked when a different value is found to check to see if a double is present
                if(currNum.equals(prevNum)){
                    q.add(currNum);
                } else {
                    //Set to two to check if this was just a double
                    if (Collections.frequency(q, prevNum) == 2) {
                        doubles = true;
                    }
                    q.clear();
                    q.add(currNum);
                }
            } else {
                q.add(currNum);
            }
            prevNum = currNum;
        }

        return (doubles || Collections.frequency(q, prevNum) == 2);
    }
}

package nBody;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MoonEnergy {

    private List<Moon> moons;
    private Pattern moonPattern;
    private Integer steps;

    MoonEnergy(){
        moons =  new LinkedList<>();
        moonPattern = Pattern.compile("<x=(-?\\d+), y=(-?\\d+), z=(-?\\d+)>");
        steps = 0;
    }


    private void addMoon(String moonInitial){
        Matcher match = moonPattern.matcher(moonInitial);
        if(match.find()){
            Moon m = new Moon(Integer.parseInt(match.group(1)),Integer.parseInt(match.group(2)),Integer.parseInt(match.group(3)),0,0,0);
            moons.add(m);
        }
    }

    private void simulateSteps(Integer numberOfSteps){
        int i;
        for(i=0;i<numberOfSteps;i++){
            for(Moon mInner: moons){
                for(Moon mOuter: moons){
                    mInner.applyGravity(mOuter);
                }
            }
            for(Moon m: moons){
                m.updatePosition();
            }
            steps++;
            System.out.println(this);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb =  new StringBuilder();
        sb.append(String.format("After %d steps:\n",steps));
        for(Moon m:moons){
            sb.append(m);
            sb.append("\n");
        }
        return sb.toString();
    }

    public Integer getEnergy(){
        Integer energy = 0;
        for(Moon m:moons){
            energy += m.energy();
        }
        return energy;
    }

    public static void main(String[] args) {
        MoonEnergy me = new MoonEnergy();
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            me.addMoon(s.nextLine());
        }
        System.out.println(me);
        me.simulateSteps(10);
        System.out.println(me.getEnergy());
    }

}

package nBody;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Orbits {

    private List<Moon> moons;
    private List<Moon>  initialMoonState;
    private Pattern moonPattern;
    private Integer steps;

    private Integer periodX = -1;
    private Integer periodY = -1;
    private Integer periodZ = -1;

    Orbits(){
        moons =  new LinkedList<>();
        initialMoonState = new LinkedList<>();
        moonPattern = Pattern.compile("<x=(-?\\d+), y=(-?\\d+), z=(-?\\d+)>");
        steps = 0;
    }


    private void addMoon(String moonInitial){
        Matcher match = moonPattern.matcher(moonInitial);
        if(match.find()){
            Moon m = new Moon(Integer.parseInt(match.group(1)),Integer.parseInt(match.group(2)),Integer.parseInt(match.group(3)),0,0,0);
            moons.add(m);
            m = new Moon(Integer.parseInt(match.group(1)),Integer.parseInt(match.group(2)),Integer.parseInt(match.group(3)),0,0,0);
            initialMoonState.add(m);
        }
    }

    private void nextStep(){
        for(Moon mInner: moons){
            for(Moon mOuter: moons){
                mInner.applyGravity(mOuter);
            }
        }
        for(Moon m: moons){
            m.updatePosition();
        }
        steps++;
    }

    private boolean compareToInitialState(Function<Moon,Integer> fn){
        Iterator<Moon> initialState = initialMoonState.iterator();
        Iterator<Moon> currentState = moons.iterator();
        while (initialState.hasNext()){
            if(fn.apply(initialState.next()) != fn.apply(currentState.next())){
                return false;
            }
        }
        return true;
    }

    public Long getOrbitPeriod(){

        while(periodX == -1 || periodY == -1|| periodZ == -1){
            nextStep();
            if(periodX == -1){
                if(compareToInitialState(Moon::getPosition_x)&&compareToInitialState(Moon::getVelocity_x)){
                    periodX = steps;
                }
            }
            if(periodY == -1){
                if(compareToInitialState(Moon::getPosition_y)&&compareToInitialState(Moon::getVelocity_y)){
                    periodY = steps;
                }
            }
            if(periodZ == -1){
                if(compareToInitialState(Moon::getPosition_z)&&compareToInitialState(Moon::getVelocity_z)){
                    periodZ = steps;
                }
            }
        }
        LCM l =  new LCM();
        return l.getLCM(Long.valueOf(periodX),l.getLCM(Long.valueOf(periodY),Long.valueOf(periodZ)));
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
        Orbits me = new Orbits();
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            me.addMoon(s.nextLine());
        }
        System.out.println(me);
        System.out.println(me.getOrbitPeriod());
    }

}

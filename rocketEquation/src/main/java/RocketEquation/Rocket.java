package RocketEquation;
import java.math.*;
import java.util.Scanner;

public class Rocket {

    private int totalFuel;

    Rocket(){
        super();
        totalFuel = 0;
    }

    public void addModule(int mass){
        totalFuel += Math.floor(mass/3.0) - 2;
    }

    public void addModuleRecurse(int mass){
        if(mass <= 6){
            //Do nothing
        } else {
            int requiredFuel =  (int) (Math.floor(mass/3.0) - 2);
            totalFuel += requiredFuel;
            addModuleRecurse(requiredFuel);
        }
    }

    public int getFuelRequired(){
        return totalFuel;
    }

    public static void main(String[] args) {
        Rocket r = new Rocket();
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            r.addModuleRecurse(scanner.nextInt());
        }
        System.out.println(r.getFuelRequired());
    }
}

package secure;

public class NaiveRunner {

    public static void main(String[] args) {
        Passwords p = new Passwords();
        Integer i;
        int count = 0;
        for(i = 245182; i <= 790572;i++){
            if(p.validPasswordPart2(i.toString())){
                count++;
            }
        }
        System.out.println(count);
    }
}

package nBody;

public class LCM {

    LCM(){

    }

    public Long getLCM(Long a, Long b){
        Long small = new Long(Math.min(a,b));
        Long big = new Long(Math.max(a,b));
        Long LCM;
        for(LCM = big; LCM % small != 0;LCM += big){}
        return LCM;
    }
}

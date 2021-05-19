import java.util.Scanner;

public class Runner {

    public int input () {
        int a = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            a = scanner.nextInt();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }

    public int wayCounter (int boatSp, int rvrSp, int lkTm, int agnstFlwTm) {
        Boat boat = new Boat(boatSp,rvrSp,lkTm,agnstFlwTm);
        return boat.getBoatSpeed()*boat.getLakeTime() + (boat.getBoatSpeed() - boat.getRiverSpeed())*boat.getAgainstFlowTime();
    }
}

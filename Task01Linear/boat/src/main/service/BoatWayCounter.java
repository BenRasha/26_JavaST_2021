import java.util.Scanner;

public class BoatWayCounter {

    /**
     * Is used to get the input from the user.
     * @return int of the user input.
     */

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

    /**
     * Is used to count the whole way of the boat.
     * @param boatSp stores the speed of the boat by itself.
     * @param rvrSp stores the speed of the rivers flow.
     * @param lkTm stores the time, which takes the boat to travel without the flow.
     * @param agnstFlwTm stores the time, which takes the boat to travel against the river flow.
     * @return int value of the whole way of the boat.
     */

    public int wayCounter (int boatSp, int rvrSp, int lkTm, int agnstFlwTm) {
        Boat boat = new Boat(boatSp,rvrSp,lkTm,agnstFlwTm);
        return boat.getBoatSpeed()*boat.getLakeTime() + (boat.getBoatSpeed() - boat.getRiverSpeed())*boat.getAgainstFlowTime();
    }
}

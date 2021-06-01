public class BoatWayCounter {

    /**
     * Is used to count the whole way of the boat.
     * @param params all parameters of the boat in a correct order
     * @return int value of the whole way of the boat.
     */

    public int wayCounter (int []params) {
        Boat boat = new Boat(params[0], params[1], params[2], params[3]);
        return boat.getBoatSpeed()*boat.getLakeTime() + (boat.getBoatSpeed() - boat.getRiverSpeed())*boat.getAgainstFlowTime();
    }
}

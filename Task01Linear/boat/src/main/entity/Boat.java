public class Boat {

    /**
     * This is an entity class of the boat with setters, getters and toString() methods.
     * @param boatSpeed stores the speed of the boat by itself.
     * @param riverSpeed stores the speed of the rivers flow.
     * @param lakeTime stores the time, which took boat to travel without flow.
     * @param againstFlowTime store the time, which took boat to travel against the flow.
     */

    private int boatSpeed;
    private int riverSpeed;
    private int lakeTime;
    private int againstFlowTime;

    public Boat (int boatSpeed, int riverSpeed, int lakeTime, int againstFlowTime) {
        this.boatSpeed = boatSpeed;
        this.riverSpeed = riverSpeed;
        this.lakeTime = lakeTime;
        this.againstFlowTime = againstFlowTime;
    }

    public int getBoatSpeed() {
        return boatSpeed;
    }

    public void setBoatSpeed(int boatSpeed) {
        this.boatSpeed = boatSpeed;
    }

    public int getRiverSpeed() {
        return riverSpeed;
    }

    public void setRiverSpeed(int riverSpeed) {
        this.riverSpeed = riverSpeed;
    }

    public int getLakeTime() {
        return lakeTime;
    }

    public void setLakeTime(int lakeTime) {
        this.lakeTime = lakeTime;
    }

    public int getAgainstFlowTime() {
        return againstFlowTime;
    }

    public void setAgainstFlowTime(int againstFlowTime) {
        this.againstFlowTime = againstFlowTime;
    }

    @Override
    public String toString() {
        return "Boat{" +
                "boatSpeed=" + boatSpeed +
                ", riverSpeed=" + riverSpeed +
                ", lakeTime=" + lakeTime +
                ", againstFlowTime=" + againstFlowTime +
                '}';
    }
}

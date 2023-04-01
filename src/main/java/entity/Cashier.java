package entity;

import services.ICashierService;

public class Cashier extends Staff {
    private Integer strikeCount;
    private boolean fired = false;


    public Cashier(String name, String position, int strikeCount) {
        super(name,position);
        this.strikeCount =strikeCount;
    }

    public Cashier () {
        super();

    }


    public String getName() {
        return super.getName();
    }

    public String getPosition() {
        return super.getPosition();
    }

    public Integer getStrikeCount() {
        return strikeCount;
    }

    public void setStrikeCount(Integer strikeCount) {
        this.strikeCount = strikeCount;
    }

    public boolean isFired() {
        return fired;
    }

    public void setFired(boolean fired) {
        this.fired = fired;
    }

    @Override
    public String
    toString() {
        return "Cashier{" +
                "strikeCount=" + strikeCount +
                ", fired=" + fired +
                "} " + super.toString();
    }
}

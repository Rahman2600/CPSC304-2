//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package ca.ubc.cs304.model;

public class VehicleType {
    private final String vtName;
    private final int wRate;
    private final int dRate;
    private final int hRate;
    private final int wiRate;
    private final int diRate;
    private final int hiRate;
    private final int kRate;

    public VehicleType(int wRate, int dRate, int hRate, int wiRate, int diRate, int hiRate, int kRate, String vtName) {
        this.wRate = wRate;
        this.dRate = dRate;
        this.hRate = hRate;
        this.vtName = vtName;
        this.wiRate = wiRate;
        this.diRate = diRate;
        this.hiRate = hiRate;
        this.kRate = kRate;
    }

    public int getwRate() {
        return this.wRate;
    }

    public int getdRate() {
        return this.dRate;
    }

    public int gethRate() {
        return this.hRate;
    }

    public String getVtName() {
        return this.vtName;
    }

    public int getWiRate() {
        return this.wiRate;
    }

    public int getDiRate() {
        return this.diRate;
    }

    public int getHiRate() {
        return this.hiRate;
    }

    public int getkRate() {
        return this.kRate;
    }
}

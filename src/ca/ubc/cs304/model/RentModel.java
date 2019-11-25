package ca.ubc.cs304.model;

public class RentModel {
    private final int rid;
    private final int vid;
    private final String cellNum;
    private final String fromDate;
    private final String fromTime;
    private final String toDate;
    private final String toTime;
    private final String odometer;
    private final String cardName;
    private final String cardNo;
    private final String expDate;
    private final String confNo;

    public int getRid() {
        return rid;
    }

    public int getVid() {
        return vid;
    }

    public String getCellNum() {
        return cellNum;
    }

    public String getFromDate() {
        return fromDate;
    }

    public String getFromTime() {
        return fromTime;
    }

    public String getToDate() {
        return toDate;
    }

    public String getToTime() {
        return toTime;
    }

    public String getOdometer() {
        return odometer;
    }

    public String getCardName() {
        return cardName;
    }

    public String getCardNo() {
        return cardNo;
    }

    public String getExpDate() {
        return expDate;
    }

    public String getConfNo() {
        return confNo;
    }

    public RentModel(int rid, int vid, String cellNum, String fromDate, String fromTime, String toDate, String toTime, String odometer, String cardName, String cardNo, String expDate, String confNo) {
        this.rid = rid;
        this.vid = vid;
        this.cellNum = cellNum;
        this.fromDate = fromDate;
        this.fromTime = fromTime;
        this.toDate = toDate;
        this.toTime = toTime;
        this.odometer = odometer;
        this.cardName = cardName;
        this.cardNo = cardNo;
        this.expDate = expDate;
        this.confNo = confNo;
    }
}

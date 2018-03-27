import java.io.Serializable;
import java.sql.Timestamp;

public class Massage implements Serializable {

    private long massageId;
    private String senderNo;
    private String receiverNo;
    private Timestamp timeStamp;
    private String textData;
    private byte[] imageData;

    public Massage() {
    }

    public Massage(String senderNo, String receiverNo, String textData, byte[] imageData) {
        this.senderNo = senderNo;
        this.receiverNo = receiverNo;
        this.textData = textData;
        this.imageData = imageData;
    }

    public Massage(long massageId, String senderNo, String receiverNo, Timestamp timeStamp, String textData, byte[] imageData) {
        this.massageId = massageId;
        this.senderNo = senderNo;
        this.receiverNo = receiverNo;
        this.timeStamp = timeStamp;
        this.textData = textData;
        this.imageData = imageData;
    }

    public long getMassageId() {
        return massageId;
    }

    public void setMassageId(long massageId) {
        this.massageId = massageId;
    }

    public String getSenderNo() {
        return senderNo;
    }

    public void setSenderNo(String senderNo) {
        this.senderNo = senderNo;
    }

    public String getReceiverNo() {
        return receiverNo;
    }

    public void setReceiverNo(String receiverNo) {
        this.receiverNo = receiverNo;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getTextData() {
        return textData;
    }

    public void setTextData(String textData) {
        this.textData = textData;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }
}

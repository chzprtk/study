/**
 * @author CHZPRTK
 * @Title: ${ENCLOSING_METHOD}
 * @Description: ${TODO}(这里用一句话描述这个方法的作用)
 * @param: ${TAGS}
 * @return: ${RETURN_TYPE}
 * @throws
 * @Date 2018/10/23 11:00
 */
public class DataBlock {



    long start;
    long end;
    StoreLocaltion storeLocaltion;
    String checksum;//校验和

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public StoreLocaltion getStoreLocaltion() {
        return storeLocaltion;
    }

    public void setStoreLocaltion(StoreLocaltion storeLocaltion) {
        this.storeLocaltion = storeLocaltion;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }
}

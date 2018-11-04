import java.util.Objects;

/**
 * @author CHZPRTK

 * @Date 2018/10/23 11:01
 */
public class StoreLocaltion {

    String type;//  default  file:
    String path;// 完整存储路径


    public StoreLocaltion() {
    }

    public StoreLocaltion(String type, String path) {
        this.type = type;
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoreLocaltion that = (StoreLocaltion) o;
        return Objects.equals(type, that.type) &&
                Objects.equals(path, that.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, path);
    }
}

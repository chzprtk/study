import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * @author CHZPRTK
 * @Date 2018/10/23 10:59
 */
public class Data {
    String id;//
//    String version;//数据版本
    String checksum;//数据校验和
    long size;//数据尺寸

    long blocksize=1024*1024*8;
    String[] blockids=new String[0];//存放块ID 块
    String[] blockchecksums=blockids;//如果 用校验做ID 相同即可
//    StoreLocaltion location;

    //这个做的是  可以根据不是具体的  分块  存储 而是  某段范围  可以存多份在不同地方  重叠的数据 丢了一份 还能读取有效的
    //序列化很占空间  算了。。暂不考虑
//    List<DataBlock> blocks=new ArrayList<>();




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getBlocksize() {
        return blocksize;
    }

    public void setBlocksize(long blocksize) {
        this.blocksize = blocksize;
    }

    public String[] getBlockids() {
        return blockids;
    }

    public void setBlockids(String[] blockids) {
        this.blockids = blockids;
    }

    public String[] getBlockchecksums() {
        return blockchecksums;
    }

    public void setBlockchecksums(String[] blockchecksums) {
        this.blockchecksums = blockchecksums;
    }


    public void randomTestData(){
        id= UUID.randomUUID().toString();
//        version=UUID.randomUUID().toString();
        checksum=UUID.randomUUID().toString();

//        defalutlocation=new StoreLocaltion("file","C:/name/");
        size=new Random().nextInt(1024*1024*1024)*2;


//        long blockSize=1024*1024;
        long count=size/blocksize;

        if(size%blocksize>0){
            count++;//总块数
        }

        List<String> list=new ArrayList<>();
        for(int i=0;i<count;i++){
            list.add(UUID.randomUUID().toString());
        }
        blockids=list.toArray(new String[list.size()]);

        blockchecksums=blockids;

//        for(int i=0;i<count;i++){
//            DataBlock block = new DataBlock();
//            block.start=count*i;
//            if(i!=count){
//                block.end=block.start+blockSize;
//            }else{
//                block.end=size-1;
//            }
//
//            blocks.add(block);
//            block.checksum=UUID.randomUUID().toString();
//        }




    }

}

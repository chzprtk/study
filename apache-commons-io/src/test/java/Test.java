
import org.apache.commons.compress.compressors.FileNameUtil;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

/**参考教程
 * http://jackyrong.iteye.com/blog/2153812
 * @author CHZPRTK
 * @Date 2018/11/2 17:16
 */
public class Test {

@org.junit.Test
    public void test() throws IOException {
        {
/*
     1） FilenameUtils:主要处理各种操作系统下对文件名的操作
     2) FileUtils:处理文件的打开，移动，读取和判断文件是否存在
    3） IOCASE：字符串的比较
    4） FileSystemUtils:返回磁盘的空间大小
 */


            System.out.println(ByteUtils.fromLittleEndian(new byte[]{2,3}));
            // by FileUtils
            File file = new File("test.txt");

            System.out.println(FileUtils.byteCountToDisplaySize(new BigInteger("10240000").multiply(new BigInteger("1024000000"))));//自动根据大小显示 近似单位 单位字节 int太小 需要biginteger 存下
//            FilenameUtils.isExtension()//判断文件后缀
            ;
            System.out.println(FilenameUtils.getFullPath("test.txt"));
            List<String> lines = FileUtils.readLines(file, "UTF-8");//throws IOException
            System.out.println("FileUtils.readLine:"+lines);
        }
        {

        // by IOUtils 读取所有行
            File file = new File("test.txt");
        List<String> lines = IOUtils.readLines(new FileInputStream(file), "UTF-8");
            System.out.println("IOUtils.readLine:"+lines);
        }
    }
}

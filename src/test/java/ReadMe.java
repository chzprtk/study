import com.sun.corba.se.impl.orbutil.ObjectWriter;
import org.junit.Test;

import java.io.*;

public class ReadMe {

    /**
     * 临时存放测试代码的地方  测试完 复制改名  存放到下面
     *
     */
    @Test
    public void test() throws IOException {
        //子项目里面 为 学习练习测试代的项目
        //test目录是测试代码

        OutputStream outputStream=new ByteArrayOutputStream();

        ObjectOutput objectOutput=new ObjectOutputStream(new FileOutputStream("E:/Objcet.object"));

        objectOutput.writeObject(new Integer(123));





    }




}

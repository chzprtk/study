import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GsonTest {


    @Test
    public void test() throws IOException {

        Gson gson=new GsonBuilder().create();
        User user=new User();
        user.setName("name");
        user.setId(1234);


        System.out.println(gson.toJson(user));

        User u2=gson.fromJson(gson.toJson(user),User.class);
        System.out.println(u2);

        System.out.println(Objects.equals(null,null));

        System.out.println(((byte)(0b1000)&0b1000)==0b1000);


        System.out.println(System.currentTimeMillis());
        List<Data> dataList=new ArrayList<>();
        for(int i=0;i<10;i++){
            Data data = new Data();
            data.randomTestData();
            dataList.add(data);
        }


        System.out.println(System.currentTimeMillis());


        String jsonstr =gson.toJson(dataList);
        System.out.println(System.currentTimeMillis());
        Files.write(Paths.get("C:/name/json"),jsonstr.getBytes());


    }

}

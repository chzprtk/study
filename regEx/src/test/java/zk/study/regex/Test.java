package zk.study.regex;

import java.util.regex.Pattern;

public class Test {

    /**
     * 临时存放测试代码的地方  测试完 复制改名  存放到下面
     *
     */
    @org.junit.Test
    public void test(){
        //子项目里面 为 学习练习测试代的项目
        //test目录是测试代码

    }

    @org.junit.Test
    public void 基础匹配测试() throws InterruptedException {
        {
            //常用匹配方式
            //String.matches("regex")
            //内部使用的  Pattern.matches("regex","str")
            //直接匹配是否满足表达式（能否匹配到结果 ）
            System.out.println("String.matches('regex') 与 Patter.matches('regex','str')");
            System.out.println("abcd".matches("a.*"));
            System.out.println(Pattern.matches("a","abcd"));

        }
        synchronized (this){
            int i=0;
        while(true){
            System.out.println(System.nanoTime()/1000);
            this.wait(0,1);
            System.out.println(System.nanoTime()/1000);
            if(System.nanoTime()==0){
                break;
            }
            i++;
            if(i%1000==0){
                System.out.println(System.nanoTime()/1000);
            }
        }}

        {
            //编译 Pattern(模式)  适合复用  效率高些 些 些....
//        Pattern p=Pattern.compile(String regex);
//        Pattern p= Pattern.compile(String regex,int flag);

        }

    }


}

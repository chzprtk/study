package zk.study.jiami.rsa.example1;
public class MainTest {

    public static void main(String[] args) throws Exception {
        String filepath="E:/tmp/";

        //生成公钥和私钥文件
        RSAEncrypt.genKeyPair(filepath);


        System.out.println("私钥字节长度："+Base64.decode(RSAEncrypt.loadPrivateKeyByFile(filepath)).length);
        System.out.println("公钥字节长度："+Base64.decode(RSAEncrypt.loadPublicKeyByFile(filepath)).length);

        System.out.println("--------------公钥加密私钥解密过程-------------------");
        String plainText="ihep_公钥加密私钥解密";
        //密钥位数/8-11  加密的内容最大长度
        plainText=MainTest.取重复字符串(2048/8-11,"a");
        
        //公钥加密过程
        byte[] cipherData=RSAEncrypt.encrypt(RSAEncrypt.loadPublicKeyByStr(RSAEncrypt.loadPublicKeyByFile(filepath)),plainText.getBytes());
        String cipher=Base64.encode(cipherData);
        //私钥解密过程
        byte[] res=RSAEncrypt.decrypt(RSAEncrypt.loadPrivateKeyByStr(RSAEncrypt.loadPrivateKeyByFile(filepath)), Base64.decode(cipher));
        String restr=new String(res);
        System.out.println("原文："+plainText);
        System.out.println("加密："+cipher);
        System.out.println("解密："+restr);
        System.out.println(cipher.length()+" "+Base64.decode(cipher).length);
        System.out.println();

        System.out.println("--------------私钥加密公钥解密过程-------------------");
        plainText="ihep_私钥加密公钥解密";
        //私钥加密过程
        cipherData=RSAEncrypt.encrypt(RSAEncrypt.loadPrivateKeyByStr(RSAEncrypt.loadPrivateKeyByFile(filepath)),plainText.getBytes());
        cipher=Base64.encode(cipherData);
        //公钥解密过程
        res=RSAEncrypt.decrypt(RSAEncrypt.loadPublicKeyByStr(RSAEncrypt.loadPublicKeyByFile(filepath)), Base64.decode(cipher));
        restr=new String(res);
        System.out.println("原文："+plainText);
        System.out.println("加密："+cipher);
        System.out.println("解密："+restr);
        System.out.println();

        System.out.println("---------------私钥签名过程------------------");
        String content="ihep_这是用于签名的原始数据";
        String signstr=RSASignature.sign(content,RSAEncrypt.loadPrivateKeyByFile(filepath));
        System.out.println("签名原串："+content);
        System.out.println("签名串："+signstr);
        System.out.println();

        System.out.println("---------------公钥校验签名------------------");
        System.out.println("签名原串："+content);
        System.out.println("签名串："+signstr);

        System.out.println("验签结果："+RSASignature.doCheck(content, signstr, RSAEncrypt.loadPublicKeyByFile(filepath)));
        System.out.println();

    }


    public static String  取重复字符串(int length,String str){
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<length;i++){
            stringBuilder.append(str);

        }
        return stringBuilder.toString();

    }
}
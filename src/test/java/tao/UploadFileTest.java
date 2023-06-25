package tao;


import org.junit.jupiter.api.Test;

/**
 * @author 彭桂涛
 * @version 1.0
 */
public class UploadFileTest {
    @Test
    public void test1(){
        String fileName = "ererewe.jpg";
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        System.out.println(suffix);
        System.out.println("hello");
    }
}

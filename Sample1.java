import java.io.*;

public class Sample1
{
  public static void main(String[] args)
  {
    if(args.length !=1){
      System.out.println("パラメータの数が違います。");
      System.exit(1);
    }

    try{
      File fl = new File(args[0]);
      System.out.println("ファイル名は" + fl.getName() + "です。");
      System.out.println("絶対パスは" + fl.getAbsolutePath() + "です。");
      System.out.println("サイズは" + fl.length() + "バイトです。");
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
}
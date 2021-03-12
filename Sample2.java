import java.io.*;

public class Sample2
{
  public static void main(String[] args)
  {
    if(args.length !=2){
      System.out.println("パラメータの数が違います。");
      System.exit(1);
    }
    try{
      File fl1 = new File(args[0]);
      File fl2 = new File(args[1]);

      System.out.println("変更前のファイル名は" + fl1.getName() + "です。");

      boolean res = fl1.renameTo(fl2);

      if(res == true){
        System.out.println("ファイル名を変更しました。");
        System.out.println("変更後のファイル名は" + fl2.getName() + "です。");
      }
      else{
        System.out.println("ファイル名を変更できませんでした。");
      }
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
}
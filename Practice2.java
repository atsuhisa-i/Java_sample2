import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.*;

public class Practice2
{
  public static void main(String[] args)throws Exception
  {
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();

    Document doc = db.newDocument();

    Element root = doc.createElement("果物リスト");
    doc.appendChild(root);

    Element fruit = doc.createElement("果物");
    root.appendChild(fruit);

    Element elm1 = doc.createElement("名前");
    Text txt1 = doc.createTextNode("みかん");
    elm1.appendChild(txt1);
    fruit.appendChild(elm1);

    Element elm2 = doc.createElement("仕入先");
    Text txt2 = doc.createTextNode("青山商店");
    elm2.appendChild(txt2);
    fruit.appendChild(elm2);

    TransformerFactory tff = TransformerFactory.newInstance();
    Transformer tf = tff.newTransformer();
    tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
    tf.transform(new DOMSource(doc), new 
      StreamResult("result.xml"));
    System.out.println("result.xmlに出力しました。");

  
  }
}
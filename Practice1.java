import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.*;

public class Practice1
{
  public static void main(String[] args)throws Exception
  {
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();

    Document doc = db.parse(new FileInputStream("Sample.xml"));

    Document doc2 = db.newDocument();

    Element root = doc2.createElement("cars");
    doc2.appendChild(root);

    NodeList lst = doc.getElementsByTagName("price");

    for(int i=0; i<lst.getLength(); i++){
      Node n = lst.item(i);
      for(Node ch = n.getFirstChild();
               ch != null;
               ch = ch.getNextSibling()){
          Element elm = doc2.createElement("price");
          Text txt = doc2.createTextNode(ch.getNodeValue());
          elm.appendChild(txt);
          root.appendChild(elm);
      }
    }

    TransformerFactory tff = TransformerFactory.newInstance();
    Transformer tf = tff.newTransformer();
    tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
    tf.transform(new DOMSource(doc2),
      new StreamResult("result.xml"));
    System.out.println("result.xmlに出力しました。");
  }
}
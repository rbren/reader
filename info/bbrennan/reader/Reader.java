package info.bbrennan.reader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Reader {
  private static final String URL = "http://www.reddit.com/";

  private final String mUrl;

  public static void main(String[] args) {
    Reader reader = new Reader(URL);
    try {
      reader.printContents();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public Reader(String url) {
    mUrl = url;
  }

  public void printContents() throws IOException {
    Document doc = Jsoup.connect(mUrl).get();
    Element body = doc.body();
    String bodyText = body.text();
    System.out.println("body:" + bodyText);
  }
}

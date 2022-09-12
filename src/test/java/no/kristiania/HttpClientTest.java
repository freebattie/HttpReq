package no.kristiania;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HttpClientTest {

    @Test
    public void TestGet(){
        var res ="";
        MyHttpClient  client = new MyHttpClient("httpbin.org",80);
        try {
            res =  client.GetMsg();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("{\n" +
                "  \"args\": {},\n" +
                "  \"headers\": {\n" +
                "    \"Accept\": \"application/json\",\n" +
                "    \"Accept-Encoding\": \"gzip, deflate\",\n" +
                "    \"Accept-Language\": \"nb,en-US;q=0.9,en;q=0.8,nb-NO;q=0.7,no;q=0.6,nn;q=0.5\",\n" +
                "    \"Host\": \"httpbin.org\",\n" +
                "    \"Referer\": \"http://httpbin.org/\",\n" +
                "    \"User-Agent\": \"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36\",\n" +
                "    \"X-Amzn-Trace-Id\": \"Root=1-631f2495-6975ff1a3f069683799138e9\"\n" +
                "  },\n" +
                "  \"origin\": \"51.175.175.182\",\n" +
                "  \"url\": \"http://httpbin.org/get\"\n" +
                "}",res);

    }

}

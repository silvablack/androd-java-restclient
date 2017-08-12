package com.paulosilva.cwebservice;
import android.os.AsyncTask;
import com.google.gson.Gson;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.xml.sax.XMLReader;
import java.net.URL;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

class ReceiveTask extends AsyncTask<String, Void, Users> {
    private Exception exception;
    protected Users doInBackground(String... urls) {
        try {
            String urlString = urls[0];

            HttpClient client = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(urlString);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String response = client.execute(httpGet, responseHandler);
            if(response.length()>0){
                Gson gson = new Gson();

                Users u = gson.fromJson(response, Users.class);

                if (u.getId() > 0) {
                    return null;
                }else{
                    throw new Exception("1");
                }
            }else{
                throw new ClientProtocolException("ONO");
            }


        } catch (Exception e) {
            this.exception = e;
            return null;
        }
    }
    protected void onPostExecute(Users users) {
        // TODO: check this.exception
        // TODO: do something with the feed
    }
}

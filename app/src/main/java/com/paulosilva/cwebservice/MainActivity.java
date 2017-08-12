package com.paulosilva.cwebservice;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.ContentEncodingHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btConsulta = (Button)findViewById(R.id.btConsulta);
        btConsulta.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                consultarWebservice(v);
            }
        });

    }



    public void consultarWebservice(View view) {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        TextView mText = (TextView) findViewById(R.id.textView1);

        try {
            String url = "http://177.13.150.57/webservice-yii2/web/webservice/index";
            HttpClient client = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);

            ResponseHandler<String> responseHandler = new BasicResponseHandler();

            String response = client.execute(httpGet, responseHandler);
            if(response.length()>0){
                Gson gson = new Gson();
                Users[] u = gson.fromJson(response, Users[].class);
                mText.setText(u[0].toString()+'\n'+u[1].toString());
            }else{
                throw new ClientProtocolException("ONO");
            }

        }catch (Exception e){
          //String r =  Utils.getIPAddress(true); // IPv4
            mText.setText(e.getMessage());
        }

    }
}

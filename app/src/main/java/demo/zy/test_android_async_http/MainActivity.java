package demo.zy.test_android_async_http;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.entity.HttpEntityWrapper;
import cz.msebera.android.httpclient.entity.StringEntity;

public class MainActivity extends AppCompatActivity {

    private AsyncHttpClient mAsyncHttpClient = new AsyncHttpClient();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mAsyncHttpClient.addHeader("Content-Type","application/x-www-form-urlencoded");
        String url = "http://cdn.api18tv.com/vodapi.html";
        String contentType = "application/x-www-form-urlencoded";


//        (Context context, String url, HttpEntity entity, String contentType, ResponseHandlerInterface responseHandler)

        String text2 ="data=%257B%2522Action%2522%253A%2522GetAppEdition%2522%252C%2522Message%2522%253A%257B%2522OS%2522%253A2%252C%2522Type%2522%253A1%257D%257D";


        StringEntity stringEntity = null;
        try {
            stringEntity = new StringEntity(text2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }



        mAsyncHttpClient.post(getApplicationContext(), url, stringEntity, contentType, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.e("MainActivity","onFailure = "+ responseString);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Log.e("MainActivity","onSuccess = "+ responseString);
            }
        });


    }




}

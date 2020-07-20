package com.example.qiyou;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.String;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.logging.Handler;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;


//import jdk.internal.org.jline.utils.InputStreamReader;

public class depends extends Thread{
    private String msg;
    private String url_server;
    private HttpURLConnection connection;
    private OutputStream outputStream;
    private URL url;
    private android.os.Handler handler;
    public depends(String msg,Handler handler) {

    }

    public depends(android.os.Handler handler) {
        this.handler=handler;
        url_server = "http://39.98.209.180:8080/";
    }

    public String create_message_for_client(String name, String id, String passwd, String type_name,
                                            String return_need_or_not, String data) {
        String msg;
        msg = "{";
        msg = msg + "\""+"user_info" + "\""+":" + "{" + "\""+ "name"+ "\""+ ":" + "\""+ name + "\""+ ","+ "\""+"id"+ "\""+":" + "\""+ id + "\""+ ","+ "\""+"passwd"+ "\""+":" + "\""+ passwd + "\""+ "},";
        msg = msg + "\""+"user_request_type"+ "\""+":" + "{" + "\""+ "type_name"+ "\""+":" + "\""+ type_name + "\""+ ","+ "\""+"return_need_or_not"+ "\""+":" + "\""+return_need_or_not
                + "\""+ "},";
        msg = msg + "\""+ "user_data"+ "\""+":" + "\""+data + "\"";
        msg += "}";
        this.msg=msg;
        return msg;
    }
    public void send_to_main(String msg){
        Bundle data = new Bundle();
        data.putString("value", msg);

        Message message = new Message();
        message.setData(data);
        handler.sendMessage(message);
    }
    public void send_msg(String msg) throws IOException {
        try {

            url = new URL(url_server);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setConnectTimeout(15000);
            connection.setReadTimeout(60000);

            connection.setDoInput(true);
            connection.setDoOutput(true);
            String s1 = "application/json";
            connection.setRequestProperty("Content-type", "application/json");
            connection.connect();
            OutputStreamWriter out = new OutputStreamWriter(
                    connection.getOutputStream(), "utf-8"
            );
            out.append(msg);
            out.flush();
            out.close();
            //outputStream = connection.getOutputStream();
            //outputStream.write(msg.getBytes());
            //Log.e("mes is",outputStream.toString());
            //outputStream.flush();
            if (connection.getResponseCode() == 200) {
                InputStream is = connection.getInputStream();
                //BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"));
                //System.out.println(is.toString());
                //Log.e("test1", is.toString());
                ByteArrayOutputStream message = new ByteArrayOutputStream();
                int len = 0;
                byte[] buffer = new byte[1024];
                while ((len = is.read(buffer)) != -1) {
                    message.write(buffer, 0, len);
                }
                is.close();
                message.close();
                String return_msg = new String(message.toByteArray());
                send_to_main(return_msg);
            }
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        try {
            send_msg(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
/*
String url = "http://192.168.0.106:8080/MyWeb/RegisterServlet";
RequestParams params = new RequestParams();
params.put("username", arEtUsername.getText().toString());
params.put("password", arEtPassword.getText().toString());
RequestUtils.ClientPost(url, params, new NetCallBack() {
    @Override
    public void onMySuccess(byte[] response) {
         Lod.d(TAG,"register success and json---->"+new String(response));
         Toast.makeText(this,"json="+new String(response),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMyFailure(byte[] response, Throwable throwable) {
        Log.e(TAG,new String(response)+"\n"+ throwable.toString());
    }
});
*/
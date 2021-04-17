package com.company;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

public class apacheTest {
    public static void main(String[] args) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet("http://www.example.org/");
        request.addHeader("User-Agent","Chrome");
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(request);
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line;
            while ((line = inputStream.readLine())!=null){
                System.out.println(line);
            }
            inputStream.close();
        }catch (MalformedURLException e){
            System.out.println("Url exception " + e.getMessage());
        }catch (IOException e){
            System.out.println("IOException " + e.getMessage());
        }finally {
            try {
                response.close();
            }catch (IOException e){
                System.out.println("IOException " + e.getMessage());
            }
        }
    }
}

package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Main {

    public static void main(String[] args) {
        try {
//            URL url = new URL("https://examle.org/");
            URL url = new URL("https://www.flickr.com/photos/130832454@N06/49969337653/");

            HttpURLConnection connection =(HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent","Chrome");
            connection.setReadTimeout(30000);

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code = " + responseCode);

            if (responseCode!=200){
                System.out.println("Error reading web page");
                System.out.println(connection.getResponseMessage());
                return;
            }

                BufferedReader inputStream = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = inputStream.readLine())!=null){
                    System.out.println(line);
                }
                inputStream.close();
            }catch (MalformedURLException e){
                System.out.println("Url exception " + e.getMessage());
            }catch (IOException e){
                System.out.println("IOException " + e.getMessage());
        }




//            urlConnection.setDoOutput(true);
//                    urlConnection.connect();
//
//
//            BufferedReader inputStream = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
//
//            Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
//
//            for (Map.Entry<String,List<String>> entry : headerFields.entrySet()){
//                String key = entry.getKey();
//                List<String> value = entry.getValue();
//                System.out.println("-------------key = " + key);
//                for (String string : value){
//                    System.out.println("Value = " + string);
//                }
//            }

//            String line = "";
//            while (line!=null){
//                line = inputStream.readLine();
//                System.out.println(line);
//            }
//            inputStream.close();

//            URI uri = url.toURI();

//            URI uri = new URI("http://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");
//            URI baseURI = new URI("http://username:password@mynewserver.com:5000");
//            URI uri1 = new URI("/catalogue/phones?os=android#samsung");
//            URI uri2 = new URI("/catalogue/tvs?manufacturer=samsung");
//            URI uri3 = new URI("/stores/locations?zip=12345");
//            URI resolveURI1 = baseURI.resolve(uri1);
//            URI resolveURI2 = baseURI.resolve(uri2);
//            URI resolveURI3 = baseURI.resolve(uri3);
//
//            URL url1 = resolveURI1.toURL();
//            URL url2 = resolveURI2.toURL();
//            URL url3 = resolveURI3.toURL();
//            System.out.println("Url1 = " + url1);
//            System.out.println("Url2 = " + url2);
//            System.out.println("Url3 = " + url3);
//
//            URI relativizedURI = baseURI.relativize(resolveURI2);
//            System.out.println("Relativized URI " + relativizedURI);

//            System.out.println("scheme = " + uri.getScheme());
//            System.out.println("Scheme specific part = " + uri.getSchemeSpecificPart());
//            System.out.println("Authority = " + uri.getAuthority());
//            System.out.println("User Info = " + uri.getUserInfo());
//            System.out.println("Host = " + uri.getHost());
//            System.out.println("Port = " + uri.getPort());
//            System.out.println("Path = " + uri.getPath());
//            System.out.println("Query = " + uri.getQuery());
//            System.out.println("Fragment = " + uri.getFragment());


    }
}

package com.shile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.List;
import java.util.Map;

public class Main {
    /**
     *  1. URL地址必须是绝对的,URI的地址可以相对
     *  2. URI,URL,URN区别: https://www.w3.org/TR/uri-clarification/
     *  3. readwebpage的方式URLConnection,InputStreamReader
     *  4. 方法定义: https://www.w3.org/Protocols/rfc2616/rfc2616-sec9.html
     *  5. header field: https://en.wikipedia.org/wiki/List_of_HTTP_header_fields
     *  6. java.net很难用,一般用第三方库apache HttpClient or jetty
     * */

    public static void main(String[] args) {

	    try {
	        URL url = new URL("http://example.org");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent","Chorme");
            connection.setReadTimeout(30000);

            int responseCode = connection.getResponseCode();
            System.out.println("Response code: " + responseCode);

            if (responseCode != 200) {
                System.out.println("Error reading web page");
                return;
            }

            BufferedReader inputReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            String line;

            while ((line = inputReader.readLine()) != null) {
                System.out.println(line);
            }
            inputReader.close();

//            urlConnection.setDoOutput(true);
//            urlConnection.connect();
//
//            BufferedReader inputStream = new BufferedReader(
//                    new InputStreamReader(urlConnection.getInputStream()));
//
//            Map<String, List<String>> herderFields = urlConnection.getHeaderFields();
//            for (Map.Entry<String,List<String>> entry : herderFields.entrySet()) {
//                String key = entry.getKey();
//                List<String> value  = entry.getValue();
//                System.out.println("--------key = " + key);
//                for (String string : value) {
//                    System.out.println("value = " + value);
//                }
//            }

//            String line = "";
//            while (line != null) {
//                line = inputStream.readLine();
//                System.out.println(line);
//            }
//            inputStream.close();


	    }catch (MalformedURLException e) {
            System.out.println("Malformed exception: " + e.getMessage());
        }
	    catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
        }
    }
}

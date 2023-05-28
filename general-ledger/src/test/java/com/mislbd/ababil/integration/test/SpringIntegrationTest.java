package com.mislbd.ababil.integration.test;

import com.mislbd.ababil.integration.test.auth.AuthData;
import com.mislbd.ababil.integration.test.error.ErrorHandler;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.List;

/**
 * Created by sanjoy on 10/28/18.
 */
@SpringBootTest(classes = IntegrationTestApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration
public class SpringIntegrationTest {

    @Value("${mislbd.resource.baseUrl}")
    private String resourceBaseUrl;

    RestTemplate restTemplate = new RestTemplate();
    JSONParser parser = new JSONParser();

    public Object parseJSON(String fileName) throws IOException, ParseException{
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("./jsonFile/"+fileName+".json");
        Object object = parser.parse(new InputStreamReader(inputStream));

        return object;
    }

    public ResponseEntity<JSONObject> executePost(String fileName,String url) {
        restTemplate.setErrorHandler(new ErrorHandler());
        ResponseEntity<JSONObject> response=null;
        try {
            Object obj = parseJSON(fileName);
            if(obj instanceof JSONArray) {
                JSONArray jsonObject = (JSONArray) obj;
                HttpEntity<JSONArray> request = new HttpEntity<JSONArray>(jsonObject, getPostCallHeaders());
                response = restTemplate.exchange(resourceBaseUrl + "/" + url, HttpMethod.POST, request, JSONObject.class);
            }else{
                JSONObject jsonObject = (JSONObject) obj;
                HttpEntity<JSONObject> request = new HttpEntity<JSONObject>(jsonObject, getPostCallHeaders());
                response = restTemplate.exchange(resourceBaseUrl + "/" + url, HttpMethod.POST, request, JSONObject.class);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    public ResponseEntity<JSONObject> executePut(String fileName,String url) {
        restTemplate.setErrorHandler(new ErrorHandler());
        ResponseEntity<JSONObject> response=null;
        try {
            Object obj = parseJSON(fileName);
            if(obj instanceof JSONArray) {
                JSONArray jsonObject = (JSONArray) obj;
                HttpEntity<JSONArray> request = new HttpEntity<JSONArray>(jsonObject, getPostCallHeaders());
                response = restTemplate.exchange(resourceBaseUrl + "/" + url, HttpMethod.PUT, request, JSONObject.class);
            }else{
                JSONObject jsonObject = (JSONObject) obj;
                HttpEntity<JSONObject> request = new HttpEntity<JSONObject>(jsonObject, getPostCallHeaders());
                response = restTemplate.exchange(resourceBaseUrl + "/" + url, HttpMethod.PUT, request, JSONObject.class);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    private HttpHeaders getPostCallHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization"," Bearer "+ AuthData.accessToken);
        return headers;
    }

    public void updateJSON(String contentValue, String fileName) throws IOException, ParseException{
        Object obj = parseJSON(fileName);
        JSONObject jsonObject = (JSONObject) obj;
        jsonObject.put("generalLedgerAccountId", ""+contentValue+"");

        FileWriter file = new FileWriter("../general-ledger/target/test-classes/jsonFile/"+fileName+".json");
        try{
            file.write(jsonObject.toString());
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            file.flush();
            file.close();
        }
    }
}

package com.mislbd.ababil.integration.test;

import com.mislbd.ababil.integration.test.auth.AuthData;
import com.mislbd.ababil.integration.test.error.ErrorHandler;
import org.json.JSONException;
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
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    public ResponseEntity<?> executeGet(String url,Class<?> type){
        restTemplate.setErrorHandler(new ErrorHandler());
        ResponseEntity<?> response =  null;
        try{
            JSONObject jsonObject = new JSONObject();
            HttpEntity<JSONObject> request = new HttpEntity<JSONObject>(jsonObject, getPostCallHeaders());
            response = restTemplate.exchange(resourceBaseUrl + "/" + url, HttpMethod.GET, request, type);
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
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

    public void updateJSON(String key, String value, String fileName) throws IOException, ParseException{
        Object obj = parseJSON(fileName);
        JSONObject jsonObject = (JSONObject) obj;
        jsonObject.put(key, value);

        try(FileWriter file = new FileWriter("../deposit/target/test-classes/jsonFile/"+fileName+".json")){
            file.write(jsonObject.toString());
        }
    }

    public void updateDDAccountId(String contentValue, String fileName) throws IOException, ParseException, JSONException {
        Object obj = parseJSON(fileName);
        if(obj instanceof JSONArray) {
            JSONArray jsonArray = (JSONArray) obj;
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                jsonObject.put("demandDepositAccountId", contentValue);
            }
            try (FileWriter file = new FileWriter("../deposit/target/test-classes/jsonFile/" + fileName + ".json")) {
                file.write(jsonArray.toString());
            }
        }
    }

    public void updateAccount(String productID, String accountNumber, String fileName)throws IOException, ParseException{
        Object obj = parseJSON(fileName);
        JSONObject jsonObject = (JSONObject) obj;
        jsonObject.put("productId", productID);
        jsonObject.put("number", accountNumber);

        try(FileWriter file = new FileWriter("../deposit/target/test-classes/jsonFile/"+fileName+".json")){
            file.write(jsonObject.toString());
        }
    }

    public static int getID(int id) throws Exception{
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        Class.forName("org.h2.Driver");
        con = DriverManager.getConnection("jdbc:h2:mem:TEST","sa","a");
        stmt = con.createStatement();
        rs = stmt.executeQuery("select CONTENT_VALUE from Data where id = "+id+" ");
        while(rs.next())
        {
            id = Integer.parseInt(rs.getString("CONTENT_VALUE"));
        }
        return id;
    }

    public void updateDateAndTime(String key, String fileName) throws IOException, ParseException{
        Object obj = parseJSON(fileName);
        JSONObject jsonObject = (JSONObject) obj;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        String dateTime = LocalDateTime.now().format(formatter);
        jsonObject.put(key, dateTime);

        try(FileWriter file = new FileWriter("../deposit/target/test-classes/jsonFile/"+fileName+".json")){
            file.write(jsonObject.toString());
        }
    }

    public void updateDateTime(String fileName, String start, String end) throws IOException, ParseException{
        Object obj = parseJSON(fileName);
        JSONObject jsonObject = (JSONObject) obj;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        String dateTime = LocalDateTime.now().format(formatter);
        jsonObject.put(start, dateTime);
        jsonObject.put(end, dateTime);

        try(FileWriter file = new FileWriter("../deposit/target/test-classes/jsonFile/"+fileName+".json")){
            file.write(jsonObject.toString());
        }
    }

    public void updateDate(String fileName, String start, String end) throws IOException, ParseException{
        Object obj = parseJSON(fileName);
        JSONObject jsonObject = (JSONObject) obj;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = LocalDate.now().format(formatter);
        jsonObject.put(start, date);
        jsonObject.put(end, date);

        try(FileWriter file = new FileWriter("../deposit/target/test-classes/jsonFile/"+fileName+".json")){
            file.write(jsonObject.toString());
        }
    }
}

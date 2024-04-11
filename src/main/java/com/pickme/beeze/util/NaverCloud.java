package com.pickme.beeze.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import android.util.Base64;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@PropertySource("classpath:key.properties")
public class NaverCloud {

	@Value("${chatbot.api_url}")
	private String apiURL;
	
	@Value("${chatbot.secret_key}")
	private String secretKey;
	
	@Value("${ocr.api_url}")
	private String OCRapiURL;
	
	@Value("${ocr.secret_key}")
	private String OCRsecretKey;
	
	public NaverCloud() {
	}
	
	// TODO 챗봇
	public String ChatBot(String voiceMessage) {
		String chatbotMessage = "";

        try {   
            URL url = new URL(apiURL);

            String message = getReqMessage(voiceMessage);
            System.out.println("##" + message);

            String encodeBase64String = makeSignature(message, secretKey);

            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json;UTF-8");
            con.setRequestProperty("X-NCP-CHATBOT_SIGNATURE", encodeBase64String);

            // post request
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.write(message.getBytes("UTF-8"));
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();

            BufferedReader br;

            if(responseCode==200) { // Normal call
                System.out.println(con.getResponseMessage());

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                con.getInputStream()));
                String decodedString;
                while ((decodedString = in.readLine()) != null) {
                    chatbotMessage = decodedString;
                }
                //chatbotMessage = decodedString;
                in.close();

            } else {  // Error occurred
                chatbotMessage = con.getResponseMessage();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println(chatbotMessage);
    	return chatbotMessage;
    }
	
    public static String makeSignature(String message, String secretKey) {

        String encodeBase64String = "";

        try {
            byte[] secrete_key_bytes = secretKey.getBytes("UTF-8");

            SecretKeySpec signingKey = new SecretKeySpec(secrete_key_bytes, "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(signingKey);

            byte[] rawHmac = mac.doFinal(message.getBytes("UTF-8"));
            encodeBase64String = Base64.encodeToString(rawHmac, Base64.NO_WRAP);

            return encodeBase64String;

        } catch (Exception e){
            System.out.println(e);
        }

        return encodeBase64String;

    }

    public static String getReqMessage(String voiceMessage) {

        String requestBody = "";

        try {

            JSONObject obj = new JSONObject();

            long timestamp = new Date().getTime();

            System.out.println("##"+timestamp);

            obj.put("version", "v2");
            obj.put("userId", "U47b00b58c90f8e47428af8b7bddc1231heo2");
//=> userId is a unique code for each chat user, not a fixed value, recommend use UUID. use different id for each user could help you to split chat history for users.

            obj.put("timestamp", timestamp);

            JSONObject bubbles_obj = new JSONObject();

            bubbles_obj.put("type", "text");

            JSONObject data_obj = new JSONObject();
            data_obj.put("description", voiceMessage);

            bubbles_obj.put("type", "text");
            bubbles_obj.put("data", data_obj);

            JSONArray bubbles_array = new JSONArray();
            bubbles_array.put(bubbles_obj);

            obj.put("bubbles", bubbles_array);
            
            if(Objects.equals(voiceMessage, "")) {
                obj.put("event", "open"); // 월컴 메세지
            } else {
                obj.put("event", "send");
            }

            requestBody = obj.toString();

        } catch (Exception e){
            System.out.println("## Exception : " + e);
        }

        return requestBody;

    }
    
 // TODO OCR
    public String OcrProc(MultipartFile file) {
        String message = null;

        try {
            // OCR API 호출을 위한 URL 설정
            URL url = new URL(OCRapiURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setUseCaches(false);
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setReadTimeout(30000);
            con.setRequestMethod("POST");

            // Multi-part form data 설정
            String boundary = "----" + UUID.randomUUID().toString().replaceAll("-", "");
            con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            con.setRequestProperty("X-OCR-SECRET", OCRsecretKey);

            // OCR API 요청에 필요한 JSON 데이터 구성
            JSONObject json = new JSONObject();
            json.put("version", "V2");
            json.put("requestId", UUID.randomUUID().toString());
            json.put("timestamp", System.currentTimeMillis());
            JSONObject image = new JSONObject();
            image.put("format", "jpg");
            image.put("name", "demo");
            JSONArray images = new JSONArray();
            images.put(image);
            json.put("images", images);
            String postParams = json.toString();

            // 연결
            con.connect();

            // Request Body에 Multi-part form data 작성
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            long start = System.currentTimeMillis();
            writeMultiPart(wr, postParams, file, boundary);
            wr.close();

            // 응답 코드 확인
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if (responseCode == 200) {
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }

            // 응답 내용을 읽어옴
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();

            // 결과값 출력
            System.out.println(response);
            message = response.toString();

        } catch (Exception e) {
            // 오류 발생 시 예외 처리
            System.out.println(e);
        }

        return message;
    }


    private static void writeMultiPart(OutputStream out, String jsonMessage, MultipartFile file, String boundary) throws IOException {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("--").append(boundary).append("\r\n");
            sb.append("Content-Disposition:form-data; name=\"message\"\r\n\r\n");
            sb.append(jsonMessage);
            sb.append("\r\n");

            out.write(sb.toString().getBytes("UTF-8"));
            out.flush();

            if (file != null && !file.isEmpty()) {
                out.write(("--" + boundary + "\r\n").getBytes("UTF-8"));
                StringBuilder fileString = new StringBuilder();
                fileString
                    .append("Content-Disposition:form-data; name=\"file\"; filename=\"")
                    .append(file.getOriginalFilename()).append("\"\r\n");
                fileString.append("Content-Type: application/octet-stream\r\n\r\n");
                out.write(fileString.toString().getBytes("UTF-8"));
                out.flush();

                out.write(file.getBytes());
                out.write("\r\n".getBytes());
                out.flush();
            }

            out.write(("--" + boundary + "--\r\n").getBytes("UTF-8"));
            out.flush();
        } catch (IOException e) {
            // 예외 처리
            e.printStackTrace();
            throw e;
        }
    }

}

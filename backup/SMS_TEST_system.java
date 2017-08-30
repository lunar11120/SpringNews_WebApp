/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springnews.sms.controller;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Send_SMS_gateway {

    public static void main(String[] args) {

        try {

            String username = "lunar11120";
            String password = "2defc2";
            String from = "SMS";
            String to = "0851560735";
            String message = "ข่าว 57 : มท1.สั่งย้ายผู้ว่าแม่ฮ่องสอน : ตัดต่อเสร็จแล้ว";
            String sender = "THAIBULKSMS";

  
// http://www.thsms.com/api/rest?method=send&username=lunar11120&password=2defc2&from=0000&to=0851560735&message=WAHT_SUPP          

            String requestUrl2 = "http://www.thsms.com/api/rest?method=send"
                    + "&username=" + URLEncoder.encode(username, "UTF-8")
                    + "&password=" + URLEncoder.encode(password, "UTF-8")
                    + "&from=" + URLEncoder.encode(from, "UTF-8")
                    + "&to=" + URLEncoder.encode(to, "UTF-8")
                    + "&message=" + URLEncoder.encode(message, "UTF-8");

            URL url = new URL(requestUrl2);

            HttpURLConnection uc = (HttpURLConnection) url.openConnection();

            System.out.println(uc.getResponseMessage());

            uc.disconnect();

        } catch (Exception ex) {

            System.out.println(ex.getMessage());

        }

    }

}



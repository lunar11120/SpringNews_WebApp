/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springnews.model;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 *
 * @author amdb2
 */
public class SMS_send_to_THSMS {
    public static void send_SMS_NOW(int reporterid,int newsid){
        
            String receiver_telephone = News.findTelephone_Number(reporterid);
            String newstitle = News.findNewsTitle(newsid);
            String message01 = "ข่าว "+newsid+" : "+newstitle+" : ตัดต่อเสร็จเรียบร้อย";
        
            try {

            String username = "lunar11120";
            String password = "2defc2";
            String from = "SMS";
            String to = receiver_telephone;
            String message = message01;

  
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
            
                System.out.println("SMS sending to Receiver NOW.");
            
            

        } catch (Exception ex) {

            System.out.println("SMS error"+ex.getMessage());

        }
    
    
    }
    
}

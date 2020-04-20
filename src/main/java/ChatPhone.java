import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import redis.clients.jedis.Jedis;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ChatPhone {
    private String url;
    private int port;
    private String pwd;
    private Map<String,Integer> map;

    public String getUrl() {
        return url;
    }

    public int getPort() {
        return port;
    }

    public ChatPhone(String url, int port){
        this.url=url;
        this.port=port;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void getChat(String value){
        String[] values=value.split(",");
        String[] ip=values[2].split(":");
        String[] phone=values[3].split(":");
        String[] number=values[4].split(":");
        map=new HashMap();
        map.put(phone[1],Integer.valueOf(number[1]));
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        ChatPhone chatPhone=new ChatPhone("xxx",6379);
        chatPhone.setPwd("mbase:phoneCaptcha:");
        Jedis jds= new Jedis(chatPhone.url,chatPhone.port);
//        jds.auth(chatPhone.getPwd());
        Set<String> keys= jds.keys("mbase:*");
        if (keys.size()==0)
            System.out.println("no meassage!");

        for(String key:keys) {
            String value = jds.get(key);

            value=value.replace("{","[");
            value=value.replace("}","]");
            String utf8val = new String(value.getBytes("utf-8"), "utf-8");
            JSONArray jsonAry = JSONArray.fromObject(utf8val);
            for (int i = 0; i < jsonAry.size(); i++) {
                Map map = (Map) JSONObject.toBean((JSONObject) jsonAry.get(i), HashMap.class);
                if (null == map.get("ip"))
                    System.out.println("no message");
                if ("192.168.1.1" == map.get("ip"))
                    System.out.println(map.get("phoneCaptcha"));
            }
        }
//        String ping = jds.ping();

        jds.close();
    }

}
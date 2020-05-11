import redis.clients.jedis.Jedis;

import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class schmsg extends TimerTask {
    private static Jedis jds;
    @Override
    public void run() {

//        jds.auth(chatPhone.getPwd());
        Set<String> keys= jds.keys("mbase:*");
        for(String key:keys) {
            if(key==null){
                System.out.println("no message!");
            }
            System.out.println(jds.get(key));
//            set.add(key);
        }

    }

    public static void main(String[] args){
        ChatPhone chatPhone=new ChatPhone("wsd-projecta.master.redis.pre.dba.unp.oyw",6379);
        chatPhone.setPwd("mbase:phoneCaptcha:");
        jds= new Jedis(chatPhone.getUrl(),chatPhone.getPort());
        Timer t=new Timer();
        t.scheduleAtFixedRate(new schmsg(),1200,1000);
    }
}

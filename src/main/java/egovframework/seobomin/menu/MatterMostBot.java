package egovframework.seobomin.menu;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;

import org.junit.jupiter.api.Test;

import net.bis5.mattermost.client4.ApiResponse;
import net.bis5.mattermost.client4.MattermostClient;
import net.bis5.mattermost.model.Channel;
import net.bis5.mattermost.model.Post;
import net.bis5.mattermost.model.User;


public class MatterMostBot {

    private static MatterMostBot singleton = new MatterMostBot();
    public MatterMostBot() {
        System.out.println("MatterMostBot Instance Created..");
    }
    public static MatterMostBot getInstance() {
        return singleton;
    }

    String matterMostUrl = "https://mm.fusionsoft.co.kr";
    String accessToken = "t9knjh7qwbrfiydf3i9eonwxso";

    @SuppressWarnings("resource")
    //@Test
    public synchronized void sendMessage(String userId,  String message){
        SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm");

        Date time = new Date();
        String curTime = format1.format(time);
        

        // Create client instance
        MattermostClient client = null;
        try{
            // case 1. use constructor - log disable and prohibit unknown properties
            client = new MattermostClient(matterMostUrl); //mattermost 주소
            
            // case 2. use builder
            client = MattermostClient.builder()
                .url(matterMostUrl) //mattermost 주소
                .logLevel(Level.INFO)
                .ignoreUnknownProperties()
                .build();
            
            client.setAccessToken(accessToken); // 보내는 Bot의 Access 토큰 (변경x)
            
            ApiResponse<User> userinfo1 = client.getUserByUsername("remindbot");  // 보내는 Bot의 이름 (변경x)
            String toUserId = userinfo1.readEntity().getId();
            
            ApiResponse<User> userinfo2 = client.getUserByUsername(userId);  // 받는사람 이름 / 로그인 할때 아이디 (수신자)
            String fromUserId = userinfo2.readEntity().getId();
            
            // 사용자 1 , 사용자 2 의 아이디 (데이터베이스에 있을것으로 예상 userId)  -> 사용자 1의 경우 BOT 계정 생성 후 그 계정을 하드코딩 하여도 괜찮을것같음.
            ApiResponse<Channel> channelInfo = client.createDirectChannel(toUserId,fromUserId);  
            
            String channelId = channelInfo.readEntity().getId(); // 채널아이디 
            
            // 메시지 전송 
            Post post = new Post();
            post.setChannelId(channelId);
            post.setMessage("@"+userId+" "+message);  //메시지 내용
            client.createPost(post);
            // 메시지 전송 끝
            
            client.close();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            client.close();
        }
    }
}
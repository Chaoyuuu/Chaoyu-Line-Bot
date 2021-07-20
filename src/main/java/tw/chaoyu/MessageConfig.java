package tw.chaoyu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tw.chaoyu.messageHandler.MessageHandler;
import tw.chaoyu.messageHandler.StoryHandler;

import static tw.chaoyu.messageHandler.MessageHandler.dummy;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
@Configuration
public class MessageConfig {

    @Bean
    public MessageHandler getMessageHandler() {
        return new StoryHandler(dummy());
    }
}

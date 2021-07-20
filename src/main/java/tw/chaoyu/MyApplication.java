package tw.chaoyu;

import com.linecorp.bot.model.ReplyMessage;
import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.StickerMessageContent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.StickerMessage;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

import static tw.chaoyu.GreetingMessage.*;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
@SpringBootApplication
@LineMessageHandler
public class MyApplication {

    private final MessageHandler messageHandler = new StoryHandler(null);
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

    @EventMapping
    public ReplyMessage handleTextMessageEvent(MessageEvent<TextMessageContent> event) {
        System.out.println("event: " + event);
        final String originalMessageText = event.getMessage().getText();
        List<Message> messages = new ArrayList<>();
        messages.add(new TextMessage(originalMessageText));
        messages.add(new StickerMessage("789", "10856"));
        System.out.println("event: " + event);
        return new ReplyMessage(event.getReplyToken(), messages);
    }

    @EventMapping
    public Message handleStickerMessageEvent(MessageEvent<StickerMessageContent> event) {
        System.out.println("event: " + event);
        return getGreetingMessage();
    }

    @EventMapping
    public void handleDefaultMessageEvent(Event event) {
        System.out.println("event: " + event);
    }
}

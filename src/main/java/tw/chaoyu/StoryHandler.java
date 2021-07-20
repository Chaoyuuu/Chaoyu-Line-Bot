package tw.chaoyu;

import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
public class StoryHandler extends MessageHandler {
    public static final String storyText = "Tell me your story";

    public StoryHandler(MessageHandler next) {
        super(next);
    }

    @Override
    public boolean isTargetText(String text) {
        return storyText.equals(text);
    }

    @Override
    public Message getMessage() {
        return TextMessage.builder()
                .text("Here is my story !")
                .build();
    }
}

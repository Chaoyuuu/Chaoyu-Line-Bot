package tw.chaoyu.messageHandler;

import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.StickerMessage;
import com.linecorp.bot.model.message.TextMessage;

import java.util.Arrays;
import java.util.List;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
public class StoryHandler extends MessageHandler {
    public static final String TELL_ME_YOUR_STORY = "Tell me your story";

    public StoryHandler(MessageHandler next) {
        super(next);
    }

    @Override
    public boolean isTargetText(String text) {
        return TELL_ME_YOUR_STORY.equals(text);
    }

    @Override
    public List<Message> getMessages() {
        return Arrays.asList(
                new TextMessage("Here is my story !"),
                new StickerMessage("789", "10856")
        );
    }
}

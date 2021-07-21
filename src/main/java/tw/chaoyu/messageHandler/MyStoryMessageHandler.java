package tw.chaoyu.messageHandler;

import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.StickerMessage;
import com.linecorp.bot.model.message.TextMessage;

import java.util.Arrays;
import java.util.List;

import static tw.chaoyu.utils.Utils.getEmoji;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
public class MyStoryMessageHandler extends MessageHandler {
    public static final String TELL_ME_YOUR_STORY = "Tell me your story !";

    public MyStoryMessageHandler(MessageHandler next) {
        super(next);
    }

    @Override
    public boolean isTargetText(String text) {
        return TELL_ME_YOUR_STORY.equals(text);
    }

    @Override
    public List<Message> getMessages() {
        return Arrays.asList(
                getMyStoryMessage(),
                getStickerMessage()
        );
    }

    private Message getMyStoryMessage() {
        String myStory = "I major in computer science at NTU. " +
                "I always keep polishing my skills by participating in open-source projects. $ $\n\n" +
                "Apart from being a programmer, I’m also an aggressive learner practicing product design and other " +
                "non-coding skills (e.g., Domain-Driven design). ";

        return TextMessage.builder()
                .text(myStory)
                .emojis(getEmojis())
                .build();
    }

    private List<TextMessage.Emoji> getEmojis() {
        String birthDayPackage = "5ac2213e040ab15980c9b447";
        String sparkle = "085";

        return Arrays.asList(
                getEmoji(112, birthDayPackage, sparkle),
                getEmoji(114, birthDayPackage, sparkle)
        );
    }

    private Message getStickerMessage() {
        String sallySpecialEditionStickerPackage = "789";
        String redHeartSally = "10856";
        return new StickerMessage(sallySpecialEditionStickerPackage, redHeartSally);
    }
}

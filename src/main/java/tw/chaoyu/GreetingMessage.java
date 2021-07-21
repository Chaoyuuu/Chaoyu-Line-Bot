package tw.chaoyu;

import com.linecorp.bot.model.action.MessageAction;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.message.quickreply.QuickReply;
import com.linecorp.bot.model.message.quickreply.QuickReplyItem;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import static com.linecorp.bot.model.message.TextMessage.Emoji;
import static tw.chaoyu.messageHandler.EngineerMessageHandler.ARE_YOU_AN_ENGINEER;
import static tw.chaoyu.messageHandler.MyStoryMessageHandler.TELL_ME_YOUR_STORY;
import static tw.chaoyu.utils.Utils.getEmoji;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
public class GreetingMessage {

    public static Message getGreetingMessage() {
        return new GreetingMessage().getMessage();
    }

    public Message getMessage() {
        String greeting = "Hi, I'm Chaoyu Lee.$\n" +
                "You are welcome to ask me some questions here!\nLet's have a fun! $$";

        return TextMessage.builder()
                .text(greeting)
                .emojis(getEmojis())
                .quickReply(getQuickReply())
                .build();
    }

    private List<Emoji> getEmojis() {
        String lineEmojiPackage = "5ac1bfd5040ab15980c9b435";
        String blushingBrown = "088";
        String smilingFace = "008";
        String birthDayPackage = "5ac223c6040ab15980c9b44a";
        String beer = "136";

        return Arrays.asList(
                getEmoji(19, lineEmojiPackage, blushingBrown),
                getEmoji(86, birthDayPackage, beer),
                getEmoji(87, lineEmojiPackage, smilingFace)
        );
    }

    private QuickReply getQuickReply() {
        return QuickReply.items(getQuickReplyItems());
    }

    private List<QuickReplyItem> getQuickReplyItems() {
        String redHeartUri = "https://i.imgur.com/EL9vLaA.png";
        String cursor = "https://i.imgur.com/SInJogx.png";

        return Arrays.asList(
                QuickReplyItem.builder()
                        .imageUrl(URI.create(redHeartUri))
                        .action(new MessageAction(TELL_ME_YOUR_STORY, TELL_ME_YOUR_STORY))
                        .build(),
                QuickReplyItem.builder()
                        .imageUrl(URI.create(cursor))
                        .action(new MessageAction(ARE_YOU_AN_ENGINEER, ARE_YOU_AN_ENGINEER))
                        .build()
        );
    }
}

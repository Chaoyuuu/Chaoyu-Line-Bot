package tw.chaoyu;

import com.linecorp.bot.model.action.MessageAction;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.quickreply.QuickReply;
import com.linecorp.bot.model.message.quickreply.QuickReplyItem;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import static com.linecorp.bot.model.message.TextMessage.Emoji;
import static com.linecorp.bot.model.message.TextMessage.builder;
import static tw.chaoyu.messageHandler.EngineerHandler.ARE_YOU_AN_ENGINEER;
import static tw.chaoyu.messageHandler.StoryHandler.TELL_ME_YOUR_STORY;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
public class GreetingMessage {

    public static Message getGreetingMessage() {
        return new GreetingMessage().getMessage();
    }

    public Message getMessage() {
        String greeting = "Hi, I'm Chaoyu Lee.$\n" +
                "You can ask me some questions in here! Let's have a fun!$$";

        return builder()
                .text(greeting)
                .emojis(getEmojis())
                .quickReply(getQuickReply())
                .build();
    }

    private List<Emoji> getEmojis() {
        return Arrays.asList(
                getEmoji(19, "5ac1bfd5040ab15980c9b435", "088"),
                getEmoji(77, "5ac223c6040ab15980c9b44a", "136"),
                getEmoji(78, "5ac1bfd5040ab15980c9b435", "008")
        );
    }

    private Emoji getEmoji(int index, String productID, String emojiID) {
        return Emoji.builder()
                .index(index)
                .productId(productID)
                .emojiId(emojiID)
                .build();
    }

    private QuickReply getQuickReply() {
        return QuickReply.items(getQuickReplyItems());
    }

    private List<QuickReplyItem> getQuickReplyItems() {
        return Arrays.asList(
                QuickReplyItem.builder()
                        .imageUrl(URI.create("https://i.imgur.com/EL9vLaA.png"))
                        .action(new MessageAction(TELL_ME_YOUR_STORY, TELL_ME_YOUR_STORY))
                        .build(),
                QuickReplyItem.builder()
                        .imageUrl(URI.create("https://i.imgur.com/SInJogx.png"))
                        .action(new MessageAction(ARE_YOU_AN_ENGINEER, ARE_YOU_AN_ENGINEER))
                        .build()
        );
    }
}

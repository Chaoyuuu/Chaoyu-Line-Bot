package tw.chaoyu;

import com.linecorp.bot.model.action.MessageAction;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.quickreply.QuickReply;
import com.linecorp.bot.model.message.quickreply.QuickReplyItem;
import lombok.SneakyThrows;

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
        String greeting = "Hi, I'm Chaoyu Lee.$";
//                "I’m familiar with web development under Spring boot/react, have hands-on experience with containerized technology and especially Drone CI/CD. I’m also an aggressive learner practicing product design and other non-coding skills (e.g., Domain- Driven design). I consider myself a productive and good-at-cooperation teammate who really helps.\n\n" +
//                "You can ask me some questions in here! $\nLet's have a fun!$";

        return builder()
                .text(greeting)
                .emojis(getEmojis())
                .quickReply(getQuickReply())
                .build();
    }

    private List<Emoji> getEmojis() {
        return Arrays.asList(
                getEmoji(19, "5ac21c46040ab15980c9b442", "024")
//                getEmoji(425, "5ac2213e040ab15980c9b447", "153"),
//                getEmoji(445, "5ac2213e040ab15980c9b447", "161")
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

    @SneakyThrows
    private List<QuickReplyItem> getQuickReplyItems() {
        return Arrays.asList(
                QuickReplyItem.builder()
                        .imageUrl(new URI("https://icons8.github.io/flat-color-icons/svg/like.svg"))
                        .action(new MessageAction(TELL_ME_YOUR_STORY, TELL_ME_YOUR_STORY))
                        .build(),
                QuickReplyItem.builder()
                        .imageUrl(new URI("https://icons8.github.io/flat-color-icons/svg/services.svg"))
                        .action(new MessageAction(ARE_YOU_AN_ENGINEER, ARE_YOU_AN_ENGINEER))
                        .build()
        );
    }
}

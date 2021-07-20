package tw.chaoyu;

import com.linecorp.bot.model.action.MessageAction;
import com.linecorp.bot.model.action.PostbackAction;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.message.quickreply.QuickReply;
import com.linecorp.bot.model.message.quickreply.QuickReplyItem;
import lombok.SneakyThrows;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
public class GreetingMessage {

    public static Message getGreetingMessage() {
        return new GreetingMessage().getMessage();
    }

    @SneakyThrows
    public Message getMessage() {
        final QuickReply quickReply = QuickReply.items(getQuickReplyItems());
        String greeting = "Hi, I'm Chaoyu Lee. You can ask me some questions in here. Let's have a fun!";

        return TextMessage
                .builder()
                .text(greeting)
                .quickReply(quickReply)
                .build();

    }

    private List<QuickReplyItem> getQuickReplyItems() throws Exception {
        return Arrays.asList(
                QuickReplyItem.builder()
                        .imageUrl(new URI("https://icons8.github.io/flat-color-icons/svg/like.svg"))
                        .action(new MessageAction("story", "Tell me your story"))
                        .build(),
                QuickReplyItem.builder()
                        .imageUrl(new URI("https://icons8.github.io/flat-color-icons/svg/services.svg"))
                        .action(new MessageAction("job", "Are you an engineer?"))
                        .build(),
                QuickReplyItem.builder()
                        .action(PostbackAction.builder()
                                .label("PostbackAction")
                                .text("PostbackAction clicked")
                                .data("{PostbackAction: true}")
                                .build())
                        .build()
        );
    }
}

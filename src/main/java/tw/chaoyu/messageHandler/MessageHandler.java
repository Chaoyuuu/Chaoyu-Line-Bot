package tw.chaoyu.messageHandler;

import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;
import lombok.AllArgsConstructor;

import java.util.List;

import static java.util.Collections.singletonList;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
@AllArgsConstructor
public abstract class MessageHandler {
    private final MessageHandler next;

    public abstract boolean isTargetText(String text);

    public abstract List<Message> getMessages();

    public List<Message> response(String text) {
        if (isTargetText(text)) {
            return getMessages();
        } else {
            return next.response(text);
        }
    }

    public static MessageHandler dummy() {
        return new MessageHandler(null) {
            @Override
            public boolean isTargetText(String text) {
                return true;
            }

            @Override
            public List<Message> getMessages() {
                return singletonList(new TextMessage("Hello, I'm Chaoyu Lee. :D"));
            }
        };
    }
}

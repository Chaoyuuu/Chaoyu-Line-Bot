package tw.chaoyu;

import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
public abstract class MessageHandler {
    private final MessageHandler next;

    protected MessageHandler(MessageHandler next) {
        this.next = next;
    }

    public abstract boolean isTargetText(String text);
    public abstract Message getMessage();

    public Message response(String text) {
        if (isTargetText(text)) {
            return next.response(text);
        } else {
            return getMessage();
        }
    }

    public static MessageHandler dummy() {
        return new MessageHandler(null) {
            @Override
            public boolean isTargetText(String text) {
                return false;
            }

            @Override
            public Message getMessage() {
                return new TextMessage("Hello");
            }
        };
    }
}

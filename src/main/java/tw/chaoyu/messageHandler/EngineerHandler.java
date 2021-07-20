package tw.chaoyu.messageHandler;

import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
public class EngineerHandler extends MessageHandler {
    public static final String engineerText = "Are you an engineer?";

    protected EngineerHandler(MessageHandler next) {
        super(next);
    }

    @Override
    public boolean isTargetText(String text) {
        return engineerText.equals(text);
    }

    @Override
    public Message getMessage() {
        return TextMessage.builder()
                .text("Yes !")
                .build();
    }
}

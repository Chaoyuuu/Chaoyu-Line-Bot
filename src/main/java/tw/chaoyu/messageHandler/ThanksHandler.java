package tw.chaoyu.messageHandler;

import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.StickerMessage;

import java.util.Collections;
import java.util.List;

import static java.util.Collections.singletonList;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
public class ThanksHandler extends MessageHandler {
    public static final String YOU_DID_A_GOOD_JOB = "You did a good job!";

    public ThanksHandler(MessageHandler next) {
        super(next);
    }

    @Override
    public boolean isTargetText(String text) {
        return YOU_DID_A_GOOD_JOB.equals(text);
    }

    @Override
    public List<Message> getMessages() {
        String lineCharactersPrettyPhrasesStickerPackage = "8522";
        String thankYou = "16581267";
        return singletonList(new StickerMessage(lineCharactersPrettyPhrasesStickerPackage, thankYou));
    }
}

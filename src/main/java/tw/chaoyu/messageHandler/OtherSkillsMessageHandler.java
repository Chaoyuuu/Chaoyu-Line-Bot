package tw.chaoyu.messageHandler;

import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.singletonList;
import static tw.chaoyu.utils.Utils.getEmoji;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
public class OtherSkillsMessageHandler extends MessageHandler {
    public static final String WHAT_ARE_YOUR_SKILLS = "What are your other skills?";

    public OtherSkillsMessageHandler(MessageHandler next) {
        super(next);
    }

    @Override
    public boolean isTargetText(String text) {
        return WHAT_ARE_YOUR_SKILLS.equals(text);
    }

    @Override
    public List<Message> getMessages() {
        return singletonList(getMySkillsMessage());
    }

    private Message getMySkillsMessage() {
        String mySkills = "I’m familiar with web development under Spring boot/react. $\n" +
                "I also have hands-on experience with containerized technology and especially Drone CI/CD. $";

        return TextMessage.builder()
                .text(mySkills)
                .emojis(getEmojis())
                .build();
    }

    private List<TextMessage.Emoji> getEmojis() {
        String gestureEmoji = "5ac21e6c040ab15980c9b444";
        String thumb = "002";
        String clapHand = "036";

        return Arrays.asList(
                getEmoji(59, gestureEmoji, thumb),
                getEmoji(151, gestureEmoji, clapHand)
        );
    }
}

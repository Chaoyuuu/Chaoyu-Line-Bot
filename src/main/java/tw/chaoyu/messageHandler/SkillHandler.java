package tw.chaoyu.messageHandler;

import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;

import java.util.Collections;
import java.util.List;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
public class SkillHandler extends MessageHandler {
    public static final String WHAT_ARE_YOUR_SKILLS = "What are your skills?";

    public SkillHandler(MessageHandler next) {
        super(next);
    }

    @Override
    public boolean isTargetText(String text) {
        return WHAT_ARE_YOUR_SKILLS.equals(text);
    }

    @Override
    public List<Message> getMessages() {
        return Collections.singletonList(new TextMessage("I’m familiar with web development under Spring boot/react, have hands-on experience with containerized technology and especially Drone CI/CD :D"));
    }
}

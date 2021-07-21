package tw.chaoyu.messageHandler;

import com.linecorp.bot.model.action.MessageAction;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.StickerMessage;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.message.quickreply.QuickReply;
import com.linecorp.bot.model.message.quickreply.QuickReplyItem;
import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.List;

import static tw.chaoyu.messageHandler.OtherSkillsMessageHandler.WHAT_ARE_YOUR_SKILLS;
import static tw.chaoyu.messageHandler.ProjectsHandler.MORE_ABOUT_PROJECTS;
import static tw.chaoyu.messageHandler.ThankYouMessageHandler.YOU_DID_A_GOOD_JOB;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
public class EngineerMessageHandler extends MessageHandler {
    public static final String ARE_YOU_AN_ENGINEER = "Are you an engineer?";

    public EngineerMessageHandler(MessageHandler next) {
        super(next);
    }

    @Override
    public boolean isTargetText(String text) {
        return ARE_YOU_AN_ENGINEER.equals(text);
    }

    @Override
    public List<Message> getMessages() {
        String moonSpecialEditionStickerPackage = "1070";
        String cryingLaughingFace = "17844";
        return Arrays.asList(
                new StickerMessage(moonSpecialEditionStickerPackage, cryingLaughingFace),
                getQuickReplyMessage()
        );
    }

    private Message getQuickReplyMessage() {
        String responseMessage = "Yes! I'm a software engineer. " +
                "I specialize in Java and Object-Oriented Design. " +
                "With the rich team-working experience, " +
                "I consider myself a productive and good-at-cooperation teammate who really helps. " +
                "Click the buttons below and get more information about me!";

        return TextMessage
                .builder()
                .text(responseMessage)
                .quickReply(getQuickReply())
                .build();
    }

    private QuickReply getQuickReply() {
        return QuickReply.items(getQuickReplyItems());
    }

    @SneakyThrows
    private List<QuickReplyItem> getQuickReplyItems() {
        return Arrays.asList(
                QuickReplyItem.builder()
                        .action(new MessageAction("Other skills?", WHAT_ARE_YOUR_SKILLS))
                        .build(),
                QuickReplyItem.builder()
                        .action(new MessageAction("More about projects", MORE_ABOUT_PROJECTS))
                        .build(),
                QuickReplyItem.builder()
                        .action(new MessageAction("Good Job!", YOU_DID_A_GOOD_JOB))
                        .build()
        );
    }
}

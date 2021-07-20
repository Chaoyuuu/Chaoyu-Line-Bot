package tw.chaoyu.messageHandler;

import com.linecorp.bot.model.action.MessageAction;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.StickerMessage;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.message.quickreply.QuickReply;
import com.linecorp.bot.model.message.quickreply.QuickReplyItem;
import lombok.SneakyThrows;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import static tw.chaoyu.messageHandler.ExperienceHandler.WHAT_IS_YOUR_EXPERIENCE;
import static tw.chaoyu.messageHandler.SkillHandler.WHAT_ARE_YOUR_SKILLS;
import static tw.chaoyu.messageHandler.ThanksHandler.YOU_DID_A_GOOD_JOB;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
public class EngineerHandler extends MessageHandler {
    public static final String ARE_YOU_AN_ENGINEER = "Are you an engineer?";

    public EngineerHandler(MessageHandler next) {
        super(next);
    }

    @Override
    public boolean isTargetText(String text) {
        return ARE_YOU_AN_ENGINEER.equals(text);
    }

    @Override
    public List<Message> getMessages() {
        return Arrays.asList(
                new StickerMessage("1070", "17844"),
                getQuickReplyMessage()
        );
    }

    @SneakyThrows
    private Message getQuickReplyMessage() {
        final QuickReply quickReply = QuickReply.items(getQuickReplyItems());
        String greeting = "Yes!";

        return TextMessage
                .builder()
                .text(greeting)
                .quickReply(quickReply)
                .build();
    }

    private List<QuickReplyItem> getQuickReplyItems() throws Exception {
        return Arrays.asList(
                QuickReplyItem.builder()
                        .imageUrl(URI.create("https://icons8.github.io/flat-color-icons/svg/like.svg"))
                        .action(new MessageAction("Skills?", WHAT_ARE_YOUR_SKILLS))
                        .build(),
                QuickReplyItem.builder()
                        .imageUrl(URI.create("https://icons8.github.io/flat-color-icons/svg/like.svg"))
                        .action(new MessageAction("Experience?", WHAT_IS_YOUR_EXPERIENCE))
                        .build(),
                QuickReplyItem.builder()
                        .imageUrl(URI.create("https://icons8.github.io/flat-color-icons/svg/services.svg"))
                        .action(new MessageAction("Good Job!", YOU_DID_A_GOOD_JOB))
                        .build()
        );
    }
}

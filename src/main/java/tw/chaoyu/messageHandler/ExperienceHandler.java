package tw.chaoyu.messageHandler;

import com.linecorp.bot.model.action.URIAction;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TemplateMessage;
import com.linecorp.bot.model.message.template.CarouselColumn;
import com.linecorp.bot.model.message.template.CarouselTemplate;
import com.linecorp.bot.model.message.template.Template;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.singletonList;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
public class ExperienceHandler extends MessageHandler {
    public static final String WHAT_IS_YOUR_EXPERIENCE = "What is your experience?";

    public ExperienceHandler(MessageHandler next) {
        super(next);
    }

    @Override
    public boolean isTargetText(String text) {
        return WHAT_IS_YOUR_EXPERIENCE.equals(text);
    }

    @Override
    public List<Message> getMessages() {
        return singletonList(new TemplateMessage("altText", getCarouselTemplate()));
    }

    private Template getCarouselTemplate() {
        return CarouselTemplate.builder().columns(getCarouselColumns()).build();
    }

    private List<CarouselColumn> getCarouselColumns() {
        return Arrays.asList(
                new CarouselColumn(
                        URI.create("https://avatars.githubusercontent.com/u/61681944?s=200&v=4"),
                        "Judge Girl", "This is a Cloud-Native Online Judge System",
                        singletonList(getUriAction("GitHub", "https://github.com/Judge-Girl"))),
                new CarouselColumn(
                        URI.create("https://avatars.githubusercontent.com/u/72117984?s=200&v=4"),
                        "Spring Cloud in Python", "Reverse-engineering over Spring-Cloud into Python",
                        singletonList(getUriAction("GitHub", "https://github.com/Spring-Cloud-In-Python/Spring-Cloud-in-Python"))),
                new CarouselColumn(
                        URI.create("https://avatars.githubusercontent.com/u/72117984?s=200&v=4"),
                        "Chinese Chess", "A Chinese Chess is written under TDD and designed with OOA/D",
                        singletonList(getUriAction("GitHub", "https://github.com/Chaoyuuu/ChineseChess"))));
    }

    private URIAction getUriAction(String title, String uri) {
        return new URIAction(title,
                URI.create(uri), null);
    }
}

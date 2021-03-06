package tw.chaoyu.messageHandler;

import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TemplateMessage;
import com.linecorp.bot.model.message.template.CarouselColumn;
import com.linecorp.bot.model.message.template.CarouselTemplate;
import com.linecorp.bot.model.message.template.Template;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.singletonList;
import static tw.chaoyu.utils.Utils.getUriAction;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
public class ProjectMessageHandler extends MessageHandler {
    public static final String MORE_ABOUT_PROJECTS = "More about projects";

    public ProjectMessageHandler(MessageHandler next) {
        super(next);
    }

    @Override
    public boolean isTargetText(String text) {
        return MORE_ABOUT_PROJECTS.equals(text);
    }

    @Override
    public List<Message> getMessages() {
        return singletonList(new TemplateMessage("Here are my projects~", getCarouselTemplate()));
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
                        URI.create("https://i.imgur.com/cqjMtIh.png"),
                        "Chinese Chess", "A Chinese Chess is written under TDD and designed with OOA/D",
                        singletonList(getUriAction("GitHub", "https://github.com/Chaoyuuu/ChineseChess"))));
    }
}

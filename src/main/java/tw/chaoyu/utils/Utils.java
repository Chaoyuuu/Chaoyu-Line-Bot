package tw.chaoyu.utils;

import com.linecorp.bot.model.action.URIAction;

import java.net.URI;

import static com.linecorp.bot.model.message.TextMessage.Emoji;

/**
 * @author chaoyulee chaoyu2330@gmail.com
 */
public class Utils {
    public static Emoji getEmoji(int index, String productID, String emojiID) {
        return Emoji.builder()
                .index(index)
                .productId(productID)
                .emojiId(emojiID)
                .build();
    }

    public static URIAction getUriAction(String title, String uri) {
        return new URIAction(title, URI.create(uri), null);
    }
}

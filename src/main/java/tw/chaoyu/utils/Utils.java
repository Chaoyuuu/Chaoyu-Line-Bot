package tw.chaoyu.utils;

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
}

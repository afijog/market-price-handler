package marketprice.fx.service.broker;

import marketprice.fx.model.Price;
import marketprice.fx.service.feed.FXSubscriber;
import marketprice.fx.service.feed.FxPriceFeed;
import marketprice.fx.service.parser.FXPriceParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.UnaryOperator;

/**
 * The broker to get data from feed, adjust prices and expose them to other modules
 */
@Service
public class Broker implements FXSubscriber {
    /**
     * Dependency injection of the parser.
     * Used to parse the messages coming from the feed
     */
    @Autowired
    private FXPriceParser fxPriceParser;

    /**
     * Dependency injection of feed
     */
    @Autowired
    private FxPriceFeed feed;

    /**
     * After construction of the object subscribe to the feed in order to get messages
     */
    @PostConstruct
    public void subscribe() {
        feed.subscribe(this);
    }

    /**
     * Map (instrument name, price) to store price information
     */
    private final Map<String, Price> prices = new HashMap<>();

    UnaryOperator<Price> adjustmentLogic = price ->
            price
                .setBid(price.getBid() /  1.01)
                .setAsk(price.getAsk() *  1.01);

    /**
     * Method to handle the messages that the feed object is sending after subscribing
     * @param msg The message
     */
    @Override
    public void onMessage(String msg) {
        Price price = fxPriceParser.parse(msg);
        // TODO Modify in place. Perhaps it is better to have immutable data
        Price adjustedPriced = adjustmentLogic.apply(price);
        prices.put(price.getName(), adjustedPriced);
    }

    /**
     * Returns optional (perhaphs we do not have information about that instrument) with the price
     * @param name The name of the instrument
     * @return An optional
     */
    public Optional<Price> getPrice(String name) {
        Price price = prices.get(name);
        return Optional.ofNullable(price);
    }
}

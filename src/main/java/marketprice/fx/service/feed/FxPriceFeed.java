package marketprice.fx.service.feed;

import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Class to retrieve feed data
 */
@Service
public class FxPriceFeed {
    /**
     * Subscribers information as a set of FXSubscriber
     */
    private final Set<FXSubscriber> subscribers = new HashSet<>();

    private final List<String> data = new ArrayList<>();

    /**
     * Public basic constructor
     */
    public FxPriceFeed() {
        getData()
                .forEach(this::addPrice);
    }

    /**
     * Returns the messages
     * @return The list of messages
     */
    // TODO Read a file or access a webservice to have dynamic data
    private List<String> getData() {
        return Arrays.asList(
                "106, EUR/USD, 1.1000,1.2000,01-06-2020 12:01:01:001",
                "107, EUR/JPY, 119.60,119.90,01-06-2020 12:01:02:002",
                "108, GBP/USD, 1.2500,1.2560,01-06-2020 12:01:02:002",
                "109, GBP/USD, 1.2499,1.2561,01-06-2020 12:01:02:100",
                "110, EUR/JPY, 119.61,119.91,01-06-2020 12:01:02:110");
    }

    protected void addPrice(String price) {
        data.add(price);
        subscribers.forEach(subscriber -> subscriber.onMessage(price));
    }

    public void subscribe(FXSubscriber subscriber) {
        subscribers.add(subscriber);

        data
            .stream()
            .forEach(subscriber::onMessage);
    }
}

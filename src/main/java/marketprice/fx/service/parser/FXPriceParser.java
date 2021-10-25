package marketprice.fx.service.parser;

import marketprice.fx.model.Price;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Class to parse FX price messages
 */
@Service
public class FXPriceParser {

    /**
     * Formatter for the timestamp
     */
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss:SSS");

    // Sample line
    // 106, EUR/USD, 1.1000,1.2000,01-06-2020 12:01:01:001
    // TODO Wrap the result in an effect (Optional, for instance) of price in case the message can not be parsed
    public Price parse(String line) {
        String[] data = line.split(",");

        long id = Long.parseLong(data[0].trim());
        String name = data[1].trim();

        double bid = Double.parseDouble(data[2].trim());
        double ask = Double.parseDouble(data[3].trim());

        LocalDateTime timestamp = LocalDateTime.parse(data[4].trim(), DATE_TIME_FORMATTER);
        return new Price(id, name, bid, ask, timestamp);
    }
}

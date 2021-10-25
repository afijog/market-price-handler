package marketprice.fx.service.parser;

import marketprice.fx.model.Price;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FXPriceParserTest {
    FXPriceParser parser = new FXPriceParser();

    @Test
    public void testParsePrice() {
        String msg = "106, EUR/USD, 1.1000,1.2000,01-06-2020 12:01:01:001";
        Price price = parser.parse(msg);

        assertEquals(106, price.getId());
        assertEquals("EUR/USD", price.getName());
        assertEquals(1.1000, price.getBid());
        assertEquals(1.2000, price.getAsk());
    }
}
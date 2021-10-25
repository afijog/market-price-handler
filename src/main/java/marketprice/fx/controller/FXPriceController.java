package marketprice.fx.controller;

import marketprice.fx.model.Price;
import marketprice.fx.service.broker.Broker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Expose price information as a REST service
 * http://localhost:8080/price/EUR-USD
 */
@RestController
@RequestMapping("price")
public class FXPriceController {

    /**
     * Dependency injection of broker
     */
    @Autowired
    private Broker broker;

    @GetMapping(value = "/{name}", produces = "application/json")
    public @ResponseBody Optional<Price> getPrice(@PathVariable("name") String name) {
        return broker.getPrice(sanitiseInputName(name));
    }

    /**
     * Cleans the input name changing "-" by "/", as "/" is not a 'valid' character in URLs
     * @param name The instrument name
     * @return The sanitised instrument name
     */
    private String sanitiseInputName(String name) {
        return name.replace("-", "/");
    }
}

package marketprice.fx.model;

import java.time.LocalDateTime;

/**
 * Basic object to store price information (mimics information of Feed messages)
 */
// TODO Improve class with Lombok project to avoid constructor, getter and setters boilerplate
public class Price {
    private long id;
    private String name;
    private double bid;
    private double ask;
    private LocalDateTime timestamp;

    public Price(long id, String name, double bid, double ask, LocalDateTime timestamp) {
        this.id = id;
        this.name = name;
        this.bid = bid;
        this.ask = ask;
        this.timestamp = timestamp;
    }

    public long getId() {
        return id;
    }

    public Price setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Price setName(String name) {
        this.name = name;
        return this;
    }

    public double getBid() {
        return bid;
    }

    public Price setBid(double bid) {
        this.bid = bid;
        return this;
    }

    public double getAsk() {
        return ask;
    }

    public Price setAsk(double ask) {
        this.ask = ask;
        return this;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Price setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }
}

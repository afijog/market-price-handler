package marketprice.fx.service.feed;

/**
 * Public interface for subscribers of FX price messages
 */
public interface FXSubscriber {
    void onMessage(String msg);
}

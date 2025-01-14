package it.unibo.pyxis.model.event.notify;

import it.unibo.pyxis.model.element.powerup.Powerup;
import it.unibo.pyxis.model.event.Event;

/**
 * Event fired when a {@link Powerup} is activated.
 */
@FunctionalInterface
public interface PowerupActivationEvent extends Event {
    /**
     * Returns the instance of the {@link Powerup} that has been activated.
     *
     * @return The instance of activated {@link Powerup}.
     */
    Powerup getPowerup();
}

package it.unibo.pyxis.model.level;

import it.unibo.pyxis.model.arena.Arena;
import it.unibo.pyxis.model.event.notify.DecreaseLifeEvent;

public interface Level {
    /**
     * Decrease a life.
     */
    void decreaseLife();

    /**
     * Return the total number of lifes.
     * @return
     *          The number of current lifes
     */
    int getLives();

    /**
     * Return the total score of this level.
     * @return
     *         The score
     */
    int getScore();

    /**
     * Get the {@link Arena} associated to this level.
     * @return
     *          The instance of {@link Arena}
     */
    Arena getArena();

    void handleDecreaseLife(DecreaseLifeEvent event);
}
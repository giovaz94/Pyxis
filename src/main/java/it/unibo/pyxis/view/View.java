package it.unibo.pyxis.view;

import it.unibo.pyxis.controller.Controller;

public interface View<C extends Controller> extends ViewSoundEffects {
    /**
     * Return the {@link Controller} bound to the {@link View}.
     *
     * @return The {@link Controller}.
     */
    C getController();
    /**
     * Bound the {@link Controller} to the {@link View}.
     *
     * @param controller The {@link Controller} to bind.
     */
    void setController(C controller);
}
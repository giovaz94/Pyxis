package it.unibo.pyxis.controller.controllers;

import it.unibo.pyxis.model.level.Level;
import it.unibo.pyxis.view.views.View;

public interface Controller {

    Level getLevel();

    void setLevel(Level level);

    View getView();

    void setView(View view);
}
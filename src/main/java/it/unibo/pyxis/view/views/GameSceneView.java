package it.unibo.pyxis.view.views;

import it.unibo.pyxis.controller.controllers.GameSceneController;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;
import it.unibo.pyxis.view.drawer.GameArenaDrawer;

public final class GameSceneView extends AbstractJavaFXView<GameSceneController> implements RenderableView {

    @FXML
    private AnchorPane arenaPane;

    @FXML
    private Label currentLives, currentScore, currentLevel;

    private GameArenaDrawer drawer;

    public GameSceneView(final GameSceneController inputController) {
        super(inputController);
    }

    public void initialize(final URL location, final ResourceBundle resources) {
        this.drawer = new GameArenaDrawer(arenaPane,
                    this.arenaPane.getPrefWidth() / this.getController().getArenaWidth(),
                    this.arenaPane.getPrefHeight() / this.getController().getArenaHeight());
    }

    public void back() {
        this.getController().back();
    }

    @Override
    public void render() {
        this.currentLives.setText(this.getController().getLives().toString());
        this.currentScore.setText(this.getController().getScore().toString());
        this.getController().getBricks().forEach(b -> this.drawer.fillBrick(b.getPosition(), b.getDimension(), b.getBrickType()));
        this.getController().getBalls().forEach(b -> this.drawer.fillBall(b.getPosition(), b.getDimension(), b.getType()));
        this.getController().getPowerups().forEach(p -> this.drawer.fillPowerup(p.getPosition(), p.getDimension(), p.getType()));
        this.drawer.fillPad(this.getController().getPad());
    }

    public void clear() {
        this.arenaPane.getChildren().clear();
    }

}

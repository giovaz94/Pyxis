package it.unibo.pyxis.view.views;

import java.net.URL;
import java.util.ResourceBundle;
import it.unibo.pyxis.controller.controllers.EndLevelSceneController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public final class EndLevelSceneView extends AbstractJavaFXView<EndLevelSceneController> {

    @FXML
    private StackPane mainPane;
    @FXML
    private VBox vBox;
    @FXML
    private Label score;
    @FXML
    private Button nextLevelButton;

    public EndLevelSceneView(final EndLevelSceneController inputController) {
        super(inputController);
    }

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        vBox.prefWidthProperty().bind(mainPane.prefWidthProperty());
        vBox.prefHeightProperty().bind(mainPane.prefHeightProperty());

        score.setText(this.getController().getScore().toString());
        this.nextLevelButton.setDisable(this.getController().disableNextLevelButton());
    }

    public void menu() {
        this.playMainMenuMusic();
        this.playGenericButtonPressSound();
        this.getController().menu();
    }

    public void nextLevel() {
        this.playStartGameButtonPressSound();
        this.getController().nextLevel();
    }
}

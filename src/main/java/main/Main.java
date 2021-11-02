package main;

import controller.EventConnector;
import controller.EventConnectorImpl;
import controller.KeyboardInterface;
import controller.MouseHandler;
import controller.command.CommandController;
import java.util.ArrayList;
import model.interfaces.Drawable;
import model.interfaces.UserChoices;
import model.persistence.UserChoicesImpl;
import view.gui.Gui;
import view.gui.GuiWindowImpl;
import view.gui.PaintCanvas;
import view.interfaces.GuiWindow;
import view.interfaces.UiModule;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        PaintCanvas paintCanvas = new PaintCanvas();
        GuiWindow guiWindow = new GuiWindowImpl(paintCanvas);
        UiModule uiModule = new Gui(guiWindow);
        UserChoices appState = new UserChoicesImpl(uiModule);
        CommandController commandController = new CommandController(appState, paintCanvas);
        EventConnector controller = new EventConnectorImpl(uiModule, appState, commandController);

        KeyboardInterface keys = new KeyboardInterface(paintCanvas, appState);
        keys.setup();


        MouseHandler mouse = new MouseHandler(commandController, appState);
        paintCanvas.addMouseListener(mouse);
        controller.setup();

        Thread.sleep(500);
    }
}

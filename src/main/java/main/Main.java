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
        ArrayList<Drawable> painting = new ArrayList<Drawable>();
        PaintCanvas paintCanvas = new PaintCanvas(painting);
        GuiWindow guiWindow = new GuiWindowImpl(paintCanvas);
        UiModule uiModule = new Gui(guiWindow);
        UserChoices appState = new UserChoicesImpl(uiModule);
        EventConnector controller = new EventConnectorImpl(uiModule, appState);

        KeyboardInterface keys = new KeyboardInterface(paintCanvas, appState);
        keys.setup();

        CommandController commandController = new CommandController(appState, paintCanvas, painting);
        MouseHandler mouse = new MouseHandler(commandController, appState);
        paintCanvas.addMouseListener(mouse);
        controller.setup();

        Thread.sleep(500);
    }
}

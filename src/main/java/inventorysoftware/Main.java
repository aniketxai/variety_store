package inventorysoftware;

import inventorysoftware.cli.CLIController;
import inventorysoftware.dao.DatabaseManager;
import inventorysoftware.gui.SpalshScreen;
import inventorysoftware.gui.NewSignin;
import java.awt.GraphicsEnvironment;

public class Main {

    public static void main(String[] args) {
        DatabaseManager.initializeSchema();

        boolean forceCLI = false;
        boolean forceBatch = false;
        boolean forceGUI = false;

        for (String arg : args) {
            if ("--cli".equalsIgnoreCase(arg) || "-c".equalsIgnoreCase(arg)) {
                forceCLI = true;
            } else if ("--cli-batch".equalsIgnoreCase(arg) || "--headless".equalsIgnoreCase(arg) || "--test-headless".equalsIgnoreCase(arg)) {
                forceBatch = true;
            } else if ("--gui".equalsIgnoreCase(arg) || "-g".equalsIgnoreCase(arg)) {
                forceGUI = true;
            }
        }

        if (forceBatch) {
            System.out.println("[Main] Running in Non-Interactive Headless Batch Mode...");
            new CLIController().runNonInteractiveBatch();
            return;
        }

        if (forceCLI) {
            new CLIController().startInteractiveCLI();
            return;
        }

        if (GraphicsEnvironment.isHeadless()) {
            System.out.println("[Main] Headless environment detected (no display server). Defaulting to CLI batch runner.");
            new CLIController().runNonInteractiveBatch();
            return;
        }

        if (forceGUI || !GraphicsEnvironment.isHeadless()) {
            try {
                System.out.println("[Main] Launching Variety Store GUI Application...");
                java.awt.EventQueue.invokeLater(() -> {
                    SpalshScreen splash = new SpalshScreen();
                    splash.setVisible(true);
                    splash.startSplashAnimation();
                });
            } catch (Throwable t) {
                System.out.println("[Main] GUI initialization warning (" + t.getMessage() + "). Falling back to CLI controller.");
                new CLIController().runNonInteractiveBatch();
            }
        }
    }
}

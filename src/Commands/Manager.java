package Commands;

import GUI.Board;
import Utils.Constants;

public class Manager {
    public void handle(String unhandledCommand) {
        Board.getBoard().getGameGUI().gb_clearCommandBar();
        String[] commandDesc = new String[]{};
        String commandName = "", commandValue = "";
        if(unhandledCommand.contains("command ")) {
            commandDesc = unhandledCommand.toLowerCase().split(" ")[1].split("=");//POS 1 since 0 equals command
            commandName = commandDesc[0];
            commandValue = commandDesc.length > 1 ? commandDesc[1]:"";
        }
        System.out.println("Command received: " + commandName);

        Command command = null;

        // Instead reflection, we are using a simple switch :(
        switch(commandName) {
            case "help":
                command = new Help();
                break;
            case "player":
                command = new PlayerInfoCommand();
                command.setValue(commandValue);
                break;
            case "exit":
                command = new ExitCommand();
                command.setValue(commandValue);
                break;
        }

        if(null == command) {
            System.out.println("Command not found: " + commandName);
            Board.getBoard().getGameGUI().gb_println("Comando no encontrado: " + commandName);
        }
        else {
            command.execute();
        }
    }
}

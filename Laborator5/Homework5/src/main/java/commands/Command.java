package commands;


public abstract class Command {
    private String commandName;

    public  Command() {

    }
    public Command(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}

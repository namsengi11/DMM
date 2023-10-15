package command;

public abstract class Command {
    public abstract boolean isParamValid(String[] userParam);
    
    public abstract Command createCommand(String[] userParam);

    
}

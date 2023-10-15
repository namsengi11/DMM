import java.util.Arrays;
import command.Command;
import command.AddTaskCommand;
import command.DeleteTaskCommand;
import command.EditTaskCommand;
import command.SortTaskByImportanceCommand;
import command.SortTaskByUrgencyCommand;
import command.ViewDMMCommand;
import command.InvalidCommand;

class Parser {
    private static String[] COMMAND_TYPE = {"addtask", "deletetask", "edittask", "sorttaskbyimp", "sorttaskbyurg", "viewdmm"};
    private static Command[] COMMAND_CLASS = {new AddTaskCommand(), new DeleteTaskCommand(), new EditTaskCommand(), 
        new SortTaskByImportanceCommand(), new SortTaskByUrgencyCommand(), new ViewDMMCommand()};

    public static Command parse(String[] userInput) {
        String commandType = userInput[0].toLowerCase();
        String[] commandParam = Arrays.copyOfRange(userInput, 1, COMMAND_TYPE.length);
        int commandNum = 0;
        for (int i = 0; i < COMMAND_TYPE.length; i++) {
            if (commandType == COMMAND_TYPE[i]) {
                commandNum = i;
            }
        }
        boolean isParamValid = COMMAND_CLASS[commandNum].isParamValid(commandParam);

        if (isParamValid) {
            return COMMAND_CLASS[commandNum].createCommand(commandParam);
        } else {
            return new InvalidCommand();
        }
    }
}
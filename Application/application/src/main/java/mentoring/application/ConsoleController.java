package mentoring.application;

public class ConsoleController {

    public ResultBean process(String command){
        if(command != null && command.length() > 0){
            String controllerPrefix = "mentoring.application.controllers.";
            String comandName = command.split(" ")[0];
            String controllerName = comandName.substring(0,1).toUpperCase() + comandName.substring(1);
            String controllerPostfix = "Controller";
            try {
                Class clazz = Class.forName(controllerPrefix + controllerName + controllerPostfix);
                
                
            } catch (ClassNotFoundException e) {
                return new ResultBean("Unknown command: " + comandName);
            }
        }
        return new ResultBean("Command must not be empty");
    }
}

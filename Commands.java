public enum Commands {
    ADD("add"),
    LIST("list"),
    EDIT("edit"),
    CREATE("create"),
    DELETE("delete");

    final private String command;

    Commands(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
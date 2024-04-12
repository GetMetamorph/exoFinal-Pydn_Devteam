public enum Commands {
    ADD("ADD"),
    LIST("LIST"),
    EDIT("EDIT"),
    CREATE("CREATE"),
    DELETE("DELETE");

    final private String command;

    Commands(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
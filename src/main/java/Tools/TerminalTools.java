package Tools;

public class TerminalTools {
    // great documentation
    //https://www.lihaoyi.com/post/BuildyourownCommandLinewithANSIescapecodes.html
    public static final String ANSI_YELLOW = "\u001B[93m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001b[31m";

    public static final String CLEAR_SCREEN = "\033[H\033[2J";
    public static final String CURSOR_MIDDLE = "\033[2;5H";

    public static final String ANSI_GREEN = "\u001b[32m";
}

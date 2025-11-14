package com.pluralsight.BakeHouse05.Interface;

public class BillBoard {
    // ANSI Color Codes
    public static final String RESET = "\u001B[0m";
    public static final String CYAN = "\u001B[36m";
    public static final String BRIGHT_YELLOW = "\u001B[93m";
    public static final String BRIGHT_CYAN = "\u001B[96m";
    public static final String BRIGHT_WHITE = "\u001B[97m";
    public static final String BOLD = "\u001B[1m";

    public static void displayBillboard() {
        System.out.println(BRIGHT_CYAN + "╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗" + RESET);
        System.out.println(BRIGHT_CYAN + "║" + RESET + "                                                                                                                        " + BRIGHT_CYAN + "║" + RESET);
        System.out.println(BRIGHT_CYAN + "║" + RESET + "                                                                                                                        " + BRIGHT_CYAN + "║" + RESET);
        System.out.println(BRIGHT_CYAN + "║" + RESET + "                                                                                                                        " + BRIGHT_CYAN + "║" + RESET);
        System.out.println(BRIGHT_CYAN + "║" + RESET + BOLD + BRIGHT_YELLOW + "         ██████╗   █████╗  ██╗  ██╗ ███████╗ ██╗  ██╗  ██████╗  ██╗   ██╗ ███████╗ ███████╗ ██████╗  ███████╗          " + RESET + BRIGHT_CYAN + " ║" + RESET);
        System.out.println(BRIGHT_CYAN + "║" + RESET + BOLD + BRIGHT_YELLOW + "         ██╔══██╗ ██╔══██╗ ██║ ██╔╝ ██╔════╝ ██║  ██║ ██╔═══██╗ ██║   ██║ ██╔════╝ ██╔════ ██╔═████╗ ██╔════╝          " + RESET + BRIGHT_CYAN + " ║" + RESET);
        System.out.println(BRIGHT_CYAN + "║" + RESET + BOLD + BRIGHT_YELLOW + "         ██████╔╝ ███████║ █████╔╝  █████╗   ███████║ ██║   ██║ ██║   ██║ ███████╗ █████╗  ██║██╔██║ ███████╗          " + RESET + BRIGHT_CYAN + " ║" + RESET);
        System.out.println(BRIGHT_CYAN + "║" + RESET + BOLD + BRIGHT_YELLOW + "         ██╔══██ ╗██╔══██║ ██╔═██╗  ██╔══╝   ██╔══██║ ██║   ██║ ██║   ██║ ╚════██║ ██╔══╝  ████╔╝██║ ╚════██║          " + RESET + BRIGHT_CYAN + " ║" + RESET);
        System.out.println(BRIGHT_CYAN + "║" + RESET + BOLD + BRIGHT_YELLOW + "         ██████╔╝ ██║  ██║ ██║  ██╗ ███████╗ ██║  ██║ ╚██████╔╝ ╚██████╔╝ ███████║ ███████╗╚██████╔╝ ███████║          " + RESET + BRIGHT_CYAN + " ║" + RESET);
        System.out.println(BRIGHT_CYAN + "║" + RESET + BOLD + BRIGHT_YELLOW + "         ╚═════╝  ╚═╝  ╚═╝ ╚═╝  ╚═╝ ╚══════╝ ╚═╝  ╚═╝  ╚═════╝  ╚═════╝  ╚══════╝ ╚══════╝  ╚═════╝ ╚══════╝          " + RESET + BRIGHT_CYAN + "  ║" + RESET);
        System.out.println(BRIGHT_CYAN + "║" + RESET + "                                                                                                                        " + BRIGHT_CYAN + "║" + RESET);
        System.out.println(BRIGHT_CYAN + "║" + RESET + "                                                                                                                        " + BRIGHT_CYAN + "║" + RESET);
        System.out.println(BRIGHT_CYAN + "║" + RESET + "                                                                                                                        " + BRIGHT_CYAN + "║" + RESET);
        System.out.println(BRIGHT_CYAN + "║" + RESET + BRIGHT_CYAN + "                                          ╔═════════════════════════════╗                                               " + BRIGHT_CYAN + "║" + RESET);
        System.out.println(BRIGHT_CYAN + "║" + RESET + BRIGHT_CYAN + "                                          ║  " + BOLD + BRIGHT_WHITE +     "       Est. 2005     "               + RESET + BRIGHT_CYAN + "      ║                                               " + BRIGHT_CYAN + "║" + RESET);
        System.out.println(BRIGHT_CYAN + "║" + RESET + BRIGHT_CYAN + "                                          ╚═════════════════════════════╝                                               " + BRIGHT_CYAN + "║" + RESET);
        System.out.println(BRIGHT_CYAN + "║" + RESET + "                                                                                                                        " + BRIGHT_CYAN + "║" + RESET);
        System.out.println(BRIGHT_CYAN + "║" + RESET + BOLD + CYAN + "                                        Custom Cakes for Every Celebration                                              " + RESET + BRIGHT_CYAN + "║" + RESET);
        System.out.println(BRIGHT_CYAN + "║" + RESET + "                                                                                                                        " + BRIGHT_CYAN + "║" + RESET);
        System.out.println(BRIGHT_CYAN + "║" + RESET + "                                                                                                                        " + BRIGHT_CYAN + "║" + RESET);
        System.out.println(BRIGHT_CYAN + "╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝" + RESET);
    }
}

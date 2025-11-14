package com.pluralsight.UI;

public class BakeHouse05Art {
    // ANSI color codes
    private static final String RESET = "\u001B[0m";
    private static final String BLACK = "\u001B[30m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String MAGENTA = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";
    private static final String WHITE = "\u001B[37m";
    private static final String BRIGHT_WHITE = "\u001B[97m";

    // Bright background (for frosting bands)
    private static final String BG_RED = "\u001B[41m";
    private static final String BG_MAGENTA = "\u001B[45m";
    private static final String BG_CYAN = "\u001B[46m";
    private static final String BG_YELLOW = "\u001B[43m";
    private static final String BG_GREEN = "\u001B[42m";
    private static final String BG_RESET = "\u001B[49m";

    public static void main(String[] args) {
        // Header / shop name (stylized)
        printHeader();

        // Cake art lines: each line printed with chosen color/Background band
        System.out.println();
        printLine("                 " + YELLOW + "._._._._._._._._._." + RESET);
        printLine("                 " + YELLOW + "/  .'.'.'.'.'.'.'.  \\" + RESET);
        printLine("                 " + YELLOW + "\\  `-._.-._.-._.-'  /" + RESET);
        System.out.println();

        // Candles row
        printLine("                     " + YELLOW + "i  i  i  i  i" + RESET);
        printLine("                    " + YELLOW + "///\\\\\\///\\\\\\///\\\\\\" + RESET);
        System.out.println();

        // Top tier
        printBand("                 ", BG_YELLOW, "      " + BRIGHT_WHITE + "┌──────────┐" + RESET);
        printBand("                 ", BG_YELLOW, "      " + BRIGHT_WHITE + "│  Vanilla │" + RESET);
        printBand("                 ", BG_YELLOW, "      " + BRIGHT_WHITE + "└──────────┘" + RESET);
        System.out.println();

        // Middle tier (frosting)
        printBand("             ", BG_MAGENTA, "   " + BRIGHT_WHITE + "┌────────────────┐" + RESET);
        printBand("             ", BG_MAGENTA, "   " + BRIGHT_WHITE + "│   Strawberry   │" + RESET);
        printBand("             ", BG_MAGENTA, "   " + BRIGHT_WHITE + "└────────────────┘" + RESET);
        System.out.println();

        // Bottom tier (chocolate)
        printBand("         ", BG_CYAN, "  " + BRIGHT_WHITE + "┌────────────────────┐" + RESET);
        printBand("         ", BG_CYAN, "  " + BRIGHT_WHITE + "│   Chocolate Ganache │" + RESET);
        printBand("         ", BG_CYAN, "  " + BRIGHT_WHITE + "└────────────────────┘" + RESET);
        System.out.println();

        // Cake stand
        printLine("                 " + GREEN + "        _________" + RESET);
        printLine("                 " + GREEN + "       /         \\" + RESET);
        printLine("                 " + GREEN + "      /___________\\" + RESET);
        System.out.println();

        // Tagline and flourish
        System.out.println("   " + MAGENTA + "Handmade with love — custom cakes for every celebration!" + RESET);
        System.out.println();
        printFooter();
    }

    private static void printHeader() {
        // A compact block-letter "BakeHouse05" header
        String[] header = new String[] {
                "",
                "  " + RED   + "██████╗  █████╗ ██╗  ██╗██╗  ██╗███████╗██╗   ██╗" + RESET,
                "  " + RED   + "██╔══██╗██╔══██╗██║ ██╔╝██║ ██╔╝██╔════╝██║   ██║" + RESET,
                "  " + YELLOW+ "██████╔╝███████║█████╔╝ █████╔╝ █████╗  ██║   ██║" + RESET,
                "  " + YELLOW+ "██╔══██╗██╔══██║██╔═██╗ ██╔═██╗ ██╔══╝  ██║   ██║" + RESET,
                "  " + MAGENTA+ "██████╔╝██║  ██║██║  ██╗██║  ██╗███████╗╚██████╔╝" + RESET,
                "  " + MAGENTA+ "╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝ ╚═════╝ " + RESET,
                "",
                "           " + CYAN + " ____    _    _  __  _____  _   _  ____  _____" + RESET,
                "          " + CYAN + "|  _ \\  / \\  | |/ / |  ___|| \\ | |/ ___|| ____|" + RESET,
                "          " + CYAN + "| | | |/ _ \\ | ' /  | |_   |  \\| | |  _ |  _|  " + RESET,
                "          " + CYAN + "| |_| / ___ \\| . \\  |  _|  | |\\  | |_| || |___ " + RESET,
                "          " + CYAN + "|____/_/   \\_\\_|\\_\\ |_|    |_| \\_|\\____||_____|" + RESET,
                ""
        };
        for (String line : header) {
            System.out.println(line);
        }
    }

    private static void printFooter() {
        System.out.println("   " + BLUE + "Visit us: BakeHouse05 — custom orders, weddings, birthdays!" + RESET);
        System.out.println("   " + BLUE + "Tip: If colors don't appear on Windows, run in Windows Terminal or PowerShell 6+." + RESET);
    }

    private static void printLine(String s) {
        System.out.println(s);
    }

    private static void printBand(String indent, String bg, String content) {
        // print an indent, then a background block that includes the content
        // we combine bg + content + reset; content often includes BRIGHT_WHITE text
        System.out.println(indent + bg + content + BG_RESET + RESET);
    }
}

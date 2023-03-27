package asciimirror;

public class Picture {
    String[] lines;

    public void printLines() {
        for (String line: lines
             ) {
            System.out.println(line);
        }
    }

    public String mirrorText(String line) {
        char[] symbols = line.toCharArray();
        for (int i = 0; i < symbols.length; i++) {
            // reverse horizontally opposite characters
            symbols[i] = switch (symbols[i]) {
                case '<' -> '>';
                case '>' -> '<';
                case '[' -> ']';
                case ']' -> '[';
                case '{' -> '}';
                case '}' -> '{';
                case '(' -> ')';
                case ')' -> '(';
                case '/' -> '\\';
                case '\\' -> '/';
                default -> symbols[i];
            };
        }
        char[] reversed = new char[symbols.length];
        int j = symbols.length - 1;
        // reverse order of chars
        for (int i = 0; i < reversed.length; i++) {
            reversed[i] = symbols[j];
            j--;
        }
        return new String(reversed);
    }
    public void mirrorLines() {
        String longestLine = "";
        for (String line : lines) {
            if (line.length() > longestLine.length()) {
                longestLine = line;
            }
        }
        int width = longestLine.length();
        for (int i = 0; i < lines.length; i++) {
            while (lines[i].length() < width){
                lines[i] = lines[i] + " ";
            } // | <- line of symmetry
            lines[i] = lines[i] + " | " + mirrorText(lines[i]);
        }
    }

    public Picture(String[] lines){
        this.lines = lines;
    }
}

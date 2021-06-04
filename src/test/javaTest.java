package test;

public class javaTest {

    public static void main(String[] args) {

        for (Color color : Color.values()) {
            if (color == null) {

            }
            color.setIndex(color.ordinal());
            System.err.println(color + "  ordinal  " + color.ordinal());
        }
    }
}

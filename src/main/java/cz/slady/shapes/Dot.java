package cz.slady.shapes;

public class Dot {

    private final int x;
    private final int y;
    private final Color color;
    private final String comment;
    private Shape parent;
    private String result;

    public Dot(int x, int y, char colorChar, String comment) {
        this.x = x;
        this.y = y;
        this.color = Color.valueOf(String.valueOf(colorChar));
        this.comment = comment;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }

    public String getComment() {
        return comment;
    }

    public Shape getParent() {
        return parent;
    }

    public void setParent(Shape parent) {
        this.parent = parent;
    }

    public void setResult(final String newResult) {
        if (result == null) {
            result = newResult;
        }
    }

    @Override
    public String toString() {
        return "" + x + "," + y + "," + color.toString() + ","
                + (result == null ? "-" : result)
                + "," + comment;
    }

}

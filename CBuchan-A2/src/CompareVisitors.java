import java.util.Comparator;

class CompareVisitors implements Comparator<Visitor> {
    // Compares two visitor objects based on rides taken. Help from https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html
    @Override
    public int compare(Visitor v1, Visitor v2) {
        return Integer.compare(v1.getRidesTaken(), v2.getRidesTaken());
    }
}
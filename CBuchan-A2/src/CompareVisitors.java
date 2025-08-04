import java.util.Comparator;

class CompareVisitors implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        return Integer.compare(v1.getRidesTaken(), v2.getRidesTaken());
    }
}
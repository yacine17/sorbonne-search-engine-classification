import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JacquardMatrix {
    public static final double THRESHOLD = 0.5;

    private Map<String, Map<String, Double>> matrix;
    private List<String> filenames;

    public JacquardMatrix(List<String> filenames) {
        this.filenames = filenames;
        initMatrix();
    }

    private void initMatrix() {
        matrix = new HashMap<>();

        for (int i = 0; i < filenames.size(); i++) {
            Jaccard jaccard = new Jaccard(Path.of(filenames.get(i)));

            Map<String, Double> collect = filenames
                    .stream()
                    .map(file -> new Jaccard(Path.of(file)))
                    .collect(Collectors.toMap(j -> j.getFilePath().getFileName().toString(), j -> j.distance(jaccard.index())));

            matrix.put(jaccard.getFilePath().getFileName().toString(), collect);
        }

    }

    public Map<String, Map<String, Double>> getMatrix() {
        return matrix;
    }


    public LabeledDigraph getJacquardGraph() {
        LabeledDigraph labeledDigraph = new LabeledDigraph(matrix.keySet());

        matrix.keySet().forEach(i -> {
            Map<String, Double> iMap = matrix.get(i);
            iMap.entrySet().stream()
                    .filter(stringDoubleEntry -> stringDoubleEntry.getValue() <= THRESHOLD && stringDoubleEntry.getValue() != 0)
                    .map(Map.Entry::getKey)
                    .forEach(value -> labeledDigraph.addEdge(i, value));
        });

        return labeledDigraph;
    }
}

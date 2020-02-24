import org.junit.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class ClosenessCentralityTest {

    private LabeledDigraph initGraph() {
        LabeledDigraph labeledDigraph = new LabeledDigraph(List.of("A", "B", "C", "D", "E"));

        labeledDigraph.addEdge("A", "B");
        labeledDigraph.addEdge("A", "C");

        labeledDigraph.addEdge("B", "A");
        labeledDigraph.addEdge("B", "C");
        labeledDigraph.addEdge("B", "D");
        labeledDigraph.addEdge("B", "E");

        labeledDigraph.addEdge("C", "A");
        labeledDigraph.addEdge("C", "B");

        labeledDigraph.addEdge("D", "B");

        labeledDigraph.addEdge("E", "B");

        return labeledDigraph;
    }

    @Test
    public void computeClosenessCentrality() {

        ClosenessCentrality closenessCentrality = new ClosenessCentrality(initGraph());

        System.out.println("closenessCentrality.computeClosenessCentrality() = " + closenessCentrality.computeClosenessCentrality());
    }

}

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class JacquardMatrixTest {

    @Test
    public void getMatrix(){
        Map<String, Map<String, Double>> expectedResult = new HashMap<>();

        Map<String, Double> map1 = new HashMap<>();
        map1.put("test1.txt", 0d);
        map1.put("test2.txt", 0.9d);
        expectedResult.put("test1.txt", map1);

        Map<String, Double> map2 = new HashMap<>();
        map2.put("test1.txt", 0.9d);
        map2.put("test2.txt", 0d);
        expectedResult.put("test2.txt", map2);

        JacquardMatrix jacquardMatrix = new JacquardMatrix(List.of("src/test/resources/test1.txt", "src/test/resources/test2.txt"));

        assertEquals(expectedResult, jacquardMatrix.getMatrix());
    }

}

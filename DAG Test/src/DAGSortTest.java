import org.junit.Test;
import java.util.HashMap;
import static org.junit.Assert.*;

/**
 * A JUnit4 testing class for the DAGSort Topological Sort implementation.
 */
public class DAGSortTest {

    /**
     * Check a NullPointerException is thrown if the edges array is passed as null.
     */
    @Test
    public void nullInput() {
        try {
            DAGSort.sortDAG(null);
            fail("No exception thrown. Expected: Null Pointer Exception");
        } catch (NullPointerException e) {
            assertEquals("Edges can't be null", e.getMessage());
        } catch (Exception e) {
            fail("Incorrect exception thrown. Expected: Null Pointer Exception");
        }
    }

    /**
     * Check it will not accept node indexes that are not in the array.
     */
    @Test
    public void invalidNodeLarge() {
        try {
            int[][] edges = new int[1][];
            edges[0] = new int[]{1};
            DAGSort.sortDAG(edges);
            fail("No exception thrown. Expected: Invalid Node Exception");
        } catch (InvalidNodeException e) {
            assertEquals("Edges array refers to invalid node: 1", e.getMessage());
        } catch (Exception e) {
            fail("Incorrect exception thrown. Expected: Invalid Node Exception");
        }
    }

    /**
     * Check it will not accept node indexes less than 0.
     */
    @Test
    public void invalidNodeSmall() {
        try {
            int[][] edges = new int[1][];
            edges[0] = new int[]{-1};
            DAGSort.sortDAG(edges);
            fail("No exception thrown. Expected: Invalid Node Exception");
        } catch (InvalidNodeException e) {
            assertEquals("Edges array refers to invalid node: -1", e.getMessage());
        } catch (Exception e) {
            fail("Incorrect exception thrown. Expected: Invalid Node Exception");
        }
    }

    /**
     * Check a CycleDetectedException is thrown there is a cycle between two nodes.
     */
    @Test
    public void twoNodeCycleDetection() {
        try {
            int[][] edges = new int[2][];
            edges[0] = new int[]{1};
            edges[1] = new int[]{0};
            DAGSort.sortDAG(edges);
            fail("No exception thrown. Expected: Cycle Detected Exception");
        } catch (CycleDetectedException e) {
            assertEquals(null, e.getMessage());
        } catch (Exception e) {
            fail("Incorrect exception thrown. Expected: Cycle Detected Exception");
        }
    }

    /**
     * Check a CycleDetectedException is thrown when there is a cycle that loops from three nodes
     */
    @Test
    public void multiNodeCycleDetection() {
        try {
            int[][] edges = new int[3][];
            edges[0] = new int[]{1};
            edges[1] = new int[]{2};
            edges[2] = new int[]{0};
            DAGSort.sortDAG(edges);
            fail("No exception thrown. Expected: Cycle Detected Exception");
        } catch (CycleDetectedException e) {
            assertEquals(null, e.getMessage());
        } catch (Exception e) {
            fail("Incorrect exception thrown. Expected: Cycle Detected Exception");
        }
    }

    /**
     * Check it generates the correct topological sorting when there is only one possible ordering
     */
    @Test
    public void singleSolutionGraph() {
        try {
            int[][] edges = new int[3][];
            edges[0] = new int[]{1};
            edges[1] = new int[]{2};
            edges[2] = new int[]{};
            int[] expected = new int[]{0,1,2};
            assertArrayEquals(DAGSort.sortDAG(edges), expected);
        } catch (Exception e) {
            fail("Exception should not have been thrown, valid graph passed.");
        }
    }

    /**
     * Check it generates the correct topological sorting when there are multiple possible ordering
     */
    @Test
    public void multiSolutionGraph() {
        try {
            int[][] edges = new int[6][];
            edges[0] = new int[]{};
            edges[1] = new int[]{};
            edges[2] = new int[]{3};
            edges[3] = new int[]{1};
            edges[4] = new int[]{0,1};
            edges[5] = new int[]{0,2};
            int[] result = DAGSort.sortDAG(edges);
            assertTrue("Result was not a valid topological sort of the given graph",
                    checkValidTopologicalSort(edges, result));
        } catch (Exception e) {
            fail("Exception should not have been thrown, valid graph passed.");
        }
    }

    /**
     * Check a valid topological ordering is returned when there are no edges in the graph
     * (this means any ordering is valid)
     */
    @Test
    public void noEdgeGraph() {
        try {
            int[][] edges = new int[1000][0];
            int[] result = DAGSort.sortDAG(edges);
            assertTrue("Result was not a valid topological sort of the given graph",
                    checkValidTopologicalSort(edges, result));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            fail("Exception should not have been thrown, valid graph passed.");
        }
    }

    /**
     * Test the topological ordering is valid by using the degree of each node.
     * @param edges 2D Array representing the DAG
     * @param result Returned topological ordering array
     * @return true if the ordering is valid
     */
    private boolean checkValidTopologicalSort(int[][] edges, int[] result) {
        // Used to store the number of dependencies (nodes that must be visited first) each node has
        HashMap<Integer, Integer> degrees = new HashMap<>();

        // Add the degree of each node to the hash map
        for (int[] row : edges) {
            for (int i : row) {
                degrees.put(i, degrees.getOrDefault(i, 0) + 1);
            }
        }

        // Iterate through each node
        for (int i = 0; i < edges.length; i++) {
            // If there are other nodes that must be visited before, as the degree is still greater than 0,
            // it is not a valid ordering.
            if (degrees.getOrDefault(result[i], 0) != 0) return false;
            // Visit the node by decrementing the degree count of the nodes connected to it.
            for (int node : edges[result[i]]) {
                degrees.put(node, degrees.get(node) - 1);
            }
        }
        return true;
    }
}
package se.joel.math3d;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Vector4D Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>apr 16, 2012</pre>
 */
public class Vector4DTest {
    /**
     * Method: normalize()
     */
    @Test
    public void testNormalize() throws Exception {
        assertEquals(new Vector4D(3.0 / Math.sqrt(14.0), Math.sqrt(2.0 / 7.0), 1.0 / Math.sqrt(14.0), 1), new Vector4D(3, 2, 1).normalize());
    }

    /**
     * Method: copy()
     */
    @Test
    public void testCopy() throws Exception {
        assertEquals(new Vector4D(2, 3, 4, 5), new Vector4D(2, 3, 4, 5).copy());
    }

    /**
     * Method: magnitude()
     */
    @Test
    public void testMagnitude() throws Exception {
        assertEquals(Math.sqrt(4 + 9 + 16), new Vector4D(2, 3, 4).magnitude(), 0.000000001);
    }

    /**
     * Method: dot(Vector4D other)
     */
    @Test
    public void testDot() throws Exception {
        assertEquals(86, new Vector4D(3, 4, 5).dot(new Vector4D(6, 7, 8)), 0.000000001);
    }

    /**
     * Method: cross(Vector4D other)
     */
    @Test
    public void testCross() throws Exception {
        assertEquals(new Vector4D(-3, 6, -3), new Vector4D(3, 4, 5).cross(new Vector4D(6, 7, 8)));
    }

    /**
     * Method: scale(double scalar)
     */
    @Test
    public void testScale() throws Exception {
        assertEquals(new Vector4D(4, 8, 12), new Vector4D(2, 4, 6).scale(2));
    }

    /**
     * Method: projectOn(Vector4D other)
     */
    @Test
    public void testProjectOn() throws Exception {
        assertEquals(new Vector4D(1 / Math.sqrt(2), 0), new Vector4D(1 / Math.sqrt(2), 1 / Math.sqrt(2)).projectOn(new Vector4D(2, 0)));
        assertEquals(new Vector4D(4.0 / 9.0, -4.0 / 9.0, 16.0 / 9.0), new Vector4D(2, 2, 2).projectOn(new Vector4D(1, -1, 4)));
    }

    /**
     * Method: asArray()
     */
    @Test
    public void testAsArray() throws Exception {
        assertArrayEquals(new double[]{7, 8, 9, 1}, new Vector4D(7, 8, 9).asArray(), 0.000001);
    }
}

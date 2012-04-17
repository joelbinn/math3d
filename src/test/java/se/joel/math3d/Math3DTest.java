package se.joel.math3d;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static java.lang.Math.*;
import static org.junit.Assert.assertArrayEquals;
import static se.joel.math3d.Math3D.*;

/**
 * Math3D Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>apr 17, 2012</pre>
 */
public class Math3DTest {
    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: vector3DSub(float[] vector3D, float scalar)
     */
    @Test
    public void testSub() throws Exception {
        //TODO: Test goes here...
    }

    /**
     * Method: vector3DAdd(float[] vector3D, float scalar)
     */
    @Test
    public void testAdd() throws Exception {
        //TODO: Test goes here...
    }

    /**
     * Method: vector3DMult(float[] vector3D, float s)
     */
    @Test
    public void testMult() throws Exception {
        //TODO: Test goes here...
    }

    /**
     * Method: vector3DDiv(float[] vector3D, float s)
     */
    @Test
    public void testDiv() throws Exception {
        //TODO: Test goes here...
    }

    /**
     * Method: vector3DDot(float[] vector3D_1, float[] vector3D_2)
     */
    @Test
    public void testDot() throws Exception {
        //TODO: Test goes here...
    }

    /**
     * Method: vector3DCross(float[] vector3D_1, float[] vector3D_2)
     */
    @Test
    public void testCross() throws Exception {
        //TODO: Test goes here...
    }

    /**
     * Method: vector3DMagnitude(float[] vector3D)
     */
    @Test
    public void testMagnitude() throws Exception {
        //TODO: Test goes here...
    }

    /**
     * Method: vector3DNormalize(float[] vector3D)
     */
    @Test
    public void testNormalize() throws Exception {
        //TODO: Test goes here...
    }

    /**
     * Method: vector3DProjection(float[] vector3D_1, float[] vector3D_2)
     */
    @Test
    public void testProject() throws Exception {
        //TODO: Test goes here...
    }

    /**
     * Method: transpose(float[] matrix4x4)
     */
    @Test
    public void testTranspose() throws Exception {
        //TODO: Test goes here...
    }

    /**
     * Method: createAxisAngleRotationMatrix4x4(float angle, float[] axis)
     */
    @Test
    public void testRotationMatrix() throws Exception {
        //TODO: Test goes here...
    }

    /**
     * Method: invert(float[] m4x4)
     */
    @Test
    public void testInvert() throws Exception {
        //TODO: Test goes here...
    }

    @Test
    public void testTranslateTransform() {
        float[] v = new float[]{1, 2, 3};
        float[] tm = new float[]{
            1, 0, 0, 0,
            0, 1, 0, 0,
            0, 0, 1, 0,
            4, 5, 6, 1
        };

        float[] v2 = transformVector3DbyMatrix4x4(v, tm);
        assertArrayEquals(new float[]{5, 7, 9}, v2, 0.01f);
    }

    @Test
    public void testRotateTransform() {
        float[] i = new float[]{1, 0, 0};
        float[] j = new float[]{0, 1, 0};
        float[] k = new float[]{0, 0, 1};
        float[] v;

        {
            float[] matrixRotateAroundZAxis = new float[]{
                (float) cos(toRadians(30)), (float) sin(toRadians(30)), 0, 0,
                (float) -sin(toRadians(30)), (float) cos(toRadians(30)), 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1
            };

            v = transformVector3DbyMatrix4x4(i, matrixRotateAroundZAxis);
            assertArrayEquals(new float[]{(float) cos(toRadians(30)), (float) sin(toRadians(30)), 0}, v, 0.01f);
            v = transformVector3DbyMatrix4x4(j, matrixRotateAroundZAxis);
            assertArrayEquals(new float[]{(float) -sin(toRadians(30)), (float) cos(toRadians(30)), 0}, v, 0.01f);
        }
        {
            float[] matrixRotateAroundXAxis = new float[]{
                1, 0, 0, 0,
                0, (float) cos(toRadians(30)), (float) sin(toRadians(30)), 0,
                0, (float) -sin(toRadians(30)), (float) cos(toRadians(30)), 0,
                0, 0, 0, 1
            };
            v = transformVector3DbyMatrix4x4(j, matrixRotateAroundXAxis);
            assertArrayEquals(new float[]{0, (float) cos(toRadians(30)), (float) sin(toRadians(30))}, v, 0.01f);
            v = transformVector3DbyMatrix4x4(k, matrixRotateAroundXAxis);
            assertArrayEquals(new float[]{0, (float) -sin(toRadians(30)), (float) cos(toRadians(30))}, v, 0.01f);
        }
        {
            float[] matrixRotateAroundYAxis = new float[]{
                (float) cos(toRadians(30)), 0, (float) -sin(toRadians(30)), 0,
                0, 1, 0, 0,
                (float) sin(toRadians(30)), 0, (float) cos(toRadians(30)), 0,
                0, 0, 0, 1
            };
            v = transformVector3DbyMatrix4x4(i, matrixRotateAroundYAxis);
            assertArrayEquals(new float[]{(float) cos(toRadians(30)), 0, (float) -sin(toRadians(30))}, v, 0.01f);
            v = transformVector3DbyMatrix4x4(k, matrixRotateAroundYAxis);
            assertArrayEquals(new float[]{(float) sin(toRadians(30)), 0, (float) cos(toRadians(30))}, v, 0.01f);
        }

    }

    @Test
    public void testMatrixMultiply() {
        float[] m1 = new float[]{
            1, 2, 3, 4,
            5, 6, 7, 8,
            9, 10, 11, 12,
            13, 14, 15, 16
        };

        float[] m2 = new float[]{
            21, 22, 23, 24,
            25, 26, 27, 28,
            29, 30, 31, 32,
            33, 34, 35, 36
        };

        float[] expectedResult = new float[]{
            290, 300, 310, 320,
            722, 748, 774, 800,
            1154, 1196, 1238, 1280,
            1586, 1644, 1702, 1760
        };

        float[] m3 = matrix4x4Mult(m1, m2);

        assertArrayEquals(expectedResult, m3, 0.01f);

        float[] translateMatrix = new float[]{
            1, 0, 0, 0,
            0, 1, 0, 0,
            0, 0, 1, 0,
            10, 11, 12, 1
        };

        float[] rotationMatrix = new float[]{
            1, 2, 3, 0,
            4, 5, 6, 0,
            7, 8, 9, 0,
            0, 0, 0, 1
        };

        float[] translateAndRotationMatrix = new float[]{
            1, 2, 3, 0,
            4, 5, 6, 0,
            7, 8, 9, 0,
            10, 11, 12, 1
        };
        assertArrayEquals(translateAndRotationMatrix, matrix4x4Mult(rotationMatrix, translateMatrix), 0.01f);
    }

    @Test
    public void testInvertRotation() {
        float[] v1 = new float[]{(float) (1 / sqrt(2)), (float) (1 / sqrt(2)), 0};
        System.out.println(Arrays.toString(v1));
        float[] v2;

        {
            float[] matrixRotateAroundZAxis = new float[]{
                (float) cos(toRadians(45)), (float) sin(toRadians(45)), 0, 0,
                (float) -sin(toRadians(45)), (float) cos(toRadians(45)), 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1
            };

            float[] transposeMatrix = transposeMatrix4x4(matrixRotateAroundZAxis);
            v2 = transformVector3DbyMatrix4x4(v1, matrixRotateAroundZAxis);
            System.out.println(Arrays.toString(v2));

            float[] v3 = transformVector3DbyMatrix4x4(v2, transposeMatrix);
            System.out.println(Arrays.toString(v3));
            assertArrayEquals(v1, v3, 0.01f);
            assertArrayEquals(v1, transformVector3DbyMatrix4x4(v2, invertRotationMatrix4x4(matrixRotateAroundZAxis)),
                0.01f);
        }
    }

    @Test
    public void testAxisAngleRotation() {
        float[] i = new float[]{1, 0, 0};
        float[] j = new float[]{0, 1, 0};
        float[] k = new float[]{0, 0, 1};
        float[] v;

        {
            v = transformVector3DbyMatrix4x4(i, createAxisAngleRotationMatrix4x4((float) toRadians(30), k));
            assertArrayEquals(new float[]{(float) cos(toRadians(30)), (float) sin(toRadians(30)), 0}, v, 0.01f);
            v = transformVector3DbyMatrix4x4(j, createAxisAngleRotationMatrix4x4((float) toRadians(30), k));
            assertArrayEquals(new float[]{(float) -sin(toRadians(30)), (float) cos(toRadians(30)), 0}, v, 0.01f);
        }
        {
            v = transformVector3DbyMatrix4x4(j, createAxisAngleRotationMatrix4x4((float) toRadians(30), i));
            assertArrayEquals(new float[]{0, (float) cos(toRadians(30)), (float) sin(toRadians(30))}, v, 0.01f);
            v = transformVector3DbyMatrix4x4(k, createAxisAngleRotationMatrix4x4((float) toRadians(30), i));
            assertArrayEquals(new float[]{0, (float) -sin(toRadians(30)), (float) cos(toRadians(30))}, v, 0.01f);
        }
        {
            v = transformVector3DbyMatrix4x4(i, createAxisAngleRotationMatrix4x4((float) toRadians(30), j));
            assertArrayEquals(new float[]{(float) cos(toRadians(30)), 0, (float) -sin(toRadians(30))}, v, 0.01f);
            v = transformVector3DbyMatrix4x4(k, createAxisAngleRotationMatrix4x4((float) toRadians(30), j));
            assertArrayEquals(new float[]{(float) sin(toRadians(30)), 0, (float) cos(toRadians(30))}, v, 0.01f);
        }
    }
}

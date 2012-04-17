/**
 * User: Joel Binnquist (joel.binnquist@gmail.com)
 * Date: 2012-04-16
 * Time: 21:56
 */
package se.joel.math3d;

import static java.lang.Math.*;

/**
 * Utilities for 3D math (vectors and matrices).
 */
public abstract class Math3D {
    private static final float[] IDENDITY_4x4 = new float[]{
        1, 0, 0, 0,
        0, 1, 0, 0,
        0, 0, 1, 0,
        0, 0, 0, 1
    };

    /**
     * Subtract scalar from 3D vector.
     *
     * @param vector3D
     * @param scalar
     * @return
     */
    public static float[] vector3DSub(float[] vector3D, float scalar) {
        assert vector3D.length == 3;
        return new float[]{vector3D[0] - scalar, vector3D[1] - scalar, vector3D[2] - scalar};
    }

    /**
     * Subtract 3D vector from another 3D vector.
     *
     * @param vector3D_1
     * @param vector3D_2
     * @return
     */
    public static float[] vector3DSub(float[] vector3D_1, float[] vector3D_2) {
        assert vector3D_1.length == vector3D_2.length && vector3D_1.length == 3;
        return new float[]{vector3D_1[0] - vector3D_2[0], vector3D_1[1] - vector3D_2[1], vector3D_1[2] - vector3D_2[2]};
    }

    /**
     * Add scalar to 3D vector.
     *
     * @param vector3D
     * @param scalar
     * @return
     */
    public static float[] vector3DAdd(float[] vector3D, float scalar) {
        assert vector3D.length == 3;
        return new float[]{vector3D[0] + scalar, vector3D[1] + scalar, vector3D[2] + scalar};
    }

    /**
     * Add two 3D vectors.
     *
     * @param vector3D_1
     * @param vector3D_2
     * @return
     */
    public static float[] vector3DAdd(float[] vector3D_1, float[] vector3D_2) {
        assert vector3D_1.length == vector3D_2.length && vector3D_1.length == 3;
        return new float[]{vector3D_1[0] + vector3D_2[0], vector3D_1[1] + vector3D_2[1], vector3D_1[2] + vector3D_2[2]};
    }

    /**
     * Multiply 3D vector by scalar.
     *
     * @param vector3D
     * @param s
     * @return
     */
    public static float[] vector3DMult(float[] vector3D, float s) {
        assert vector3D.length == 3;
        return new float[]{vector3D[0] * s, vector3D[1] * s, vector3D[2] * s};
    }

    /**
     * Multiply two 3D vectors.
     *
     * @param vector3D_1
     * @param vector3D_2
     * @return
     */
    public static float[] vector3DMult(float[] vector3D_1, float[] vector3D_2) {
        assert vector3D_1.length == vector3D_2.length && vector3D_1.length == 3;
        return new float[]{vector3D_1[0] * vector3D_2[0], vector3D_1[1] * vector3D_2[1], vector3D_1[2] * vector3D_2[2]};
    }

    /**
     * Divide 3D vector by scalar.
     *
     * @param vector3D
     * @param s
     * @return
     */
    public static float[] vector3DDiv(float[] vector3D, float s) {
        assert vector3D.length == 3;
        return new float[]{vector3D[0] / s, vector3D[1] / s, vector3D[2] / s};
    }

    /**
     * Divide 3D vector by another 3D vector.
     *
     * @param vector3D_1
     * @param vector3D_2
     * @return
     */
    public static float[] vector3DDiv(float[] vector3D_1, float[] vector3D_2) {
        assert vector3D_1.length == vector3D_2.length && vector3D_1.length == 3;
        return new float[]{vector3D_1[0] / vector3D_2[0], vector3D_1[1] / vector3D_2[1], vector3D_1[2] / vector3D_2[2]};
    }

    /**
     * Calculate dot product of two 3D vectors.
     *
     * @param vector3D_1
     * @param vector3D_2
     * @return
     */
    public static float vector3DDot(float[] vector3D_1, float[] vector3D_2) {
        assert vector3D_1.length == vector3D_2.length && vector3D_1.length == 3;
        return vector3D_1[0] * vector3D_2[0] + vector3D_1[0] * vector3D_2[0] + vector3D_1[0] * vector3D_2[0];
    }

    /**
     * Calculate cross product of two 3D vectors.
     *
     * @param vector3D_1
     * @param vector3D_2
     * @return
     */
    public static float[] vector3DCross(float[] vector3D_1, float[] vector3D_2) {
        assert vector3D_1.length == vector3D_2.length && vector3D_1.length == 3;
        float[] cross = new float[3];
        cross[0] = vector3D_1[1] * vector3D_2[2] - vector3D_1[2] * vector3D_2[1];
        cross[1] = vector3D_1[2] * vector3D_2[0] - vector3D_1[0] * vector3D_2[2];
        cross[2] = vector3D_1[0] * vector3D_2[1] - vector3D_1[1] * vector3D_2[0];
        return cross;
    }

    /**
     * Calculate magnitude of a 3D vector.
     *
     * @param vector3D
     * @return
     */
    public static float vector3DMagnitude(float[] vector3D) {
        assert vector3D.length == 3;
        return (float) Math.sqrt(vector3D[0] * vector3D[0] + vector3D[1] * vector3D[1] + vector3D[2] * vector3D[2]);
    }

    /**
     * Create normalized version of a 3D vector.
     *
     * @param vector3D
     * @return
     */
    public static float[] vector3DNormalize(float[] vector3D) {
        assert vector3D.length == 3;
        float m = vector3DMagnitude(vector3D);
        return new float[]{vector3D[0] / m, vector3D[1] / m, vector3D[2] / m};
    }

    /**
     * Create projectio of a 3D vector on another 3D vector.
     *
     * @param vector3D_1
     * @param vector3D_2
     * @return
     */
    public static float[] vector3DProjection(float[] vector3D_1, float[] vector3D_2) {
        float[] normV2 = vector3DNormalize(vector3D_2);
        return vector3DMult(normV2, vector3DDot(vector3D_1, normV2));
    }

    /**
     * Transpose a 4x4 matrix.
     *
     * @param matrix4x4
     * @return
     */
    public static float[] transposeMatrix4x4(float[] matrix4x4) {
        return new float[]{
            matrix4x4[0], matrix4x4[4], matrix4x4[8], matrix4x4[12],
            matrix4x4[1], matrix4x4[5], matrix4x4[9], matrix4x4[13],
            matrix4x4[2], matrix4x4[6], matrix4x4[10], matrix4x4[14],
            matrix4x4[3], matrix4x4[7], matrix4x4[11], matrix4x4[15]
        };
    }

    /**
     * Transform a 3D vector by a 4x4 matrix.
     *
     * @param vector3D
     * @param matrix4x4
     * @return
     */
    public static float[] transformVector3DbyMatrix4x4(float[] vector3D, float[] matrix4x4) {
        float[] newVector = new float[3];
        newVector[0] =
            vector3D[0] * matrix4x4[0] + vector3D[1] * matrix4x4[4] + vector3D[2] * matrix4x4[8] + 1 * matrix4x4[12];
        newVector[1] =
            vector3D[0] * matrix4x4[1] + vector3D[1] * matrix4x4[5] + vector3D[2] * matrix4x4[9] + 1 * matrix4x4[13];
        newVector[2] =
            vector3D[0] * matrix4x4[2] + vector3D[1] * matrix4x4[6] + vector3D[2] * matrix4x4[10] + 1 * matrix4x4[14];
        return newVector;
    }

    /**
     * Multiply two 4x4 matrices.
     *
     * @param matrix4x4_1
     * @param matrix4x4_2
     * @return
     */
    public static float[] matrix4x4Mult(float[] matrix4x4_1, float[] matrix4x4_2) {
        float[] newMatrix4x4 = new float[16];
        newMatrix4x4[0] =
            matrix4x4_1[0] * matrix4x4_2[0] + matrix4x4_1[1] * matrix4x4_2[4] + matrix4x4_1[2] * matrix4x4_2[8] +
                matrix4x4_1[3] * matrix4x4_2[12];
        newMatrix4x4[1] =
            matrix4x4_1[0] * matrix4x4_2[1] + matrix4x4_1[1] * matrix4x4_2[5] + matrix4x4_1[2] * matrix4x4_2[9] +
                matrix4x4_1[3] * matrix4x4_2[13];
        newMatrix4x4[2] =
            matrix4x4_1[0] * matrix4x4_2[2] + matrix4x4_1[1] * matrix4x4_2[6] + matrix4x4_1[2] * matrix4x4_2[10] +
                matrix4x4_1[3] * matrix4x4_2[14];
        newMatrix4x4[3] =
            matrix4x4_1[0] * matrix4x4_2[3] + matrix4x4_1[1] * matrix4x4_2[7] + matrix4x4_1[2] * matrix4x4_2[11] +
                matrix4x4_1[3] * matrix4x4_2[15];

        newMatrix4x4[4] =
            matrix4x4_1[4] * matrix4x4_2[0] + matrix4x4_1[5] * matrix4x4_2[4] + matrix4x4_1[6] * matrix4x4_2[8] +
                matrix4x4_1[7] * matrix4x4_2[12];
        newMatrix4x4[5] =
            matrix4x4_1[4] * matrix4x4_2[1] + matrix4x4_1[5] * matrix4x4_2[5] + matrix4x4_1[6] * matrix4x4_2[9] +
                matrix4x4_1[7] * matrix4x4_2[13];
        newMatrix4x4[6] =
            matrix4x4_1[4] * matrix4x4_2[2] + matrix4x4_1[5] * matrix4x4_2[6] + matrix4x4_1[6] * matrix4x4_2[10] +
                matrix4x4_1[7] * matrix4x4_2[14];
        newMatrix4x4[7] =
            matrix4x4_1[4] * matrix4x4_2[3] + matrix4x4_1[5] * matrix4x4_2[7] + matrix4x4_1[6] * matrix4x4_2[11] +
                matrix4x4_1[7] * matrix4x4_2[15];

        newMatrix4x4[8] =
            matrix4x4_1[8] * matrix4x4_2[0] + matrix4x4_1[9] * matrix4x4_2[4] + matrix4x4_1[10] * matrix4x4_2[8] +
                matrix4x4_1[11] * matrix4x4_2[12];
        newMatrix4x4[9] =
            matrix4x4_1[8] * matrix4x4_2[1] + matrix4x4_1[9] * matrix4x4_2[5] + matrix4x4_1[10] * matrix4x4_2[9] +
                matrix4x4_1[11] * matrix4x4_2[13];
        newMatrix4x4[10] =
            matrix4x4_1[8] * matrix4x4_2[2] + matrix4x4_1[9] * matrix4x4_2[6] + matrix4x4_1[10] * matrix4x4_2[10] +
                matrix4x4_1[11] * matrix4x4_2[14];
        newMatrix4x4[11] =
            matrix4x4_1[8] * matrix4x4_2[3] + matrix4x4_1[9] * matrix4x4_2[7] + matrix4x4_1[10] * matrix4x4_2[11] +
                matrix4x4_1[11] * matrix4x4_2[15];

        newMatrix4x4[12] =
            matrix4x4_1[12] * matrix4x4_2[0] + matrix4x4_1[13] * matrix4x4_2[4] + matrix4x4_1[14] * matrix4x4_2[8] +
                matrix4x4_1[15] * matrix4x4_2[12];
        newMatrix4x4[13] =
            matrix4x4_1[12] * matrix4x4_2[1] + matrix4x4_1[13] * matrix4x4_2[5] + matrix4x4_1[14] * matrix4x4_2[9] +
                matrix4x4_1[15] * matrix4x4_2[13];
        newMatrix4x4[14] =
            matrix4x4_1[12] * matrix4x4_2[2] + matrix4x4_1[13] * matrix4x4_2[6] + matrix4x4_1[14] * matrix4x4_2[10] +
                matrix4x4_1[15] * matrix4x4_2[14];
        newMatrix4x4[15] =
            matrix4x4_1[12] * matrix4x4_2[3] + matrix4x4_1[13] * matrix4x4_2[7] + matrix4x4_1[14] * matrix4x4_2[11] +
                matrix4x4_1[15] * matrix4x4_2[15];
        return newMatrix4x4;
    }

    /**
     * Creates a 4x4 rotation matrix based on the axis-angle pair, thus rotating 'a' radians around an arbitrary axis
     * [ x y z ] using the following matrix:
     * <pre>
     *     nx^2(1-cos(a)) + cos(a)      nxny(1-cos(a)) + nz*sin(a)    nxnz(1-cos(a)) - ny*sin(a)
     *     nxny(1-cos(a)) - nz*sin(a)   ny^2(1-cos(a)) + cos(a)       nynz(1-cos(a)) + nx*sin(a)
     *     nxnz(1-cos(a)) + ny*sin(a)   nynz(1-cos(a)) - nx*sin(a)    nz^2(1-cos(a)) + cos(a)
     * </pre>
     *
     * @param angle angle in radians
     * @param axis axis to rotate around
     * @return the rotation matrix
     */
    public static float[] createAxisAngleRotationMatrix4x4(float angle, float[] axis) {
        float[] m4x4 = new float[16];
        float x = axis[0];
        float y = axis[1];
        float z = axis[2];
        double sin_a = sin(angle);
        double cos_a = cos(angle);

        double mag = sqrt(x * x + y * y + z * z);

        // Identity matrix
        if (mag == 0.0f) {
            loadIdentity(m4x4);
            return m4x4;
        }

        // Rotation matrix is normalized
        x /= mag;
        y /= mag;
        z /= mag;


        double nx_2 = x * x;
        double ny_2 = y * y;
        double nz_2 = z * z;
        double nxny = x * y;
        double nynz = y * z;
        double nznx = z * x;
        double nx_sin_a = x * sin_a;
        double ny_sin_a = y * sin_a;
        double nz_sin_a = z * sin_a;
        double one_cos_a = 1.0f - cos_a;

        // Set up matrix:
        //     nx^2(1-cos(a)) + cos(a)      nxny(1-cos(a)) + nz*sin(a)    nxnz(1-cos(a)) - ny*sin(a)
        //     nxny(1-cos(a)) - nz*sin(a)   ny^2(1-cos(a)) + cos(a)       nynz(1-cos(a)) + nx*sin(a)
        //     nxnz(1-cos(a)) + ny*sin(a)   nynz(1-cos(a)) - nx*sin(a)    nz^2(1-cos(a)) + cos(a)
        m4x4[0] = (float) ((one_cos_a * nx_2) + cos_a);
        m4x4[1] = (float) ((one_cos_a * nxny) + nz_sin_a);
        m4x4[2] = (float) ((one_cos_a * nznx) - ny_sin_a);

        m4x4[4] = (float) ((one_cos_a * nxny) - nz_sin_a);
        m4x4[5] = (float) ((one_cos_a * ny_2) + cos_a);
        m4x4[6] = (float) ((one_cos_a * nynz) + nx_sin_a);

        m4x4[8] = (float) ((one_cos_a * nznx) + ny_sin_a);
        m4x4[9] = (float) ((one_cos_a * nynz) - nx_sin_a);
        m4x4[10] = (float) ((one_cos_a * nz_2) + cos_a);

        return m4x4;
    }

    /**
     * Loads 4x4 identity matrix into the specified matrix.
     *
     * @param m4x4
     */
    public static void loadIdentity(float[] m4x4) {
        System.arraycopy(IDENDITY_4x4, 0, m4x4, 0, IDENDITY_4x4.length);
    }

    /**
     * Invert a 4x4 rotation matrix.
     *
     * @param m4x4
     * @return
     */
    public static float[] invertRotationMatrix4x4(float[] m4x4) {
        return transposeMatrix4x4(m4x4);
    }
}

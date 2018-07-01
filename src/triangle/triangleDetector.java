package triangle;

public class triangleDetector implements ItriangleDetector{
    public triangleType detect(int a, int b, int c)
    {
        if (a <= Math.abs((long)b - c) || a >= (long)b + c)//I convert int to long to handle Overflow issues of int type
            return triangleType.invalid;
        else if (a == b && b == c)
            return triangleType.equilateral;
        else if (a == b || b == c || a == c)
            return triangleType.isosceles;
        else
            return triangleType.scalene;
    }
}

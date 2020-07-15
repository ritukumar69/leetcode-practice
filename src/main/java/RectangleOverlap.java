/**
 * https://leetcode.com/problems/rectangle-overlap/
 * <p>
 * A rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) are the coordinates of its bottom-left corner,
 * and (x2, y2) are the coordinates of its top-right corner.
 * <p>
 * Two rectangles overlap if the area of their intersection is positive.  To be clear, two rectangles that only touch at the corner or edges do not overlap.
 * <p>
 * Given two (axis-aligned) rectangles, return whether they overlap.
 * <p>
 * Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * Output: true
 * <p>
 * Input: rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 * Output: false
 */
public class RectangleOverlap {
    //two rectangles will not overlap if rec1 is either left or right or top or bottom of rec2
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        boolean isLeft = rec1[2] <= rec2[0];
        boolean isRight = rec2[2] <= rec1[0];
        boolean isTop = rec1[1] >= rec2[3];
        boolean isBottom = rec1[3] <= rec2[1];
        return !(isLeft || isBottom || isTop || isRight); // if all these are false, then two rectangles overlap
    }
}

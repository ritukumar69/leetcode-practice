/**
 * https://leetcode.com/problems/ugly-number-ii/
 * <p>
 * Write a program to find the n-th ugly number.
 * <p>
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * <p>
 * Example:
 * <p>
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 */
public class UglyNumber2 {
    /**
     * The key is to realize each number can be and have to be generated by a former number multiplied by 2, 3 or 5
     * e.g.
     * 1 2 3 4 5 6 8 9 10 12 15..
     * what is next?
     * it must be x * 2 or y * 3 or z * 5, where x, y, z is an existing number.
     * <p>
     * How do we determine x, y, z then?
     * apparently, you can just traverse the sequence generated by far from 1 ... 15, until you find such x, y, z that x * 2, y * 3, z * 5
     * is just bigger than 15. In this case x=8, y=6, z=4. Then you compare x * 2, y * 3, z * 5 so you know next number will be x * 2 = 8 * 2 = 16.
     * k, now you have 1,2,3,4,....,15, 16,
     * <p>
     * Then what is next?
     * You wanna do the same process again to find the new x, y, z, but you realize, wait, do I have to
     * traverse the sequence generated by far again?
     * <p>
     * NO! since you know last time, x=8, y=6, z=4 and x=8 was used to generate 16, so this time, you can immediately know the new_x = 9
     * (the next number after 8 is 9 in the generated sequence), y=6, z=4.
     * Then you need to compare new_x * 2, y * 3, z * 5. You know next number is 9 * 2 = 18;
     * <p>
     * And you also know, the next x will be 10 since new_x = 9 was used this time.
     * But what is next y? apparently, if y=6, 6*3 = 18, which is already generated in this round. So you also need to update next y from 6 to 8.
     * <p>
     * Based on the idea above, you can actually generated x,y,z from very beginning, and update x, y, z accordingly. It ends up with a O(n) solution.
     */
    public int nthUglyNumber(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        int two_index = 0;
        int three_index = 0;
        int five_index = 0;
        for (int i = 0; i < n; i++) {
            int by2 = res[two_index] * 2;
            int by3 = res[three_index] * 3;
            int by5 = res[five_index] * 5;
            int min = Math.min(by2, Math.min(by3, by5));
            if (min == by2) {
                two_index++;
            }
            if (min == by3) {
                three_index++;
            }
            if (min == by5) {
                five_index++;
            }
            res[i + 1] = min; //since we are doing i+1, we need array of size n+1
        }
        return res[n - 1];
    }
}
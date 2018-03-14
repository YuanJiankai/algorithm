package hard;

public class problem_4_1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0.0;
        if(nums1.length + nums2.length == 0) {
            return result;
        }
        if(nums1.length == 0) {
            return (double) (nums2.length % 2 == 0 ? nums2[nums2.length / 2 + nums2.length / 2 - 1] : nums2[nums2.length / 2]);
        } else if(nums2.length == 0) {
            return (double) (nums1.length % 2 == 0 ? nums1[nums1.length / 2 + nums1.length / 2 - 1] : nums1[nums1.length / 2]);
        }

        

    }
}

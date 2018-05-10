package hard;

public class Problem_4_2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) { // 87ms
        if(nums1.length == 0 || nums2.length == 0) {
            return findMedianByOneArray(nums1.length == 0 ? nums2 : nums1);
        }
        int len1 = nums1.length;
        int len2 = nums2.length;
        int n[], m[];
        if(len1 < len2) {
            n = nums1;
            m = nums2;
        } else {
            n = nums2;
            m = nums1;
            len1 = n.length;
            len2 = m.length;
        }
        int i = len1;
        int j = (len1 + len2 + 1) / 2 - i;
        while(i > 0 && n[i - 1] > m[j]) {
            i--;
            j++;
        }
        double max, min;
        max = Math.max(i == 0 ? Integer.MIN_VALUE :  n[i - 1], j == 0 ? Integer.MIN_VALUE : m[j - 1]);
        if((len1 + len2) % 2 == 0) {
            min = Math.min(i == len1 ? Integer.MAX_VALUE : n[i], j == len2 ? Integer.MAX_VALUE : m[j]);
            return (max + min) / 2;
        } else {
            return max;
        }
    }
    // 时间 86ms
    /*
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0) {
            return findMedianByOneArray(nums1.length == 0 ? nums2 : nums1);
        }
        int len1 = nums1.length;
        int len2 = nums2.length;
        int n[], m[];
        if(len1 < len2) {
            n = nums1;
            m = nums2;
        } else {
            n = nums2;
            m = nums1;
            len1 = n.length;
            len2 = m.length;
        }
        int i = len1;
        int j = (len1 + len2 + 1) / 2 - i;
        while(n[i - 1] > m[j]) {
            i--;
            j++;
            if(i == 0) {
                break;
            }
        }
        double max, min;
        if(i == 0) {
            max = m[j - 1];
        } else if(j == 0) {
            max = n[i - 1];
        } else {
            max = Math.max(n[i - 1], m[j - 1]);
        }
        if((len1 + len2) % 2 == 0) {
            if(i == len1) {
                min = m[j];
            } else if(j == len2) {
                min = n[i];
            } else {
                min = Math.min(n[i], m[j]);
            }
            return (max + min) / 2;
        } else {
            return max;
        }
    }*/
    public double findMedianByOneArray(int[] nums) {
        if (nums.length % 2 == 0) {
            return (double) (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2.0;
        } else {
            return (double) nums[nums.length / 2];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Problem_4_2().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }
}

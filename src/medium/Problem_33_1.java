package medium;

/**
 * 速度上没有优势 , 采用的是二分的手法 其实速度上已经可以满足要求了 可能就是复杂的判断有点多 这个需要注意一下
 * 34 和他类似我就一起放在这了
 */
public class Problem_33_1 {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        int i = 0;
        int j = len - 1; // 这个是标记二分到哪里了
        int start = nums[i];
        int end = nums[j];// 这个标记的是左边最小和右边最大的
        while (i <= j) {
            int mid = (i + j) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[mid] >= start) {
                if (target < nums[mid] && target >= start) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= end) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 这是我一开始做的想法, 就是很单纯的用二分找到一个index然后向右和向左找相同的数
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int[] range = new int[]{-1, -1};
        if (len == 0) {
            return range;
        }
        int i = 0;
        int j = len - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] == target) {
                range[0] = mid;
                range[1] = mid;
                break;
            }
            if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        if (range[0] == -1) {
            return range;
        } else {
            while (range[0] > 0) {
                if (nums[range[0] - 1] == target) {
                    range[0]--;
                } else {
                    break;
                }
            }
            while (range[1] < len - 1) {
                if (nums[range[1] + 1] == target) {
                    range[1]++;
                } else {
                    break;
                }
            }
        }
        return range;
    }
    public int[] searchRange2(int[] nums, int target) {
        int len = nums.length;
        int[] range = new int[]{-1, -1};
        if (len == 0) {
            return range;
        }
        int i = 0;
        int j = len - 1;
        /**
         * 找左边界
         */
        while(i <= j) {
            if(i == j) {
                if(nums[i] == target) {
                    range[0] = i;
                }
                break;
            }
            int mid = (i + j) >> 1;
            if(target <= nums[mid]) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        if(range[0] == -1) {
            return range;
        }
        i = 0; j = len - 1;
        while(i <= j) {
            if(i == j) {
                if(nums[i] == target) {
                    range[1] = i;
                }
                break;
            }
            int mid = (i + j) % 2 == 0 ? (i + j) >> 1 : (((i + j) >> 1) + 1);
            if(target < nums[mid]) {
                j = mid - 1;
            } else {
                i = mid;
            }
        }
        return range;
    }


    public static void main(String[] args) {
        System.out.println(new Problem_33_1().searchRange2(new int[]{5,7,7,8,8,10}, 6)[1]);
    }
}

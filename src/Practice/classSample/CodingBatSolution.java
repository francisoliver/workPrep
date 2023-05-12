package Practice.classSample;

public class CodingBatSolution {
    public boolean array123(int[] nums) {
        int len = nums.length;
        if(len < 3) return false;
        boolean found = false;
        for(int n = 0; n < len - 2; n++) {
            if(1 == nums[n] && 2 == nums[n + 1] && 3 == nums[n+2]) {
                found = true;
            }
        }
        return found;
    }

    public String altPairs(String str) {
        int len = str.length();
        StringBuilder sb = new StringBuilder();
        for(int n = 0; n < len ; n+=4) {
            int end = Math.min(2, len - n);
            sb.append(str.substring(n, n + end));
        }
        return sb.toString();
    }


}

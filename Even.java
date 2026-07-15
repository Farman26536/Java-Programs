 public class Even {
    public int findNumbers(int[] nums) {
        int evenCount = 0;

        for (int i = 0; i < nums.length; i++) {

            int number = nums[i];
            int digitCount = 0;

            
            while (number > 0) {
                digitCount++;
                number = number / 10;
            }

        
            if (digitCount % 2 == 0) {
                evenCount++;
            }
        }

        return evenCount;
    }
}
        

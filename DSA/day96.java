class Solution {
    public int trailingZeroes(int n) {
          //To determine the number of trailing zeroes in ( n! ) (the factorial of ( n )),
          // we need to count how many times 10 divides into ( n! ).
          //Since 10 is made up of the prime factors 2 and 5, and there are typically more factors of 2 than 5, 
          //the number of trailing zeroes is determined by the number of times 5 is a factor. 
          //This is because every factor of 5 can pair with a factor of 2 to form a trailing zero.

           int fives = 0;
        for (int i = 5; i <= n; i *= 5) {
            fives += n / i;
        }
        return fives;
    }
}

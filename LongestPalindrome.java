package longest_palindrom;

public class LongestPalindrome {
    private final String inputString;
    private boolean[][] memo;
    private final int length;

    public LongestPalindrome(String inputString){
        this.inputString = inputString;
        this.length = inputString.length();
        this.memo = new boolean[length][length];
    }

    public String calculate(){
        if(inputString.length() == 1)
            return inputString;
        if(inputString.equals("")){
            System.out.println("Empty string");
            return "";
        }
        initMemo();
        fillMemo();
        //printMemo();
        return findLongest();
    }

    //filling first two diagonals ( fillMemo() works from substr.length==2 )
    private void initMemo(){
        for(int i = 0; i < length; i++){
            memo[i][i] = true;
        }

        for(int i = 0; i < length - 1; i++){
            if(inputString.charAt(i) == inputString.charAt(i + 1)){
                memo[i][i + 1] = true;
            }else{
                memo[i][i + 1] = false;
            }
        }
    }

    //calculating all possible palindromes (based on dynamic algorithm)
    private void fillMemo(){
        for(int i = 0; i < length - 2; i++){
            for(int j = 0; j < length - i - 2; j++){
                if(memo[j + 1][j + i + 1] && inputString.charAt(j) == inputString.charAt(j + i + 2)){
                    memo[j][j + i + 2] = true;
                }else{
                    memo[j][j + i + 2] = false;
                }
            }
        }
    }

    //find the longest palindrome in memo[][]
    private String findLongest(){
        int start = 0;
        int end = 0;
        for(int i = 0; i < length - 1; i++){
            for(int j = i + 1; j < length; j++){
                if(memo[i][j] && j - i > end - start){
                    start = i;
                    end = j;
                }
            }
        }

        return inputString.substring(start, end + 1);
    }

    //print memo array
    private void printMemo(){
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                System.out.print(memo[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }
}

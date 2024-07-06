public class Bit {

    public static void oddEven(int n){
        if ((n & 1) == 1) {
            System.out.println("Odd");
        } else {
            System.out.println("Even");
        }
    }

    public static int getIthBit(int num, int i){
        int mask = 1<<i;
        int res = num & mask;

        if(res == 0){
            return 0;
        } else {
            return 1;
        }
    }

    public static int setIthBit(int num, int i){
        int mask = 1<<i;
        return num | mask;
    }

    public static int clearIthBit(int num, int i){
        int mask = ~(1<<i);
        return num & mask;
    }

    public static int updateIthBit(int num, int i, int newBit){
        if (newBit == 1) {
            return setIthBit(num, i);
        } else {
            return clearIthBit(num, i);
        }
    }

    public static int clearLastIBits(int n, int i){
        int mask = (~0)<<i;
        return (n&mask);
    }

    public static int clearRangeOfBits(int n, int i, int j){
        int a = (~0)<<j+1;
        int b = 1<<i - 1;
        int mask = a|b;
        return (n&mask);
    }

    public static boolean checkPower(int n){
        return (n&(n-1))==0;
    }
    //handles n>0

    public static int countSetBits(int n){
        int count=0;
        while(n!=0){
            count += (n&1);
            n>>=1;
        }
        return count;
    }

    public static int exponent(int b, int p){
        int ans = 1;
        while(p!=0){
            ans = (p&1)==1 ? ans*b : ans*1;
            b*=b;
            p>>=1;
        }
        return ans;
    }

    
    public static void main(String[] args) {

        oddEven(20000016);

        System.out.println(getIthBit(5, 2));

        System.out.println(setIthBit(5, 1));

        System.out.println(clearIthBit(7, 0));

        System.out.println(updateIthBit(7, 2, 0));

        System.out.println(clearLastIBits(15, 0));

        System.out.println(clearRangeOfBits(18, 2, 4));

        System.out.println(checkPower(33));
        
        System.out.println(countSetBits(1));

        System.out.println(exponent(3, 5));
    }
}

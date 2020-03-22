package src.yahait.level2;

public class JumpAndTeleport {
	public static void main(String[] args){
		JumpAndTeleport obj = new JumpAndTeleport();
		System.out.println(obj.solution(10));
		System.out.println(Integer.bitCount(10));
	}
	public int solution(int n) {
		int ans = 0;
        while(n >0){
            ans += n%2;
            n /= 2;
        }

        return ans;
    }
}

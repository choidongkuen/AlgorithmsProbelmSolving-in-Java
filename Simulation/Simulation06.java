import java.util.*;

public class Simulation06 {

    // 북,동,남,서 순으로 dx, dy를 정의한다.
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};
    public static int x = 0;
    public static int y = 0; // 초기 위치

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        int n = sc.nextInt();
        // n번 진행
        for(int i = 0 ; i < n; i++){
            // 방향과 거리 입력
            char dir = sc.next().charAt(0);
            int dis = sc.nextInt();

            int x; // 방향
            if(dir == 'N')
                x = 0;
            else if(dir == 'E')
                x = 1;
            else if(dir == 'S')
                x = 2;
            else
                x = 3;

            x += dx[x] * dis;
            y += dy[y] * dis;
        }
        System.out.println(x+" "+y);
    }
}
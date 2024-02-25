package programmers;

public class level1_250137 {
    public int solution(int[] bandage, int health, int[][] attacks) {
        //시작 시간
        int time = 1;
        //현재 체력(최종 출력값)
        int answer = health;

        for(int i = 0; i < attacks.length; i++) {
            //붕대 연속감기 성공시간
            int x = attacks[i][0] - time;
            answer += (x * bandage[1]) + ((x/bandage[0])*bandage[2]);

            //최대체력보다 현재 체력이 클 경우
            if(answer > health)
                answer = health;


            answer -= attacks[i][1];

            //현재 체력이 0 이하일 경우
            if(answer <= 0) {
                answer = -1;
                break;
            }
            time = attacks[i][0] + 1;
        }
        return answer;
    }
}

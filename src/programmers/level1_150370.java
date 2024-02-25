package programmers;

import java.util.ArrayList;
import java.util.List;

public class level1_150370 {

    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();

        for(int i = 0; i < privacies.length; i++) {
            String[] s = privacies[i].split(" ");

            for(int j = 0; j < terms.length; j++) {

                String[] tmp = terms[j].split(" ");

                if(!tmp[0].equals(s[1])) continue;

                String[] date = s[0].split("\\.");

                int y = Integer.parseInt(date[0]);
                int m = Integer.parseInt(date[1]);
                int d = Integer.parseInt(date[2]);

                y += (Integer.parseInt(tmp[1])/12);
                m += (Integer.parseInt(tmp[1])%12);
                d -= 1;

                if(m > 12) {
                    m -= 12;
                    y ++;
                }
                if(d == 0) {
                    m -= 1;
                    d = 28;
                }

                String[] arrToday = today.split("\\.");

                int todayY = Integer.parseInt(arrToday[0]);
                int todayM = Integer.parseInt(arrToday[1]);
                int todayD = Integer.parseInt(arrToday[2]);

                if(y > todayY) break;
                else if(y < todayY) {
                    answer.add(i+1);
                    break;
                }
                if(m > todayM) break;
                else if(m < todayM) {
                    answer.add(i+1);
                    break;
                }
                if(d >= todayD) break;

                answer.add(i+1);
                break;

            }
        }

        int[] result = new int[answer.size()];

        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }
}

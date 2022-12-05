package programmers;

import java.util.HashMap;
import java.util.Map;

public class level2_42888 {

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        String[][] comment = new String[record.length][];
        Map<String,String> member = new HashMap<>();

        int i = 0;
        int count = 0;
        for (String s: record) {
            comment[i] = s.split(" ");
            if(!comment[i][0].equals("Change")) {
                count++;
                if(comment[i][0].equals("Enter"))
                    member.put(comment[i][1],comment[i][2]);

            }
            else
                member.replace(comment[i][1], comment[i][2]);

            i++;
        }

        String[] answer = new String[count];
        i = 0;

        for (String[] s: comment) {
            if(!s[0].equals("Change")) {
                if(s[0].equals("Enter")){
                    answer[i] = member.get(s[1])+"님이 들어왔습니다.";
                }
                else{
                    answer[i] = member.get(s[1])+"님이 나갔습니다.";
                }
                i++;
            }
        }
    }
}

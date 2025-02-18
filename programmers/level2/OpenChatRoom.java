import java.util.*;
import java.util.stream.*;

class Solution {
    static List<Message> list = new ArrayList<>();
    static Map<String, String> map = new HashMap<>();

    enum Type {
        ENTER, LEAVE;
    }
    static class Message {
        String userId;
        Type type;

        public Message(String userId, Type type) {
            this.userId = userId;
            this.type = type;
        }

        public String convert() {
            if(type.equals(Type.ENTER)) {
                return map.get(this.userId) + "님이 들어왔습니다.";
            } else {
                return map.get(this.userId) + "님이 나갔습니다.";
            }
        }
    }

    public String[] solution(String[] record) {
        for(String x : record) {
            if(x.startsWith("Enter")) {
                String[] arr = x.split(" ");
                map.put(arr[1], arr[2]);
                list.add(new Message(arr[1], Type.ENTER));
            } else if(x.startsWith("Leave")) {
                String[] arr = x.split(" ");
                list.add(new Message(arr[1], Type.LEAVE));
            } else {
                String[] arr = x.split(" ");
                map.put(arr[1], arr[2]);
            }
        }
        return list.stream().map(Message::convert).toArray(String[]::new);
    }
}

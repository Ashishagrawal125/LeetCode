// Last updated: 4/14/2026, 4:42:28 PM
import java.util.*;

class Solution {
    static class OfflineUser {
        int returnTimestamp;
        int userId;
        OfflineUser(int r, int u) { returnTimestamp = r; userId = u; }
    }

    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] ans = new int[numberOfUsers];
        boolean[] online = new boolean[numberOfUsers];
        Arrays.fill(online, true);
        PriorityQueue<OfflineUser> offlineQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.returnTimestamp));
        int allMentionsCount = 0;
        events.sort((a, b) -> {
            int ta = Integer.parseInt(a.get(1));
            int tb = Integer.parseInt(b.get(1));
            if (ta != tb) return Integer.compare(ta, tb);
            return b.get(0).compareTo(a.get(0));
        });
        for (List<String> event : events) {
            String eventType = event.get(0);
            int timestamp = Integer.parseInt(event.get(1));
            while (!offlineQueue.isEmpty() && offlineQueue.peek().returnTimestamp <= timestamp)
                online[offlineQueue.poll().userId] = true;
            if (eventType.equals("MESSAGE")) {
                String mentionsString = event.get(2);
                if (mentionsString.equals("ALL")) {
                    allMentionsCount++;
                } else if (mentionsString.equals("HERE")) {
                    for (int uid = 0; uid < numberOfUsers; uid++)
                        if (online[uid]) ans[uid]++;
                } else {
                    for (String part : mentionsString.split(" ")) {
                        if (part.length() > 2 && part.startsWith("id")) {
                            int uid = Integer.parseInt(part.substring(2));
                            if (uid >= 0 && uid < numberOfUsers) ans[uid]++;
                        }
                    }
                }
            } else if (eventType.equals("OFFLINE")) {
                int uid = Integer.parseInt(event.get(2));
                if (uid >= 0 && uid < numberOfUsers) {
                    online[uid] = false;
                    offlineQueue.offer(new OfflineUser(timestamp + 60, uid));
                }
            }
        }
        for (int i = 0; i < numberOfUsers; i++) ans[i] += allMentionsCount;
        return ans;
    }
}

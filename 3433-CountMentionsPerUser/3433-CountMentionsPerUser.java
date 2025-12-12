// Last updated: 12/12/2025, 11:54:50 AM
1import java.util.*;
2
3class Solution {
4    static class OfflineUser {
5        int returnTimestamp;
6        int userId;
7        OfflineUser(int r, int u) { returnTimestamp = r; userId = u; }
8    }
9
10    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
11        int[] ans = new int[numberOfUsers];
12        boolean[] online = new boolean[numberOfUsers];
13        Arrays.fill(online, true);
14        PriorityQueue<OfflineUser> offlineQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.returnTimestamp));
15        int allMentionsCount = 0;
16        events.sort((a, b) -> {
17            int ta = Integer.parseInt(a.get(1));
18            int tb = Integer.parseInt(b.get(1));
19            if (ta != tb) return Integer.compare(ta, tb);
20            return b.get(0).compareTo(a.get(0));
21        });
22        for (List<String> event : events) {
23            String eventType = event.get(0);
24            int timestamp = Integer.parseInt(event.get(1));
25            while (!offlineQueue.isEmpty() && offlineQueue.peek().returnTimestamp <= timestamp)
26                online[offlineQueue.poll().userId] = true;
27            if (eventType.equals("MESSAGE")) {
28                String mentionsString = event.get(2);
29                if (mentionsString.equals("ALL")) {
30                    allMentionsCount++;
31                } else if (mentionsString.equals("HERE")) {
32                    for (int uid = 0; uid < numberOfUsers; uid++)
33                        if (online[uid]) ans[uid]++;
34                } else {
35                    for (String part : mentionsString.split(" ")) {
36                        if (part.length() > 2 && part.startsWith("id")) {
37                            int uid = Integer.parseInt(part.substring(2));
38                            if (uid >= 0 && uid < numberOfUsers) ans[uid]++;
39                        }
40                    }
41                }
42            } else if (eventType.equals("OFFLINE")) {
43                int uid = Integer.parseInt(event.get(2));
44                if (uid >= 0 && uid < numberOfUsers) {
45                    online[uid] = false;
46                    offlineQueue.offer(new OfflineUser(timestamp + 60, uid));
47                }
48            }
49        }
50        for (int i = 0; i < numberOfUsers; i++) ans[i] += allMentionsCount;
51        return ans;
52    }
53}
54
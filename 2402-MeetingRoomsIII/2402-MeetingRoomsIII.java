// Last updated: 12/28/2025, 8:20:00 PM
1class Solution {
2    public int mostBooked(int n, int[][] meetings) {
3        long[] roomAvailabilityTime = new long[n];
4        int[] meetingCount = new int[n];
5        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
6
7        for (int[] meeting : meetings) {
8            int start = meeting[0], end = meeting[1];
9            long minRoomAvailabilityTime = Long.MAX_VALUE;
10            int minAvailableTimeRoom = 0;
11            boolean foundUnusedRoom = false;
12
13            for (int i = 0; i < n; i++) {
14                if (roomAvailabilityTime[i] <= start) {
15                    foundUnusedRoom = true;
16                    meetingCount[i]++;
17                    roomAvailabilityTime[i] = end;
18                    break;
19                }
20
21                if (minRoomAvailabilityTime > roomAvailabilityTime[i]) {
22                    minRoomAvailabilityTime = roomAvailabilityTime[i];
23                    minAvailableTimeRoom = i;
24                }
25            }
26
27            if (!foundUnusedRoom) {
28                roomAvailabilityTime[minAvailableTimeRoom] += end - start;
29                meetingCount[minAvailableTimeRoom]++;
30            }
31        }
32
33        int maxMeetingCount = 0, maxMeetingCountRoom = 0;
34        for (int i = 0; i < n; i++) {
35            if (meetingCount[i] > maxMeetingCount) {
36                maxMeetingCount = meetingCount[i];
37                maxMeetingCountRoom = i;
38            }
39        }
40
41        return maxMeetingCountRoom;
42    }
43}
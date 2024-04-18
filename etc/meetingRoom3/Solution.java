import java.util.*;

public class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int time = 0;
        int meetingSuceesCount = 0;
        int[] roomCount = new int[n];
        long minOpenedTime = 500000;
        int minOpenedTimeIndex = 0;
        long[] roomEndTime = new long[n];
        int maxIndex = 0;
        int max = 0;

        HashMap<Integer, Integer> meetingHashMap = new HashMap<Integer, Integer>();
        ArrayList<Integer> sortedMeetingUseTime = new ArrayList<Integer>();
        ArrayList<Integer> sortedMeetingStartTime = new ArrayList<Integer>();

        for (int i = 0; i < meetings.length; i++) {
            meetingHashMap.put(meetings[i][0], meetings[i][1]);
        }

        int sortingCount = 0;

        System.out.println("hashMap 정렬 완료");

        List<Integer> meetingStartTimeKey = new ArrayList<Integer>(meetingHashMap.keySet());

        Collections.sort(meetingStartTimeKey);

        System.out.println("sorted list 정렬 완료");

        // System.out.println("length: " + meetings.length);
        // while(sortingCount < meetings.length){
        // if( meetingHashMap.containsKey(time)){
        // sortedMeetingUseTime.add(meetingHashMap.get(time) - time);
        // sortedMeetingStartTime.add(time);
        //
        // sortingCount += 1;
        // }
        // time += 1;
        // }

        // System.out.println("정렬 완료 " + meetings.length);

        // for(int i=0; i < meetingStartTimeKey.getFirst(); i++){ // 첫 시작 최적화
        // roomEndTime[i] = meetingStartTimeKey.getFirst();
        // }

        // System.out.println("정렬 완료" + meetingStartTimeKey.getFirst());

        while (meetingSuceesCount < meetings.length) {
            for (int j = 0; j < n; j++) {
                // System.out.println("방 넘버 : " +j +" 끝나는 시간: " + roomEndTime[j] + " /index: " +
                // minOpenedTimeIndex);
                if (j == 0) {
                    minOpenedTime = roomEndTime[j];
                    minOpenedTimeIndex = 0;
                } else if (roomEndTime[j] < minOpenedTime) {
                    minOpenedTime = roomEndTime[j];
                    minOpenedTimeIndex = j;
                }
            }

            // System.out.println("미팅 번호: " +meetingSuceesCount + "/ 미팅 시작시간:"
            // +meetingStartTimeKey.get(meetingSuceesCount) + "/ 제일 빠른 미팅 끝 시간: "
            // +roomEndTime[minOpenedTimeIndex]);
            if (roomEndTime[minOpenedTimeIndex] < meetingStartTimeKey.get(meetingSuceesCount)) {
                // roomEndTime[minOpenedTimeIndex] += 1;
                System.out.println("최적화 정도: "
                        + (meetingStartTimeKey.get(meetingSuceesCount) + " " + roomEndTime[minOpenedTimeIndex]));
                for (int i = 0; i < n; i++) {
                    if (roomEndTime[i] < meetingStartTimeKey.get(meetingSuceesCount)) {
                        roomEndTime[i] = meetingStartTimeKey.get(meetingSuceesCount);

                    }
                }
            } else {
                roomEndTime[minOpenedTimeIndex] += meetingHashMap.get(meetingStartTimeKey.get(meetingSuceesCount))
                        - meetingStartTimeKey.get(meetingSuceesCount);
                roomCount[minOpenedTimeIndex] += 1;
                // System.out.println("success count : " + meetingSuceesCount + " " +
                // meetingStartTimeKey.get(meetingSuceesCount) + " " +
                // meetingHashMap.get(meetingStartTimeKey.get(meetingSuceesCount)));
                meetingSuceesCount += 1;
            }
        }

        for (int i = 0; i < n; i++) {
            // System.out.println(roomCount[i]);
            if (max < roomCount[i]) {
                maxIndex = i;
                max = roomCount[i];

            }
            System.out.println(roomEndTime[i]);
        }

        return maxIndex;
    }
}

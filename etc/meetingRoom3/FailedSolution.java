import java.util.*;

public class FailedSolution {
    public int mostBooked(int n, int[][] meetings) {
        int time = 0;
        int currentRoomIndex = 0;
        int meetingSuceesCount = 0;
        int[] roomCount = new int[n];
        int[] roomTime = new int[n];
        int maxIndex = 0;
        int max = 0;

        // ArrayList<Boolean> roomClosed = new ArrayList<Boolean>(Arrays.asList(new
        // Boolean[n]));
        // Collections.fill(roomClosed, Boolean.FALSE);
        boolean[] roomClosed = new boolean[n];
        ArrayList<Integer> roomUseTime = new ArrayList<Integer>(Arrays.asList(new Integer[n]));

        HashMap<Integer, Integer> meetingHashMap = new HashMap<Integer, Integer>();
        ArrayList<Integer> sortedMeetingUseTime = new ArrayList<Integer>();
        ArrayList<Integer> sortedMeetingStartTime = new ArrayList<Integer>();

        for (int i = 0; i < meetings.length; i++) {
            meetingHashMap.put(meetings[i][0], meetings[i][1]);
        }

        int sortingCount = 0;

        // System.out.println("length: " + meetings.length);
        while (sortingCount < meetings.length) {
            if (meetingHashMap.containsKey(time)) {
                sortedMeetingUseTime.add(meetingHashMap.get(time) - time);
                sortedMeetingStartTime.add(time);

                sortingCount += 1;
            }
            time += 1;
        }

        time = 0;

        System.out.println("정렬 완료");

        while (meetingSuceesCount < meetings.length) {
            if (roomClosed[currentRoomIndex]) {
                roomTime[currentRoomIndex] += 1;

                if (roomTime[currentRoomIndex] == roomUseTime.get(currentRoomIndex)) { // 회의 끝
                    // System.out.println("시간: "+ time +" 회의 끝" + (currentRoomIndex) +"번 룸 " +
                    // roomUseTime.get(currentRoomIndex) + "시간 사용");
                    roomClosed[currentRoomIndex] = false;
                    roomUseTime.set(currentRoomIndex, 0);
                    roomTime[currentRoomIndex] = 0;
                }
            }

            if (sortedMeetingStartTime.get(meetingSuceesCount) <= time && !roomClosed[currentRoomIndex]) {
                // System.out.println("시간: "+ time +" 회의실 배정" + (currentRoomIndex) + "/ 미팅 번호:
                // "+ (meetingSuceesCount+1) + " 미팅 원래 시작 시간:" +
                // sortedMeetingStartTime.get(meetingSuceesCount));
                roomClosed[currentRoomIndex] = true;
                roomTime[currentRoomIndex] = 0;
                roomUseTime.set(currentRoomIndex, sortedMeetingUseTime.get(meetingSuceesCount));
                meetingSuceesCount += 1;
                roomCount[currentRoomIndex] += 1;
            }

            if (currentRoomIndex == n - 1) {
                currentRoomIndex = 0;
                time += 1;
            } else {
                currentRoomIndex += 1;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(roomCount[i]);
            if (max < roomCount[i]) {
                maxIndex = i;
                max = roomCount[i];

            }
        }

        return maxIndex;
    }
}

// public int mostBooked(int n, int[][] meetings) {
// int[] priority = new int[n];
// int time =0;
// int currentRoomIndex = 0;
// int meetingSuceesCount = 0;
// int[] roomCount = new int[n];
// int[] roomTime = new int[n];
// int maxIndex=0;
// int max=0;
//
// ArrayList<Boolean> roomClosed = new ArrayList<Boolean>(Arrays.asList(new
// Boolean[n]));
// ArrayList<Integer> roomUseTime = new ArrayList<Integer>(Arrays.asList(new
// Integer[n]));
// Collections.fill(roomClosed, Boolean.FALSE);
//
//
//
// while(meetingSuceesCount < meetings.length){
// if( roomClosed.get(currentRoomIndex).equals(Boolean.TRUE)){
// roomTime[currentRoomIndex] += 1;
//
// if(roomTime[currentRoomIndex] == roomUseTime.get(currentRoomIndex)){ //회의 끝
// System.out.println("시간: "+ time +" 회의 끝" + (currentRoomIndex) +"번 룸 " +
// roomUseTime.get(currentRoomIndex) + "시간 사용");
// roomClosed.set(currentRoomIndex, Boolean.FALSE);
// roomUseTime.set(currentRoomIndex, 0);
// roomTime[currentRoomIndex] = 0;
// }
// }
//
// if( meetings[meetingSuceesCount][0] <= time &&
// roomClosed.get(currentRoomIndex).equals(Boolean.FALSE)){
// System.out.println("시간: "+ time +" 회의실 배정" + (currentRoomIndex) + "/ 미팅 번호:
// "+ (meetingSuceesCount+1));
// roomClosed.set(currentRoomIndex, Boolean.TRUE);
// roomTime[currentRoomIndex] = 0;
// roomUseTime.set(currentRoomIndex, meetings[meetingSuceesCount][1] -
// meetings[meetingSuceesCount][0]);
// meetingSuceesCount += 1;
//
// roomCount[currentRoomIndex] += 1;
// }
//
// if(currentRoomIndex == n-1){
// currentRoomIndex = 0;
// time += 1;
// //System.out.println("시간 흐름" + time);
// }else{
// currentRoomIndex += 1;
// }
// }
//
// for(int i=0; i < n; i++){
// System.out.println(roomCount[i]);
// if(max < roomCount[i]){
// maxIndex = i;
// max= roomCount[i];
//
// }
// }
//
// return maxIndex;
// }

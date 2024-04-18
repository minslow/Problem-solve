import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Main myMain = new Main();

        myMain.run();
    }

    public void run() {
        int roomNum;
        int[][] meetings;
        int index = 0;
        int meetingIndex = 0;
        String meet;

        Scanner scanner = new Scanner(System.in);

        roomNum = scanner.nextInt();
        scanner.nextLine();
        // 66550
        meetings = new int[69907][2];

        meet = scanner.nextLine();

        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(meet);

        while (true) {
            if (matcher.find()) {
                try {
                    if (index % 2 == 0) {
                        meetings[meetingIndex][0] = Integer.parseInt(matcher.group());

                    } else {
                        meetings[meetingIndex][1] = Integer.parseInt(matcher.group());

                        meetingIndex += 1;
                    }
                    index += 1;
                } catch (Exception e) {

                }

            } else {

                break;
            }

        }

        System.out.println("시작");

        Solution solution = new Solution();

        System.out.println("끝" + solution.mostBooked(roomNum, meetings));
    }
}

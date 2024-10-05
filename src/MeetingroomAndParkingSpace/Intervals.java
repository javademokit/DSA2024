package MeetingroomAndParkingSpace;

import java.util.*;
//Definition for an interval.
public class Intervals {
  int start;
  int end;

  Intervals() {
    start = 0;
    end = 0;
  }

  Intervals(int s, int e) {
    start = s;
    end = e;
  }
}

class Solution {
  public boolean canAttendMeetings(Intervals[] intervals) {
    // sort the intervals by start time
    Arrays.sort(intervals, new Comparator<Intervals>() {
      public int compare(Intervals i1, Intervals i2) {
        return i1.start - i2.start;
      }
    });

    // check for overlapping intervals
    for (int i = 0; i < intervals.length - 1; i++) {
      if (intervals[i].end > intervals[i + 1].start) {
        return false;
      }
    }

    return true;
  }
}
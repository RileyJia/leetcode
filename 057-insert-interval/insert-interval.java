// Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
//
// You may assume that the intervals were initially sorted according to their start times.
//
//
// Example 1:
// Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
//
//
//
// Example 2:
// Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
//
//
//
// This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
//


/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();

        if (intervals.size() == 0) {
            result.add(newInterval);
            return result;
        }

        int[] head = new int[intervals.size() + 1];
        int[] tail = new int[intervals.size() + 1];

        for (int i = 0; i < intervals.size(); i++){
            head[i] = intervals.get(i).start;
            tail[i] = intervals.get(i).end;
        }

        head[intervals.size()] = newInterval.start;
        tail[intervals.size()] = newInterval.end;

        Arrays.sort(head);
        Arrays.sort(tail);

        int h = head[0];
        int t = tail[0];
        for (int i = 1; i < head.length; i++){
            if (t < head[i]) {
                result.add(new Interval(h,t));
                h = head[i];
                t = tail[i];
            } else {
                if (head[i] < h) h = head[i];
                if (tail[i] > t) t = tail[i];
            }
            if (i == head.length - 1) result.add(new Interval(h,t));
        }
        return result;
    }
}

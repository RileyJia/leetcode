// Given a collection of intervals, merge all overlapping intervals.
//
//
// For example,
// Given [1,3],[2,6],[8,10],[15,18],
// return [1,6],[8,10],[15,18].
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
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() == 0) return new ArrayList<>();
        if (intervals.size() == 1) return intervals;

        int[] head = new int[intervals.size()];
        int[] tail = new int[intervals.size()];

        for (int i = 0; i < intervals.size(); i++){
            head[i] = intervals.get(i).start;
            tail[i] = intervals.get(i).end;
        }

        Arrays.sort(head);
        Arrays.sort(tail);

        List<Interval> result = new ArrayList<>();
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
        
        /***********************another solution *slower*******************/
        /*
        if (intervals.size() == 0) return new ArrayList<>();
        if (intervals.size() == 1) return intervals;

        int count = intervals.size();
        while(count > 0){
            int i = 0;
            int head = intervals.get(i).start;
            int tail = intervals.get(i).end;
            for(int j = i + 1; j < intervals.size(); j++) {
                if (intervals.get(j).start > tail || intervals.get(j).end < head) continue;
                if (intervals.get(j).start < head ) {
                    head = intervals.get(j).start;
                }
                if (intervals.get(j).end > tail ) {
                    tail = intervals.get(j).end;
                }
                intervals.remove(j);
                if (j < count) count -= 1;
                j -= 1;
            }
            intervals.remove(i);
            count -= 1;
            intervals.add(new Interval(head,tail));
        }
        return intervals;
        */
    }
}

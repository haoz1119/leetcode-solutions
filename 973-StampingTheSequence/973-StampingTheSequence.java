// Last updated: 9/14/2025, 12:53:22 PM
class Solution {
    public int[] movesToStamp(String stamp, String target) {
         char[] s = new char[target.length()];
        char[] t = target.toCharArray();
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[target.length()];
        int stars = 0;

        while (stars < t.length) {
            boolean done = false;
            for (int i = 0; i <= t.length - stamp.length(); i++) {
                if (!visited[i] && canStamp(stamp, t, i)) {
                    stars = stampAt(stamp, t, i, stars);
                    visited[i] = true;
                    result.add(i);
                    done = true;
                    if (stars == t.length) break;
                }
            }
            if (!done) return new int[0];
        }

        int[] res = new int[result.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(result.size() - 1 - i);
        }
        return res;
    }

    private static boolean canStamp(String stamp, char[] target, int start) {
        for (int i = 0; i < stamp.length(); i++) {
            if (target[start + i] != '?' && target[start + i] != stamp.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private static int stampAt(String stamp, char[] target, int start, int stars) {
        for (int i = 0; i < stamp.length(); i++) {
            if (target[start + i] != '?') {
                target[start + i] = '?';
                stars++;
            }
        }
        return stars;
    }
}
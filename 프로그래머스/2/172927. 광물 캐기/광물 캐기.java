class Solution {

    static int[][] mineralTiredGroup; 
    static int result = Integer.MAX_VALUE;

    public int solution(int[] picks, String[] minerals) {
        separateMineralsInGroup(minerals);
        backtrack(0, picks, new int[mineralTiredGroup.length]);
        return result;
    }

    public void separateMineralsInGroup(String[] minerals) {
        int groupCount = (int) Math.ceil((double) minerals.length / 5);
        mineralTiredGroup = new int[groupCount][3];

        for(int i = 0; i < groupCount; i++) {
            int startIdx = i * 5;
            int endIdx = Math.min(startIdx + 5, minerals.length);

            for(int j = startIdx; j < endIdx; j++) {
                String mineral = minerals[j];

                mineralTiredGroup[i][0] += 1;

                if(mineral.equals("diamond")) {
                    mineralTiredGroup[i][1] += 5;
                } else {
                    mineralTiredGroup[i][1] += 1;
                }

                if(mineral.equals("diamond")) {
                    mineralTiredGroup[i][2] += 25;
                } else if(mineral.equals("iron")) {
                    mineralTiredGroup[i][2] += 5;
                } else {
                    mineralTiredGroup[i][2] += 1;
                }
            }
        }
    }

    public void backtrack(int depth, int[] picks, int[] myPicks) {
        if(depth >= mineralTiredGroup.length || (picks[0] <= 0 && picks[1] <= 0 && picks[2] <= 0)) {
            int totalTired = 0;
            for(int i = 0; i < Math.min(depth, myPicks.length); i++) {
                totalTired += mineralTiredGroup[i][myPicks[i]];
            }
            result = Math.min(result, totalTired);
            return;
        }

        for(int i = 0; i < 3; i++) {
            if(picks[i] <= 0) continue;
            picks[i]--;
            myPicks[depth] = i;
            backtrack(depth + 1, picks, myPicks);
            picks[i]++;
        }
    }
}

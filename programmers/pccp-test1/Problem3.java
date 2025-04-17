class Solution {
    public String[] solution(int[][] queries) {
        String[] answer = new String[queries.length];

        for(int i = 0; i < queries.length; i++) {
            int n = queries[i][0];
            int p = queries[i][1];
            answer[i] = getGene(n, p);
        }

        return answer;
    }

    private String getGene(int n, int p) {
        if(n == 1) return "Rr";
        int parentP = (p - 1) / 4 + 1; // 부모가 몇번째인지
        String parentGene = getGene(n-1, parentP);

        if(parentGene.equals("RR") || parentGene.equals("rr")) {
            return parentGene;
        }

        //부모가 Rr일때
        int childIndex = (p-1) % 4;
        if( childIndex == 0) {
            return "RR";
        } else if(childIndex == 3) {
            return "rr";
        } else {
            return "Rr";
        }
    }
}

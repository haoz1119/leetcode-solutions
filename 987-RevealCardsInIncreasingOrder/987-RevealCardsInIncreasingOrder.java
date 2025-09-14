// Last updated: 9/14/2025, 12:53:21 PM
class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        Arrays.sort(deck);
        int[] qt = new int[deck.length];
        for (int i = 0; i < deck.length; i++){
            q.add(i);
        }
        int j = 0;
        while(!q.isEmpty()){
            qt[j] = q.poll();
            if(!q.isEmpty()) q.add(q.poll());
            j++;
        }
        int[] nd = new int[deck.length];
        for(int i=0; i < deck.length; i++){
            nd[qt[i]] = deck[i];
        }
        return nd;
    }
}
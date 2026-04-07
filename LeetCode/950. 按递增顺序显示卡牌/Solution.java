class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Deque<Integer> q = new LinkedList<>();
        for(int i = 0;i < n;i++){
            q.add(i);
        }
        int[] ans = new int[n];
        Arrays.sort(deck);
        for(int i = 0;i < n;i++){
            ans[q.pollFirst()] = deck[i];
            q.add(q.pollFirst());
        }
        return ans;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> lst = new ArrayList<>();
        lst.add(head);
        while(head.next!=null){
            /*ListNode node = new ListNode();
            node.val = head.next().val;
            node.next = head;*/
            head = head.next;
            lst.add(head);     
        }
        int indxToRemove = lst.size()-n;
        if(indxToRemove==0){
            if(lst.size()==1)
                return null;
            else
                return lst.get(1);
        }
        else if(indxToRemove==(lst.size()-1)){
            lst.get(indxToRemove-1).next = null;
        }
        else{
            lst.get(indxToRemove-1).next=lst.get(indxToRemove+1);
        }
        return lst.get(0);
    }
}
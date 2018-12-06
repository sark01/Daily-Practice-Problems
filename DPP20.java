/*
Good morning! Here's your coding interview problem for today.

This problem was asked by Google.

Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.

For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.

In this example, assume nodes with the same value are the exact same node objects.

Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) 
    {
        int countA=0,countB=0;
        ListNode tempA=headA, tempB=headB,startA=headA,startB=headB;
        while(tempA!=null)
        {
            tempA=tempA.next;
            countA++;
        }
        while(tempB!=null)
        {
            tempB=tempB.next;
            countB++;
        }
        int i=0;
        if(countA>countB)
        {
            while(i<(countA-countB))
            {
                startA=startA.next;
                i++;
            }
        }
        else
        {
            while(i<(countB-countA))
            {
                startB=startB.next;
                i++;
            }
        }
        int tot=0;
        while(tot<Math.min(countA,countB))
        {
            if(startA==startB)
                return startA;
            startA=startA.next;
            startB=startB.next;
            tot++;
        }
        return null;
    }
}
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        temp = head;
        i=0
        while temp:
            i += 1
            temp = temp.next
        times = i-n-1
        if times < 0:
            return head.next
        temp = head
        while times > 0:
            temp = temp.next
            times -= 1
        temp.next = temp.next.next
        return head
        
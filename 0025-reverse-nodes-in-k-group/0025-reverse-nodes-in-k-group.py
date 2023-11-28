# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if k == 1 and head == None:
            return head
        temp = head
        prev = None
        i = 0
        while i < k and temp != None:
            temp = temp.next
            i += 1
        if i < k:
            return head
        temp = head
        i = 0
        while i < k  and temp != None:
            nex = temp.next
            temp.next = prev
            prev = temp
            temp = nex
            i += 1
        head.next = self.reverseKGroup(temp, k)
        return prev
            
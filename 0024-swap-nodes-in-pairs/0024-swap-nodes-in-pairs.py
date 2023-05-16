# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or head.next == None:
            return head
        first = head
        sec = head.next
        next_head = self.swapPairs(sec.next)
        first.next = next_head
        sec.next = first
        head = sec
        return head
        
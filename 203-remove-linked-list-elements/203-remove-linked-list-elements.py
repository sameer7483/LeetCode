# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeElements(self, head: Optional[ListNode], val: int) -> Optional[ListNode]:
        while head and head.val == val:
            head = head.next
        if not head:
            return head
        temp = head
        prev = None
        while temp:
            while temp and temp.val == val:
                prev.next = temp.next
                temp = temp.next
            prev = temp
            if temp:
                temp = temp.next
        return head
            
        
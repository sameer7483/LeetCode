# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head == None or head.next == None:
            return
        slow = head
        fast = head.next
        while(fast and fast.next):
            fast = fast.next.next
            slow = slow.next
        next_head = slow.next
        slow.next = None
        reversed_head = self.reverse(next_head)
        self.interveave(head, reversed_head)
    
    def reverse(self, head):
        if head == None or head.next == None:
            return head
        nex = self.reverse(head.next)
        head.next.next = head
        head.next = None
        return nex
    
    def interveave(self, head, reversed_head):
        temp = head
        curr = head
        reversed_temp = reversed_head
        switch = 0
        while reversed_temp:
            if switch == 0:
                switch = 1
                nex = temp.next
                temp = temp.next
                curr.next = reversed_temp
                curr = curr.next
            else:
                switch = 0
                nex= reversed_temp.next
                reversed_temp = reversed_temp.next
                curr.next = temp
                curr = curr.next
        return head
                
        
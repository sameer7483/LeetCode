"""
# Definition for a Node.
class Node:
    def __init__(self, val, prev, next, child):
        self.val = val
        self.prev = prev
        self.next = next
        self.child = child
"""

class Solution:
    def flatten(self, head: 'Optional[Node]') -> 'Optional[Node]':
        temp = head
        while temp:
            if temp.child:
                next_node = temp.next
                flat_head = self.flatten(temp.child)
                temp.next = flat_head
                flat_head.prev = temp
                temp.child = None
                temp2 = flat_head
                while temp2 and temp2.next:
                    temp2= temp2.next
                if temp2:
                    temp2.next = next_node
                    if next_node:
                        next_node.prev = temp2
            temp = temp.next
        return head
        
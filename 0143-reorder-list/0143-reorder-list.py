class Solution(object):

  def reorderList(self, head):
    if not head or not head.next:
      return

    # 1. Find the middle of the linked list (slow will point to middle/end of 1st half)
    slow, fast = head, head.next
    while fast and fast.next:
      slow = slow.next
      fast = fast.next.next

    # 2. Reverse the second half of the list
    second = slow.next
    slow.next = None  # Disconnect the first half from the second half
    prev = None

    while second:
      tmp = second.next
      second.next = prev
      prev = second
      second = tmp

    # 3. Merge the two halves (first starts at head, second starts at prev)
    first, second = head, prev
    while second:
      tmp1, tmp2 = first.next, second.next
      first.next = second
      second.next = tmp1
      first, second = tmp1, tmp2
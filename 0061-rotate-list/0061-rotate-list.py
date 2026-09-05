class Solution(object):

  def rotateRight(self, head, k):
    if not head or not head.next or k == 0:
      return head

    # 1. Calculate length and locate original tail
    length = 1
    tail = head
    while tail.next:
      tail = tail.next
      length += 1

    # 2. Normalize k
    k = k % length
    if k == 0:
      return head

    # 3. Connect tail to head to form a ring
    tail.next = head

    # 4. Find the node before the new head
    steps_to_new_tail = length - k - 1
    new_tail = head
    for _ in range(steps_to_new_tail):
      new_tail = new_tail.next

    # 5. Break the ring and return the new head
    new_head = new_tail.next
    new_tail.next = None

    return new_head
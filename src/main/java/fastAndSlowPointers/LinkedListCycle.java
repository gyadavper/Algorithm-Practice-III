package fastAndSlowPointers;
  class ListNode {
     int val;
      ListNode next;
     ListNode(int x) {
          val = x;
          next = null;
      }
  }
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        while (slowPointer.next != null) {
            fastPointer = fastPointer.next;
            if  (slowPointer == fastPointer) {
                return true;
            }
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }
        return false;
    }
}

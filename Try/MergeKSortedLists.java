class ListNode {
    int val;
    ListNode next;
    
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class MergeKSortedLists {
    
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeLists(lists, 0, lists.length - 1);
    }
    
    private ListNode mergeLists(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        
        int mid = left + (right - left) / 2;
        ListNode leftList = mergeLists(lists, left, mid);
        ListNode rightList = mergeLists(lists, mid + 1, right);
        
        return mergeTwoLists(leftList, rightList);
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }
        
        return dummy.next;
    }
    
    public static void main(String[] args) {
        // Example input: {1,2,5}, {3,6}, {2,9}
        ListNode[] lists = new ListNode[3];
        
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(2);
        lists[0].next.next = new ListNode(5);
        
        lists[1] = new ListNode(3);
        lists[1].next = new ListNode(6);
        
        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(9);
        
        MergeKSortedLists solution = new MergeKSortedLists();
        ListNode mergedList = solution.mergeKLists(lists);
        
        // Print the merged list
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }
}
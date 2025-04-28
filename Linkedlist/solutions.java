//1. DELETE A NODE IN A LINKED LIST
// Input: head = [4,5,1,9], node = 1
// Output: [4,5,9]

class Solution {
  public void deleteNode(ListNode node) {
      ListNode prev = null; //- suru me prev ko zero rkho

      while (node != null && node.next != null) {

          node.val = node.next.val; //- age wale node ka value copy kro
          prev = node; //- prev ko curr node pe leke jao
          node = node.next; //- aur node ko age badha do  
      }
      //- ab node null hai aur last node ko delete kro
      if (prev != null) {
          prev.next = null; //- prev ka next null kar do
      }

  }
}

// 2.DELETE THE MIDDLE NODE OF A LINKED LIST
// Input: head = [1,3,4,7,1,2,6], node = 7  
// Output: [1,3,4,1,2,6]
// FAST DO AGE JAEGA SLOW EK AGE JAEGA AUR JAB FAST NULL HOGA TO SLOW MIDDLE NODE HOGI
// PSLOW SLOW KE EK PECHE RHEGA AUR SLOW KO DELETE KAREGA

class Solution {
  public ListNode deleteMiddle(ListNode head) {
      if(head == null || head.next == null){
          return head;
      }
      ListNode slow = head; 
      ListNode fast = head;
      ListNode pslow = null;

      while(fast != null && fast.next != null){
          pslow = slow; //- PSLOW SLOW KE PECHE RHEGA BCZ YHI SLOW(YANI MIDDLE) KO DELETE KAREGA
          slow = slow.next; //- SLOW EK AGE JAEGA
          fast = fast.next.next;   //- FAST DO DO AGE JAEGA
      }
      pslow.next = slow.next;// SLOW KO DELETE KAREGA YANI SLOW KA NEXT PSELOW KA NEXT HOGA
      return head;

  }
}

// 3.MIDDLE OF A LINKED LIST
// Input: head = [1,2,3,4,5]
// Output: 3
// SAME PREVIOUSE LOGIC BUT HALWA QN
class Solution {
  public ListNode middleNode(ListNode head) {
      ListNode slow = head;
      ListNode fast = head;
      while(fast != null && fast.next != null){
          slow = slow.next;
          fast = fast.next.next;
      
      }
      return slow;
  }
}
//*********
// 4.ODD EVEN LINKED LIST
// Input: head = [1,2,3,4,5]
// Output: [1,3,5,2,4]
//- ODD NODE KO ODD NODE SE JOD DO AUR EVEN NODE KO EVEN NODE SE JOD DO
//- AUR LAST ME ODD NODE Ke end ko EVEN NODE ke start (EVENSTART) SE JOD DO
// REVISE IT AGAIN

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;  // No rearrangement needed for empty or one node list
        }

        ListNode odd = head;           // Odd node starts at the head
        ListNode even = head.next;     // Even node starts at head.next
        ListNode evenStart = even;     // Save the start of the even list

        // Rearranging nodes in odd-even order
        while (even != null && even.next != null) {
            odd.next = even.next;        // Odd nodes point to the next odd node
            even.next = even.next.next;  // Even nodes point to the next even node
            
            odd = odd.next;             // Move odd pointer to the next odd node
            even = even.next;           // Move even pointer to the next even node
        }

        odd.next = evenStart;  // Connect last odd node to the start of the even list

        return head;  // Return the modified head of the list
    }
}
// 5.LINKED LIST CYCLE 2
// Input: head = [3,2,0,-4], pos = 1
// Output: tail connects to node index 1 (0-indexed)
// AGAR CYCLE HAI TOH SLOW AUR FAST MEET KARENGE( SLOW AUR FAST AS PRE QN)
// JAHA PE P AUR SLOW MEET HOTE HAI WAHI PE CYCLE STARTING POINT HAI

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode p = head;
        
        // Step 1: Detect if there is a cycle using slow and fast pointers
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast) {  // Cycle detected
                // Step 2: Find the starting node of the cycle
                while(p != slow) {
                    p = p.next;
                    slow = slow.next;
                }
                return p;  // Return the node where the cycle starts
            }
        }
        
        return null;  // No cycle
    }
}
//**********(Reserve Sampling Algorithm) :> gand fad question
// 6.Linked List Random Node
// Input: head = [1,2,3], node = 1
// Output: 1
// WE USE RESERVOID SAMPLING ALGORITHM TO SELECT RANDOM NODE





// 7.Convert Sorted List to Binary Search Tree
// tree padhne ke baad krunga



// 8.Merge k Sorted Lists   
// Input: lists = [[1,4,5],[1,3,4],[2,6]]
// Output: [1,1,2,3,4,4,5,6]


// 10.SWAPPING NODES IN LINKED LIST
// Input: head = [1,2,3,4,5], k = 2
// Output: [1,4,3,2,5]
//TEMP KO K TIMES CAHALAENGE(K--) AUR JAB K 0 HO JAE TEMP = P1
//JAB P1 ASSIGN HO JEAGA TAB P2 CHALNA SURUKAREGA JABTAK TEMP NULL NA HO JAE AUR JAB TEMP NULL HOEGA P2 APNE SAHI JAGHA PE HOGA
//AUR PHIR END ME P1 AUR P2 KE VAL SWAP KARENGE

class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode p1 = null;
        ListNode p2 = null;
        ListNode temp = head;

        while(temp!=null){
            k--;
            if(p2 != null){
                p2 = p2.next;
            }
            if(k==0){
                p1 = temp;
                p2 = head;            
            }
            temp = temp.next;
            
        }
        int t = p1.val;
        p1.val = p2.val;
        p2.val = t;
        return head;
    }
}
//Maximum Twin Sum of a Linked List
// Input: head = [5,4,2,1,3,6]
// Output: 10
//MID NODE NIKALO AUR USSE AGE KA NODE (SECOND HALF) KO REVERSE KRO 
// MIDNODE KO SLOW ANF FAST APPROACH E NIKALO
// CUR AND MID KO JODD KE DONO KO AGE BADHAO JABTAK MID NULL NA HO JAE

class Solution {
    public int pairSum(ListNode head) {
        // Find mid
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse second half
        ListNode prev = null;
        ListNode current = slow;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        
        // Now, head is first half, prev is head of reversed second half
        int maxSum = 0;
        ListNode first = head;
        ListNode second = prev;
        
        while (second != null) {
            maxSum = Math.max(maxSum, first.val + second.val);
            first = first.next;
            second = second.next;
        }
        return maxSum;
        
    }
}
// ADD TEO NUMBERS
// Input: l1 = [2,4,3], l2 = [5,6,4]
// Output: [7,0,8]
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // Dummy node
        ListNode temp = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
        }

        return dummy.next;
    }
}
//PARTITION LIST
// Input: head = [1,4,3,2,5,2], x = 3
// Output: [1,2,2,4,3,5]
// DO LIST BNAO SMALL AUR LARGE KI
// SMALL LIST ME SMALLP TRANSVERSE KAREGA AUR LARGE LIST ME LARGE P TRANSVERSE KAREGA
// AGR HEAD.VALUE < X HAI TO SMALL LIST ME DAAL DO NHI TO LARGE LIST ME DAAL DO
// SMALL P AND LARGE P TRANSVERSE KRTE KRTE APNE APNE LIST KE END PE AA JAEGA
// PHIR SMALL LIST KO LARGE LIST SE JOD DO(SMALLP KE NEXT KO LARGE KE NEXT SE) AND END ME LARGEP KE NEXT KO NULL KRDO

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);

        ListNode smallp = small;
        ListNode largep = large;

        while(head!=null){
            if(head.val < x){
                smallp.next = head;
                smallp = smallp.next;
            }else{
                largep.next = head;
                largep = largep.next;
            }
            head = head.next;    
        }
        smallp.next = large.next;
        largep.next = null;
        return small.next;       
    }

}
// COPY LIST WITH RANDOM POINTERS
// Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
// Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]



//************ DO REVISION OF THIS QUESTION AGAIN (GFAD QN)
// SPLIT LINKED LISTS IN PARTS
// Input: head = [1,2,3,4,5], k = 3
// Output: [[1,2],[3,4],[5]]
// LINKED LIST KA LENGTH NIKALO THEN NO. OF NODES IN EACH PART = LENGTH/K AND BUCKETSLEFT = LENGTH % K
// DO POINTER BNAO CURR AND PREV
// CURR KO HEAD SE START KRO AUR PREV KO NULL SE START KRO
// PHIR K PARTS ME LOOP KRO JABTAK CURR NULL NA HO JAE AUR AGAR remainderNodes HAI TOH USKO 1 BADA DO AUR PREV.NEXT = 0 - TO BREAK THE LINK
// AUR PHIR I++ (MATLAB RESULT ARR KA FIRST INDEX KA VALUE PTA CHAL GYA AB AGE CHALO)

class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        // Step 1: Find the length of the list
        ListNode curr = head;
        int L = 0;
        while (curr != null) {
            L++;
            curr = curr.next;
        }
        
        // Step 2: Calculate the base size of each part and the remainder
        int eachBucketNodes = L / k;
        int remainderNodes = L % k;
        
        // Step 3: Create an array to hold the resulting ListNode parts
        ListNode[] result = new ListNode[k];
        
        // Step 4: Reinitialize `curr` to the head of the list
        curr = head;
        ListNode prev = null;
        
        // Step 5: Loop over k parts
        for (int i = 0; curr != null && i < k; i++) {
            result[i] = curr;
            
            // Step 6: Loop over the nodes in the current part
            for (int count = 1; count <= eachBucketNodes + (remainderNodes > 0 ? 1 : 0); count++) {
                prev = curr;
                curr = curr.next;
            }
            
            // Step 7: Break the connection after the current part
            if (prev != null) {
                prev.next = null;
            }
            
            // Step 8: Decrease the remainder count
            remainderNodes--;
        }
        
        return result;
    }
}
// ULTRA GFAD QUESTION
// REVERSING A LINKED LIST || 


// REVERSE A LINKED LIST 
// Input: head = [1,2,3,4,5]
// Output: [5,4,3,2,1]
// 3 pointer bnao prev, curr and temp
// prev ko null se start kro curr ko head se start kro and 
// head.next ko prev krne se pehle temp ko head.next krdo taki agle ko traverse kar sake(node khoye na)
// aur loop chalo jab tak curr null na ho jaye and end me prev end pe hoga aur head ke trh kaam krega to return prev
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;

        }
        return prev;
    }
}
// MERGE TWO SORTED LISTS
// Input: l1 = [1,2,4], l2 = [1,3,4]
// Output: [1,1,2,3,4,4]

// REMOVE NTH NODE FROM END OF LIST
// Input: head = [1,2,3,4,5], n = 2
// Output: [1,2,3,5]
// length pta kro , aur travelf = length - n(isse tum front se traverse krte krte uss node pe aa jaoge jise tumhe delete karna hai )
// phir us node ko delete kro aur head return kro
//

 class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int length = 0;

        // First, find the length of the list
        while (curr != null) {
            length++;
            curr = curr.next; // ✅ fix
        }

        // If the node to remove is the head
        if (length == n) { // ✅ fix (lowercase 'length')
            return head.next;
        }

        // Find the node just before the one to remove
        int travelf = length - n;
        ListNode temp = head;
        while(travelf > 1){
            temp = temp.next;
            travelf--;
        }

        // Remove the nth node from end
        temp.next = temp.next.next;

        return head;
    }
}

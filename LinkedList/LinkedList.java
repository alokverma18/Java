public class LinkedList {
    
    public static class Node {
        int data;
        Node next;
        
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void printList(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head==null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head==null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    
    public void add(int idx, int data){
        if(idx>size+1 || idx<0){
            return;
        }
        
        if(idx==0){
            addFirst(data); 
        } else {
            Node newNode = new Node(data);
            size++;
            Node temp = head;
            for(int i=0; i<idx-1; i++){
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }

    }

    public int deleteFirst(){
        if(size==0){
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val = head.data;
            head=tail=null;
            size--;
            return val;
        } else {
            int val = head.data;
            head = head.next;
            size--;
            return val;
        }
    }

    public int deleteLast(){
        if(size==0){
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val = tail.data;
            head=tail=null;
            size--;
            return val;
        }
        else {
            int val = tail.data;
            Node temp = head;
            for(int i=0; i<size-2; i++){
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
            size--;
            return val;
        }
    }

    public int search(int key){
        Node temp = head;
        for(int i=0; i<size; i++){
            if(temp.data==key){
                return i;
            }
            temp=temp.next;
        }
        return -1;
    }

    public int helper(int key, Node head){
        if(head==null){
            return -1;
        } else if(head.data==key){
            return 0;
        } else{
            int idx = helper(key, head.next);
            if(idx==-1){
                return -1;
            } else {
                return idx+1;
            }
        }
    }

    public int recursiveSearch(int key){
        return helper(key, head);
    }

    public void reverse(){
        if(head==null){
            return;
        }
        Node prev=null;
        Node current = tail = head;
        Node next = head.next;
        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public int removeFromEnd(int idx){
        if(idx>size || idx<1){
            return Integer.MIN_VALUE;
        }
        if(idx == size){
            int val = head.data;
            deleteFirst();
            return val;
        } else if(idx==1){
            int val = tail.data;
            deleteLast();
            return val;
        } else {
            Node temp = head;
            for(int i=0; i<size-idx-1; i++){
                temp = temp.next;
            }
            int val = temp.next.data;
            temp.next = temp.next.next;
            return val;
        }
    }

    public Node findMid(){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean checkPalindrome(){
        if(head==null || head.next==null){
            return true;
        }
        Node first = head;
        Node right = findMid();

        //reverse second half
        Node prev=null;
        Node current = right;
        Node next;
        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        right = prev;

        while(right!=null){
            if(first.data!=right.data){
                return false;
            }
            first = first.next;
            right = right.next;
        }
        return true;
    }

    public boolean isCycle(){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }

    public void removeCycle(){
        if(isCycle()==false){
            return;
        }
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                slow = head.next;
                Node prev=fast;
                fast=fast.next;

                /*
                slow = head;
                Node prev=null;
                 */

                while(slow!=fast){
                    prev = fast;
                    fast = fast.next;
                    slow = slow.next;
                }
                prev.next=null;

            }
        }

    }

    public Node merge(Node l, Node r){
        Node newList = new Node(-1);
        Node temp = newList;

        while(l!=null && r!=null){
            if(l.data<r.data){
                temp.next = l;
                l = l.next;
                temp = temp.next;
            } else {
                temp.next = r;
                r = r.next;
                temp = temp.next;
            }
        }
        while(l!=null){
            temp.next=l;
            l = l.next;
            temp = temp.next;
        }
        while(r!=null){
            temp.next = r;
            r = r.next;
            temp = temp.next;
        }
        tail = temp;
        return newList.next;
    }

    public Node mergeSort(Node head){
        if(head==null || head.next==null){
            return head;
        }

        //finding mid
        Node slow = head;
        Node fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid =  slow;

        Node rightHead = mid.next;
        mid.next=null;

        Node l = mergeSort(head);
        Node r = mergeSort(rightHead);

        return merge(l, r);
    }

    public void zigzag(){

        if(head==null || head.next==null){
            return;
        }

        //finding mid
        Node slow = head;
        Node fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid =  slow;
        Node right = mid.next;
        mid.next=null;

        //reverse second half
        Node prev=null;
        Node current = right;
        Node next;
        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        right = prev;

        Node first = head;

        Node newList = new Node(-1);
        Node temp = newList;

        while(right!=null && first!=null){
            newList.next = first;
            first = first.next;
            newList = newList.next;

            tail = right;
            newList.next = right;
            right = right.next;
            newList = newList.next;
        }
        if(first!=null){
            newList.next = first;
            newList = newList.next;
            tail = first;
        }
        head = temp.next;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        // ll.head = new Node(16);
        // ll.head.next = new Node(17);

        // System.out.println(head.data);
        // System.out.println(ll.head.next.data);


        int arr[] = new int[] {16, 17, 1, 7};
        for (int i = 0; i < arr.length; i++) {
            ll.addLast(arr[i]);
        }

        // System.out.println("Size : " + ll.size);

        // System.out.println(ll.search(1));

        // ll.reverse();

        // System.out.println(ll.removeFromEnd(1));

        // ll.printList();

        // System.out.println("Palindrome : "+ ll.checkPalindrome());

        //System.out.println(ll.recursiveSearch(18));

        // tail.next = head.next.next;

        // System.out.println(ll.isCycle());

        // ll.removeCycle();

        // System.out.println(ll.isCycle());

        ll.printList();

        head = ll.mergeSort(head);

        ll.printList();

        ll.zigzag();

        ll.printList();

        System.out.println("Head : "+head.data);
        System.out.println("Tail : "+tail.data);
        
    }


}

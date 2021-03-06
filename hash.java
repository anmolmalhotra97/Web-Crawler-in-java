class hash {
    class node {
        String url;
        int depth;
        int isVisited;
        node next;
    }

    node head, end;

    public hash() {
        head = null;
        end = null;
    }

    public void insert(String url, int d) {
        node n = new node();
        n.url = new String(url);
        n.next = null;
        n.depth = d;
        n.isVisited = 0;
        if (head == null) {
            head = n;
            end = n;
        } else {
            n.next = head;
            head = n;
        }
    }

    public void print() {
        node ptr = head;
        while (ptr != end) {
            System.out.println(ptr.url);
            ptr = ptr.next;
        }
        System.out.println("\n");
    }

    public int check(String str)// check if repeated
    {
        if (head == null)
            return 0;
        node ptr = head;
        while (ptr != end) {
            if (ptr.url.equals(str)) {
                return 1;
            }
            ptr = ptr.next;
        }
        if (end.url.equals(str))
            return 1;
        return 0;
    }
}

class hashable {
    hash[] link(hash[] arr) {
        int i, j;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].end != null) {
                for (j = i + 1; i < arr.length; i++) {
                    if (arr[j].head != null)
                        break;
                }
                arr[i].end.next = arr[j].head;
            }
        }
        return arr;
    }

    public hash[] set(hash[] arr, String[] list,int d)
    {
        for(int i=0;i<list.length;i++)
        {
            int index=list[i].length()%100;
            if(arr[index].check(list[i])==0)
            {
                arr[index].insert(list[i],,d);
            }
        }
        arr = link(arr);
        return arr;
    }
}
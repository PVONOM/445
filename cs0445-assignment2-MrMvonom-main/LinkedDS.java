
public class LinkedDS<T extends Comparable<? super T>> implements SequenceInterface2<T>, ReorderInterface2, Comparable<LinkedDS<T>>{
    
    private Node<T> firstNode;   
    private Node<T> lastNode;
    private int numOfEntries;    

    public LinkedDS(){
        firstNode = null;
        lastNode = null;
        numOfEntries = 0;
    }
   
    public LinkedDS(LinkedDS<T> other){
        firstNode = new Node<>(other.firstNode.getData(), null, null);
    
        Node<T> othernext = other.firstNode;

        while (othernext != null){
            this.append(othernext.data);
            othernext = othernext.next;
        }
        lastNode = othernext;
        numOfEntries = other.numOfEntries;
    }

    public void append(T item){
        if(firstNode == null||lastNode == null){
            Node<T> newNode = new Node<>(item, null, lastNode);
            firstNode = newNode;
            lastNode = newNode;
        }
        else{
        Node<T> newNode = new Node<>(item, null, lastNode); 
        lastNode.setNextNode(newNode);
        newNode.setPrevNode(lastNode);
        lastNode = newNode;
        }   
        numOfEntries++;
    }

    public void prefix(T item){
        if(firstNode == null||lastNode == null){
            append(item);
        }
        else{
        Node<T> secondNode = firstNode;
        firstNode = new Node<T>(item, secondNode, null);
        secondNode.setPrevNode(firstNode);
        numOfEntries++;}
    }

    public void insert(T item, int position){
        

        Node<T> pointer = firstNode;

        if (position > size()|| position < 0)
            throw new IndexOutOfBoundsException("hello");

   
        if(position == 0){
            prefix(item);
        }else if (position == size()){
            append(item);
        }else {
            for(int i = 0; i < position-1; i++){
                pointer = pointer.getNextNode();
            }

            Node<T> newNode = new Node<>(item);
            newNode.setNextNode(pointer.getNextNode());
            pointer.setNextNode(newNode);

            numOfEntries++;
        }       
    }

    public T itemAt(int position){
        
        Node<T> pointer = firstNode;

        if (position >= size() || position <0)
            throw new IndexOutOfBoundsException("hello");

        for(int i = 0; i < position; i++){
            pointer = pointer.getNextNode();
        }

        return pointer.getData();
    }

    public boolean isEmpty(){
        if(firstNode == null)
             return true;

        return false;
    }

    public int size(){
        return numOfEntries;
    }

    public T first(){
        if(firstNode == null)
            return null;


        return firstNode.data;
    }

    public T last(){
        if(lastNode == null)
            return null;


        return lastNode.data;
    }

    public T predecessor(T item){
        Node<T> pointer = lastNode;
        for(int poop = size(); poop > 0; poop--){
            if(pointer.getData().equals(item)){
                pointer = pointer.getPrevNode();
                try {
                    return pointer.getData();
                } catch (Exception e) {
                    return null;
                }
            }
            pointer = pointer.getPrevNode();
        }
        if(pointer == null)
            return null;


        return pointer.getData();
    }

    public int getFrequencyOf(T item){
        Node<T> pointer = firstNode;
        int poop = 0;
        for(int i = 0; i < numOfEntries; i++){
            if(pointer.getData().equals(item)){
                poop++;
            }
            pointer = pointer.getNextNode();
        }

        return poop;
    }

    public void clear(){
        firstNode = null;
        lastNode = null;
        numOfEntries = 0;
    }

    public int lastOccurrenceOf(T item){
        Node<T> pointer = lastNode;
        for(int poop = size(); poop > 0; poop--){
            if(pointer.getData().equals(item)){
                return poop-1;
            }
            pointer = pointer.getPrevNode();
        }
        return -1;
    }

    public T deleteHead(){
        if(isEmpty()){
            throw new EmptySequenceException("reason");
        }

        T item = firstNode.getData();
        firstNode = firstNode.next;
        numOfEntries--;
        return item;
    }

    public T deleteTail(){

        if(isEmpty()){
            throw new EmptySequenceException("reason");
        }
        
        T item = lastNode.getData();
      
        if(firstNode == lastNode){
            firstNode = null;
            lastNode = null;
            numOfEntries = 0;
            return item;
        }
        lastNode = lastNode.getPrevNode();
        lastNode.setNextNode(null);
        numOfEntries--;
        return item;
    }

    public boolean trim(int numItems){
        if( numItems > size()){
            return false;}
        if(size() == 0){
            return false;}
        if(size() == numItems){
            clear();
            return true;
        }

        Node<T> pointer = lastNode;
        
        for(int i = 0; i < numItems; i++){
            pointer = pointer.getPrevNode();
        }
        pointer.setNextNode(null);
        lastNode = pointer;
        numOfEntries-=numItems;
            
        return true;
    }

    public boolean cut(int start, int numItems){
        if( numItems+start > size()|| start<0|| start >= size())
            return false;

        if(start == 0){
            for(int i = 0; i<numItems; i++)
                deleteHead();

            return true;
        }

        Node<T> pointer = lastNode;
        
        for(int i = size(); i > start; i--){
            pointer = pointer.getPrevNode();
        }
        Node<T> pointer2 = pointer;
        for(int i = 0; i <= numItems; i++){
            pointer2 = pointer2.getNextNode();
        }

        pointer.setNextNode(pointer2);
        numOfEntries-=numItems;
            
        return true;
    }

    public void reverse(){
        Node<T> last = firstNode;
        Node<T> previous = null;
        Node<T> current = firstNode;   
        Node<T> future = null;

        for(int i = 0; i < size(); i++){
            future = current.getNextNode();
            current.setNextNode(previous);
            current.setPrevNode(future);
            previous = current;
            current = future;
        }
        firstNode = previous;
        lastNode = last;
       
    }

    public void rotateRight(){
        prefix(lastNode.data);
        deleteTail();
    }

    public void rotateLeft(){
        append(firstNode.data);
        deleteHead();
    }

    public String toString(){
        String string = new String();
        Node<T> stringnode = firstNode;
        while(stringnode != null){
            string += stringnode.data;
            stringnode = stringnode.next;
        }
        return string;
    }
/*
⣹⡗⣗⣫⡷⠃⠀⠀⠀⠀⠀⠀⠀⠘⣿⠈⢿⣝⣯⢻⣝⣯⢻⠝⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⣊⣫⠹⣯⣻
⠹⡣⠙⠞⣀⣠⣤⣤⣶⣶⣦⣦⣤⣁⠀⠀⠀⢻⣼⣏⣾⣼⡏⠀⠀⣀⣤⣤⣴⣴⣦⣤⣤⣤⣍⣀⠩⡮⠋⠓
⣠⡴⠖⠛⠉⢉⠤⠒⠒⠤⡀⠀⠀⠈⠉⠀⠀⠀⢳⣟⣧⠟⠀⠀⠀⠉⡀⠤⠤⠤⣀⠀⠀⠀⠈⠉⠛⠳⢶⣄
⠁⠀⠀⠀⢀⠁⠀⠀⠀⠀⠀⠈⡀⠀⠀⠀⠀⠀⠀⠀⠈⠋⠀⠀⠀⠀⢠⠋⠀⠀⠀⠀⠀⠉⡄
⠀⠀⠀⠀⠸⠀⠀⠀⠀⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⠀⠀⠀⠀⠀⠀⠀⠀⡇
⠀⠀⠀⠀⠀⠡⡀⠀⠀⠀⣀⠜⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢄⠀⠀⠀⠀⠀⢀⠂
⠀⠀⠀⠀⠀⠀⠀⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠒⠐⠒⠈
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠑⠢⢄⢀⡀⡀⡠⠊⠢⡀⡀⡀⣀⠠⠔⠁
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⡆⠀⠀⠀⠀⠀⠀⠀⢸
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⡄⠀⠀⠀⠀⠀⢠⠃
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠒⠒⠒⠈
 */
public int compareTo(LinkedDS<T> other){
    Node<T> pointer1 = this.firstNode;
    Node<T> pointer2 = other.firstNode;
    int hawaii;

    for (int i = 0; i < this.size()&& i< other.size(); i++) {
        int result = pointer1.getData().compareTo(pointer2.getData());
        if (result != 0) {
            return result;  
        }
        pointer1 = pointer1.getNextNode();
        pointer2 = pointer2.getNextNode();
    }
    if(this.size() == other.size())
        return 0;
    
    if(this.size() > other.size()){
        hawaii = 1;
        } 
    else{
        hawaii = -1;
    };
    
    return hawaii;
}
/*
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾⣿⣿⣿⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⣿⣿⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾⣿⣿⣿⣿⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⣿⣿⣿⣿⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⣾⣿⣿⣿⣿⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⣿⣿⣿⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣇⠀⠀⠀⠀⠀⠀⠀⢀⣿⣿⣿⣿⣿⣿⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⢰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀⠀⠀⠀⠀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣷⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⠀⠀⠀⠀⠀⢰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀⠀⢀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣇⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠈⣿⣿⣿⣿⣿⣿⠟⠉⠀⠀⠀⠙⢿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠀⠀⠙⢻⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀⣠⣄⠀⢻⣿⣿⣿⣿⣿⡿⠀⣠⣄⠀⠀⠀⢻⣿⣿⣏⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⣾⣿⣿⣿⣿⠀⠀⠀⠀⠰⣿⣿⠀⢸⣿⣿⣿⣿⣿⡇⠀⣿⣿⡇⠀⠀⢸⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣄⠀⠀⠀⠀⠙⠃⠀⣼⣿⣿⣿⣿⣿⣇⠀⠙⠛⠁⠀⠀⣼⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣷⣤⣄⣀⣠⣤⣾⣿⣿⣿⣿⣽⣿⣿⣦⣄⣀⣀⣤⣾⣿⣿⣿⣿⠃⠀⠀⢀⣀⠀⠀
⠰⡶⠶⠶⠶⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠛⠉⠉⠙⠛⠋⠀
⠀⠀⢀⣀⣠⣤⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠷⠶⠶⠶⢤⣤⣀⠀
⠀⠛⠋⠉⠁⠀⣀⣴⡿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣯⣤⣀⡀⠀⠀⠀⠀⠘⠃
⠀⠀⢀⣤⡶⠟⠉⠁⠀⠀⠉⠛⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠟⠉⠀⠀⠀⠉⠙⠳⠶⣄⡀⠀⠀
⠀⠀⠙⠁⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠁⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⣰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⢰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⣸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
 */
    // EXTRA CREDIT
    public SequenceInterface<T> slice(T item){
        LinkedDS<T> result = new LinkedDS<>();
        Node<T> pointer = firstNode;
        while(pointer != null){
            if (pointer.getData().compareTo(item)<=0){
                result.append(pointer.getData());
            }
            pointer = pointer.getNextNode();
        }
        return result;
    }

    public SequenceInterface<T> slice(int start, int numItems){
        if (start < 0|| start >= size()|| start+numItems > size()){
            return null;
        }
        LinkedDS<T> result = new LinkedDS<>();
        Node<T> pointer = firstNode;
        for (int i = 0; i<start;i++) {
            pointer = pointer.getNextNode();
        }

        Node<T> pointer2 = pointer;
        for(int i = 0; i < numItems; i++){
            result.append(pointer2.getData());
            pointer2 = pointer2.getNextNode();
        }

        return result;
    }

    public void shuffle(int[] oldPositions, int[] newPositions){

    }
    /*
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢲⢄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠄⠂⢉⠤⠐⠋⠈⠡⡈⠉⠐⠠⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⢀⡀⢠⣤⠔⠁⢀⠀⠀⠀⠀⠀⠀⠀⠈⢢⠀⠀⠈⠱⡤⣤⠄⣀⠀⠀⠀⠀⠀
⠀⠀⠰⠁⠀⣰⣿⠃⠀⢠⠃⢸⠀⠀⠀⠀⠀⠀⠀⠀⠁⠀⠀⠀⠈⢞⣦⡀⠈⡇⠀⠀⠀
⠀⠀⠀⢇⣠⡿⠁⠀⢀⡃⠀⣈⠀⠀⠀⠀⢰⡀⠀⠀⠀⠀⢢⠰⠀⠀⢺⣧⢰⠀⠀⠀⠀
⠀⠀⠀⠈⣿⠁⡘⠀⡌⡇⠀⡿⠸⠀⠀⠀⠈⡕⡄⠀⠐⡀⠈⠀⢃⠀⠀⠾⠇⠀⠀⠀⠀
⠀⠀⠀⠀⠇⡇⠃⢠⠀⠶⡀⡇⢃⠡⡀⠀⠀⠡⠈⢂⡀⢁⠀⡁⠸⠀⡆⠘⡀⠀⠀⠀⠀
⠀⠀⠀⠸⠀⢸⠀⠘⡜⠀⣑⢴⣀⠑⠯⡂⠄⣀⣣⢀⣈⢺⡜⢣⠀⡆⡇⠀⢣⠀⠀⠀⠀
⠀⠀⠀⠇⠀⢸⠀⡗⣰⡿⡻⠿⡳⡅⠀⠀⠀⠀⠈⡵⠿⠿⡻⣷⡡⡇⡇⠀⢸⣇⠀⠀⠀
⠀⠀⢰⠀⠀⡆⡄⣧⡏⠸⢠⢲⢸⠁⠀⠀⠀⠀⠐⢙⢰⠂⢡⠘⣇⡇⠃⠀⠀⢹⡄⠀⠀
⠀⠀⠟⠀⠀⢰⢁⡇⠇⠰⣀⢁⡜⠀⠀⠀⠀⠀⠀⠘⣀⣁⠌⠀⠃⠰⠀⠀⠀⠈⠰⠀⠀
⠀⡘⠀⠀⠀⠀⢊⣤⠀⠀⠤⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠤⠄⠀⢸⠃⠀⠀⠀⠀⠀⠃⠀
⢠⠁⢀⠀⠀⠀⠈⢿⡀⠀⠀⠀⠀⠀⠀⢀⡀⠀⠀⠀⠀⠀⠀⢀⠏⠀⠀⠀⠀⠀⠀⠸⠀
⠘⠸⠘⡀⠀⠀⠀⠀⢣⠀⠀⠀⠀⠀⠀⠁⠀⠃⠀⠀⠀⠀⢀⠎⠀⠀⠀⠀⠀⢠⠀⠀⡇
⠀⠇⢆⢃⠀⠀⠀⠀⠀⡏⢲⢤⢀⡀⠀⠀⠀⠀⠀⢀⣠⠄⡚⠀⠀⠀⠀⠀⠀⣾⠀⠀⠀
⢰⠈⢌⢎⢆⠀⠀⠀⠀⠁⣌⠆⡰⡁⠉⠉⠀⠉⠁⡱⡘⡼⠇⠀⠀⠀⠀⢀⢬⠃⢠⠀⡆
⠀⢢⠀⠑⢵⣧⡀⠀⠀⡿⠳⠂⠉⠀⠀⠀⠀⠀⠀⠀⠁⢺⡀⠀⠀⢀⢠⣮⠃⢀⠆⡰⠀
⠀⠀⠑⠄⣀⠙⡭⠢⢀⡀⠀⠁⠄⣀⣀⠀⢀⣀⣀⣀⡠⠂⢃⡀⠔⠱⡞⢁⠄⣁⠔⠁⠀
⠀⠀⠀⠀⠀⢠⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⠉⠁⠀⠀⠀⠀
⠀⠀⠀⠀⠀⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀
     */
    private class Node<T> 
	{
		private T data;     // Data portion
		private Node<T> next;  // Next to next node
        private Node<T> prev;

		private Node(T dataPortion)//  PRIVATE or PUBLIC is OK
		{
			data = dataPortion;
			next = null;
            prev = null;	
		} // end constructor

        private Node(T dataPortion, Node<T> nextNode, Node<T> prevNode)//  PRIVATE or PUBLIC is OK
		{
			data = dataPortion;
			next = nextNode;	
            prev = prevNode;
		} // end constructor

		private T getData()
		{
			return data;
		} // end getData
		
		private void setData(T newData)
		{
			data = newData;
		} // end setData
		
		private Node<T> getNextNode()
		{
			return next;
		} // end getNextNode
        
        private Node<T> getPrevNode(){
            return prev;
        }
		
		private void setNextNode(Node<T> nextNode)
		{

			next = nextNode;

		} // end setNextNode

        private void setPrevNode(Node<T> prevNode)
		{
			prev = prevNode;
		} // end setNextNode
	} // end Node
}
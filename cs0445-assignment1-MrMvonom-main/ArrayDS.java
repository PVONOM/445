public class ArrayDS<T extends Comparable<? super T>> implements SequenceInterface<T>, ReorderInterface, Comparable<ArrayDS<T>> {
    
        private int defaultSize = 10; // init size and total number of spaces 
        private int pointer = 0; // actual number of entries 
        private T[] array;
    public ArrayDS(){
        array = (T[]) new Comparable[defaultSize]; 
        defaultSize = 10;
        pointer = 0;

    }

    public ArrayDS(ArrayDS<T> other){
        array = (T[]) new Comparable[defaultSize];
        defaultSize = 10;
        pointer = 0;

        for(int i = 0; i<other.pointer; i++){
            this.append(other.itemAt(i));
        }
    }

    public String toString(){
        String poop = new String("");

        for(int k = 0; k< pointer; k++){
            poop += array[k];
        }
        return poop;
    }

    private void check(){
        if(pointer >= defaultSize-1)
            resize();
    }

    private void resize(){
        T[] temp = (T[]) new Comparable[defaultSize*2];
        for(int i = 0; i<pointer; i++){
            temp[i] = array[i];
        }
        defaultSize += defaultSize;
        array = temp;
    }
    
    public void append(T item){
        check();
        array[pointer] = item;
        pointer++;
    }

    public void prefix(T item){
        check();
        if(pointer ==0){
            append(item);
            return;
        }
        for(int i = pointer; i > 0; i--){
            array[i] = array[i-1];
        }
        array[0] = item;
        pointer++;
    }

	public void insert(T item, int position){
        check();
        for(int z = pointer; z> position; z--){
            array[z] = array[z-1];
        }
        array[position] = item;
        pointer++;
    }

	public T itemAt(int position){
        if(position > pointer-1)
            throw new IndexOutOfBoundsException("");
        return array[position];
    }

	public boolean isEmpty(){
        return pointer==0;
    }

	public int size(){
        return pointer;
    }

	public T first(){
        return array[0];
    }

	public T last(){
        return array[pointer-1];
    }

	public T predecessor(T item){
        int last = lastOccurrenceOf(item);
        if(last > 0){
            return itemAt(last-1);
        } else
            return null;
    }

	public int getFrequencyOf(T item){
        int freak = 0;
        for(int i = 0; i< pointer; i++){
            if (itemAt(i)== item) {
                freak++;
            }
        }
        return freak;
    }

	public void clear(){
        pointer = 0;
    }

	public int lastOccurrenceOf(T item){
        for(int i = pointer-1; i >=0; i--){
            if(itemAt(i) == item)
                return i;
        }
        return -1;
    }

	public T deleteHead(){
        if(isEmpty())
            throw new EmptySequenceException("");
        T temp = first();
        for(int w = 0; w< pointer-1; w++){
            array[w] = array[w+1];
        }
        pointer--;
        return temp;
    }

	public T deleteTail(){
        if(isEmpty())
            throw new EmptySequenceException("");
        T temp = last();
        trim(1);
        return temp;
    }

	public boolean trim(int numItems){
        if(pointer-numItems <0){
            return false;
        }

        pointer = pointer- numItems;
        return true;
    }

	public boolean cut(int start, int numItems){
        if(pointer-numItems < 0){
            return false;
        }
        for(int z = 0; z< pointer-numItems; z++){
            array[start+z] = array[start+z+numItems];
        }
        pointer -= numItems;
        return true;
    }

	public SequenceInterface<T> slice(T item){
        return this;
    } // huh?

	public SequenceInterface<T> slice(int start, int numItems){
        return this;
    } // huh

    @Override
    public int compareTo(ArrayDS<T> other){
        for(int j = 0; j < this.size()&& j<other.size(); j++){
            if ((char)itemAt(j)>(char)other.itemAt(j)) {
                return 1;
            } else if ((char)itemAt(j)< (char)other.itemAt(j)) {
                return -1;
            }
        }
        return this.size()-other.size();
    }

    public void reverse(){
        T[] temp = (T[]) new Comparable[defaultSize];
        int pp = pointer-1;
        for(int i = 0; i<pointer; i++){
            temp[pp] = array[i];
            pp--;
        }
        array = temp;
    }

    public void rotateRight(){
        T item =deleteTail();
        insert(item, 0);
    }

    public void rotateLeft(){
        T item = deleteHead();
        append(item);
    }

    public void shuffle(int[] oldPositions, int[] newPositions){

    }

}
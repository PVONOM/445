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
        this.array = (T[]) new Comparable[other.defaultSize];
        this.defaultSize = other.defaultSize;
        this.pointer = other.pointer;

        for(int i = 0; i<pointer; i++){
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
        pointer++;
    }

	public T itemAt(int position){
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
        return null;
    }

	public int getFrequencyOf(T item){
        return -1;
    }

	public void clear(){
        pointer = 0;
    }

	public int lastOccurrenceOf(T item){
        return -1;
    }

	public T deleteHead(){
        return null;
    }

	public T deleteTail(){
        return null;
    }

	public boolean trim(int numItems){
        return false;
    }

	public boolean cut(int start, int numItems){
        return false;
    }

	public SequenceInterface<T> slice(T item){
        return this;
    } // huh?

	public SequenceInterface<T> slice(int start, int numItems){
        return this;
    } // huh

    @Override
    public int compareTo(ArrayDS<T> other){
        return -1;
    }

    public void reverse(){

    }

    public void rotateRight(){

    }

    public void rotateLeft(){

    }

    public void shuffle(int[] oldPositions, int[] newPositions){

    }

}
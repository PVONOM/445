public class ArrayDS<T extends Comparable<? super T>> implements SequenceInterface<T>, ReorderInterface, Comparable<ArrayDS<T>> {
    
    public ArrayDS(){
        
    }

    public ArrayDS(ArrayDS<T> other){

    }

    public String toString(){
        return " ";
    }
    
    public void append(T item){

    }

    public void prefix(T item){

    }

	public void insert(T item, int position){

    }

	public T itemAt(int position){
        return null;
    }

	public boolean isEmpty(){
        return false;
    }

	public int size(){
        return -1;
    }

	public T first(){
        return null;
    }

	public T last(){
        return null;
    }

	public T predecessor(T item){
        return null;
    }

	public int getFrequencyOf(T item){
        return -1;
    }

	public void clear(){

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
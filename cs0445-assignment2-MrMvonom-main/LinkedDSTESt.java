public class LinkedDSTESt<T extends Comparable<? super T>> implements SequenceInterface2<T>, ReorderInterface2, Comparable<LinkedDS<T>> {
    
    
    public int compareTo(LinkedDS<T> other){ ... }
    
    public LinkedDS(){    }

    public LinkedDS(LinkedDS<T> other){ }

    public String toString(){ return null; }








    /*
     * node class from class repo 
     */
    private class Node<T> 	{
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

public class HashNode {
    private HashNode next;
    private Record element;
    
    /*Creates a node storing no data and with enxt set to null*/
    public HashNode()
    {
        next = null;
        element = null;
    }
    
    
    
    
    /* Creates a node with the specific record, with next set to null*/
    public HashNode (Record rec)
    {
        next = null;
        element = rec;
    }
    
    /* Returns the next node after this one */
    public HashNode getNext()
    {
        return next;
    }
    
    /* Sets the next node after this one */
    public void setNext (HashNode node)
    {
        next = node;
    }
    
    /* Returns the Record object stored in a node */
    public Record getRecord()
    {
        return element;
    }
    
    /* Sets the Record object stored in a node */
    public void setRecord (Record rec)
    {
        element = rec;
    }
	
	
	
	
}

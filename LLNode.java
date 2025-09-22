class LLNode{
    private ProposedSequence payload;
    private LLNode next;

    public LLNode(ProposedSequence payload, LLNode next){
        this.payload = payload;
        this.next = next;
    }

    public ProposedSequence getPayload(){return payload;}
    public LLNode getNext(){return next;}
    
    

    @Override
    public String toString(){
        LLNode current = this;
        String Stringoutput = "";

        while (current != null){
            ProposedSequence data = current.payload;
            Stringoutput += data.toString() + "\n"; 
            current = current.getNext();
        }
        return Stringoutput;
    }
}
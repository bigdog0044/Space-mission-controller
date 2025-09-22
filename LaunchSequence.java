class LaunchSequence{
    private int[] sequence;
    private String toStringFormat;
    
    public LaunchSequence(int[] sequence){
        this.sequence = sequence;
    }

    public int getProcedure(int i) { return sequence[i];}

    @Override
    public String toString(){ 
        this.toStringFormat = "";
        
        for (int i = 0; i<sequence.length; i++){
            if (i == 4){
                toStringFormat += sequence[i];
            } else {
                toStringFormat += sequence[i] + " ";
            }
        }

        return toStringFormat; 
        }
    
}
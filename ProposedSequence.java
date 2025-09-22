class ProposedSequence{
    private LaunchSequence suggestion; //what the user types in
    private LaunchSequence sequence; //correct sequence
    private int correct, wrong;
    private boolean arrMatches;
    //takes it from launch sequence


    // private int indexFinder(LaunchSequence array, int numToFind){
        
    //     for(int i = 0; i < 5; i++){
    //         if(array.getProcedure(i) == numToFind){
    //             return i;
    //         }
    //     }
    //     return 0; //element not within array
    // }
    
    public ProposedSequence(LaunchSequence suggestion, LaunchSequence solution){
        this.suggestion = suggestion;
        this.sequence = solution;
    }

    public LaunchSequence getSequence(){return this.suggestion;}
    
    public int getNumCorrect(){
        correct = 0; //sets it back to 0

        for(int i = 0; i < 5; i++){
            if (suggestion.getProcedure(i) == sequence.getProcedure(i)){
                correct++;
            }
        }
        return correct;
        
    }
    
    public int getNumWrongPosition(){
        wrong = 0; //sets it back to 0

        //boolean[] correctPosition = new boolean[5];
        for (int x = 0; x < 5; x++){

            if(suggestion.getProcedure(x) != sequence.getProcedure(x)){
            //int numToFindIndex = indexFinder(sequence, suggestion.getProcedure(i));
                for(int y = 0; y < 5; y++){
                    if (suggestion.getProcedure(x) == sequence.getProcedure(y)){
                        wrong++;
                        break;
                    }
                }
            }
        }
        return wrong;
    }

    public boolean isCorrect(){
        for (int i = 0; i < 5; i++){
            //needs to create a for loop to see if number is within the mission controller sequence
            
            if (suggestion.getProcedure(i) != sequence.getProcedure(i)){
                arrMatches = false;
                break; //stops the loop
            } else{
                arrMatches = true;
            }
        }

        return arrMatches;
    }

    @Override
    public String toString(){
        return suggestion.toString() + " (Correct " + getNumCorrect() + ", Wrong position " + getNumWrongPosition() + ")";
    }
}
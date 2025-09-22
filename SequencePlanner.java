import java.util.Random;


class SequencePlanner{
    private  LaunchSequence solution;
    private LLNode head;
    private int[] randomSolution; //used to store the random numbers for the solution


    private static int randomNumber(){
        Random random = new Random();
        int number = random.nextInt(8) + 1;
        return number; 
    }
    public SequencePlanner(){
        randomSolution = new int[5];
        

        for(int i = 0; i < randomSolution.length; i++){
            int num;
            boolean isdupe;

            do { 
                num = randomNumber();
                isdupe = false;
                
                // Check if the generated number already exists in the array
                for(int x = 0; x < i; x++){
                    if(randomSolution[x] == num){
                        isdupe = true;
                        break;
                    }
                }

            } while (isdupe);

            randomSolution[i] = num;
        }

        LaunchSequence generatedSolution = new LaunchSequence(randomSolution);
        this.solution = generatedSolution;
    }

    public SequencePlanner(LaunchSequence solution){
        //this sets the actual sequence
        this.solution = solution;
        this.head = null;
    }



    public boolean checkProposedSequence(LaunchSequence sequence){
        //first argument is the suggested sequence
        //second argument is the actual sequence
        ProposedSequence newSuggestSequence = new ProposedSequence(sequence,this.solution);

        LLNode node = new LLNode(newSuggestSequence, this.head);
        this.head = node;


        boolean result = newSuggestSequence.isCorrect();
        return result; //true if correct else return false
    }

    public LLNode getPreviousSuggestions(){
        return head;
    }

    public LaunchSequence getSolution(){
        return solution;
    }
}
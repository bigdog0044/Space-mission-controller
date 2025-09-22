import java.util.Scanner;

public class SequencePlannerCLI{
    private static void sequenceVerified(int attempt){
        System.out.println("The final sequence is:");
        System.out.println("System Check");
        System.out.println("Fuel Loading");
        System.out.println("Navigation Setup");
        System.out.println("Engine Ignition");
        System.out.println("Safety Override");
        System.out.println("You needed " + attempt + " attempts to find the sequence.");
        // System.out.println("Crew Boarding");
        // System.out.println("Launch Pad Clear");
        // System.out.println("Communication Test");
    }

    private static boolean checkSequence(String[] processedArray){
        //stores the users input into the sequenceArray
        for(int i = 0; i < processedArray.length; i++){
            if (Integer.parseInt(processedArray[i]) > 9 || Integer.parseInt(processedArray[i]) < 1){
                //System.out.println("Invalid sequence");
                return false;
            }
        }
        /*
        for(int x = i + 1; x< processedArray.length; x++){
            System.out.println("base num " + baseNumber);
            System.out.println(Integer.parseInt(processedArray[i]));
            if(Integer.parseInt(processedArray[i]) == baseNumber){
                //System.out.println("Invalid sequence");
                return false;
            }
        }*/
        for (int x = 0; x < processedArray.length - 1; x++){
            for(int y = x + 1; y < processedArray.length; y++){
                if(Integer.parseInt(processedArray[x]) == Integer.parseInt(processedArray[y])){
                    return false;
                }
            }
        }

        
        return true;
    }
    public static void runSimulation(SequencePlanner solution){
        boolean correctSequence = false;
        Scanner keyboardOBJ = new Scanner(System.in);

        int totalAttempts = 0;
        while(correctSequence == false){
            System.out.println("Previous attempts:");
            if (solution.getPreviousSuggestions() == null){
                System.out.println("No previous attempts");
            } else{
                System.out.print(solution.getPreviousSuggestions().toString());
            }

            
            
            int[] sequenceArray = new int[5];
            System.out.println("Enter new sequence:");
            String userSequence = keyboardOBJ.nextLine();
            String[] processedSequence = userSequence.split(" "); //splits the input by space
            

            
            if(checkSequence(processedSequence) == false){
                System.out.println("Invalid sequence!");
            } else {
                totalAttempts += 1;
            }   
            //adding elements to the array
            for (int x = 0; x < sequenceArray.length; x++){
                sequenceArray[x] = Integer.parseInt(processedSequence[x]);
            }
            
            //creats a launch sequence object
            LaunchSequence launchSequenceArray = new LaunchSequence(sequenceArray);
            //solution.checkProposedSequence(launchSequenceArray );
            boolean result = solution.checkProposedSequence(launchSequenceArray);
            
            if (result){
                System.out.println("Sequence verified!");
                sequenceVerified(totalAttempts);
                correctSequence = true;
            }
        }
    }
    public static void main(String[] args) {
        SequencePlanner solution = new SequencePlanner();
        runSimulation(solution);
        
    }
}
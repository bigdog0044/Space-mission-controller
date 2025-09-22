# Space-mission-controller

<h1>Ovwerview</h1>
You will write a game called “Space Mission Launch Sequence.”

The user plays the role of a trainee at Stellar Space Center, working under a veteran Mission Controller. The trainee is completing their placement year at the center, and the Mission Controller is known for their exacting standards and perfectionist approach. The trainee has been tasked with developing a simulation tool that will help determine the optimal launch sequence for the next mission. That is, they need to arrange 5 critical procedures in the correct order from a set of 9 possible procedures.

The Mission Controller has a very specific idea of the correct launch sequence but, due to security protocols, cannot directly tell the trainee the exact order. However, they can provide feedback on any proposed sequence.

They “know it when they see it” – this means the trainee has to suggest several draft sequences to the Mission Controller. For each sequence, the Mission Controller can tell them:

    how many procedures are in their correct position in the sequence, and
    how many procedures are needed but are in the wrong position in the sequence.

With this feedback, the trainee can refine their sequence until it’s correct.

The available launch procedures at Stellar Space Center are:

    System Check (procedure code 01),
    Fuel Loading (procedure code 02),
    Navigation Setup (procedure code 03),
    Communication Test (procedure code 04),
    Engine Ignition (procedure code 05),
    Weather Verification (procedure code 06),
    Crew Boarding (procedure code 07),
    Safety Override (procedure code 08), and
    Launch Pad Clear (procedure code 09).

We use the last digit of their procedure codes to represent them. The five positions in the sequence represent:

    Pre-launch verification
    System initialization
    Final preparation
    Launch readiness
    Mission start

For instance

9 3 4 7 1

represents a sequence that has Launch Pad Clear as pre-launch verification, Navigation Setup as system initialization, Communication Test as final preparation, Crew Boarding as launch readiness, and System Check as mission start.

Suppose the Mission Controller was expecting the sequence

9 3 4 7 1

If the trainee suggested

1 3 4 5 9

the Mission Controller would indicate that

    two procedures belong in the sequence but are in the wrong position (System Check (01) and Launch Pad Clear (09)), and
    two procedures are in the right spot (Navigation Setup (03) and Communication Test (04)).

The game will proceed in a loop. First, the list of previous attempts so far is displayed – this includes the guesses and the Mission Controller’s feedback. The user is then asked to input their next suggestion. If the answer is correct, “Sequence verified!” is displayed and the program terminates. Otherwise, the game loops.

If the user enters a sequence containing a procedure code that does not exist at Stellar Space Center, or a sequence containing duplicated procedures, the program should indicate that the sequence is not valid and ask the user to enter another attempt.

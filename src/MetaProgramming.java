import java.util.HashMap;
import java.util.Scanner;

public class MetaProgramming
{

    public static void main(String[] args)
    {
        HashMap<String, Integer> definitions = new HashMap<>();
        HashMap<Integer, String> valueToDefinitions = new HashMap<>();
        Scanner inputScanner = new Scanner(System.in);

        while(inputScanner.hasNextLine())
        {
            String line = inputScanner.nextLine();
            String[] words = line.split("\\s+");
            String command = words[0];

            if(command.toUpperCase().equals("DEF"))
            {
                String identifier = words[1];
                int value = Integer.valueOf(words[2]);
                definitions.put(identifier, value );
                valueToDefinitions.put(value, identifier);
            }
            else if(command.toUpperCase().equals("CALC"))
            {
                Integer answer = 0;
                String lastIdentifier = "";
                String lastOperator = "";
                for(int i =1; i < words.length; i++)
                {

                    if(answer == null)
                        break;

                    if(words[i].equals("-") || words[i].equals("+") || words[i].equals("="))
                        lastOperator = words[i];
                    else
                    {
                        if(lastOperator.equals("-")) // there is a calculation to process
                        {
                            Integer currentValue = definitions.get(words[i]);
                            if(currentValue != null)
                                answer -= currentValue;
                            else
                                answer = null;
                        }
                        else if(lastOperator.equals("+"))
                        {
                            Integer currentValue = definitions.get(words[i]);
                            if(currentValue != null)
                                answer += currentValue;
                            else
                                answer = null;
                        }
                        else if(words[i].equals("="))
                            break;
                        else
                            answer = definitions.get(words[i]);

                    }
                } // for i loop
                String answerIdentifier = valueToDefinitions.get(answer);
                String output = "";
                for(int i =1; i < words.length; i++)
                    output += words[i] + " ";
                if(answerIdentifier != null)
                    output += answerIdentifier;
                else output+= "unknown";
                System.out.println(output);

            }
            else if(command.toUpperCase().equals("CLEAR"))
            {
                definitions.clear();
                valueToDefinitions.clear();
            }
        }
        inputScanner.close();
    }
}


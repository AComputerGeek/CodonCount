import edu.duke.*;
import java.util.*;

/**
* 
* @author: Amir Armion 
* 
* @version: V.01
* 
*/
public class CodonCount 
{

    private HashMap<String, Integer> myMap;

    public CodonCount()
    {
        myMap = new HashMap<>();
    }

    public void buildCodonMap(int start, String dna)
    {
        myMap.clear();
        String codon = null;

        if(start == 0)
        {
            for(int i = 0; i < dna.length(); i += 3)
            {
                if(i + 3 <= dna.length())
                {
                    codon = dna.substring(i, i + 3);

                    if(!myMap.containsKey(codon))
                    {
                        myMap.put(codon, 1);
                    }
                    else
                    {
                        myMap.put(codon, myMap.get(codon) + 1);
                    }
                }
            }
        }
        else if(start == 1)
        {
            for(int i = 1; i < dna.length(); i += 3)
            {
                if(i + 3 <= dna.length())
                {
                    codon = dna.substring(i, i + 3);

                    if(!myMap.containsKey(codon))
                    {
                        myMap.put(codon, 1);
                    }
                    else
                    {
                        myMap.put(codon, myMap.get(codon) + 1);
                    }
                }
            }
        }
        else if(start == 2)
        {
            for(int i = 2; i < dna.length(); i += 3)
            {
                if(i + 3 <= dna.length())
                {
                    codon = dna.substring(i, i + 3);

                    if(!myMap.containsKey(codon))
                    {
                        myMap.put(codon, 1);
                    }
                    else
                    {
                        myMap.put(codon, myMap.get(codon) + 1);
                    }
                }
            }
        }
        else
        {
            System.out.println("Start is not correct!");
        }
    }

    public String getMostCommonCodon()
    {
        int    maxRepeated = 0;
        String maxCodon    = null;

        for(String codon: myMap.keySet())
        {
            int codonRepeated = myMap.get(codon);

            if(codonRepeated > maxRepeated)
            {
                maxRepeated = codonRepeated;
                maxCodon    = codon;
            }
        }

        return maxCodon;
    }

    public void printCodonCounts(int start, int end)
    {
        int repeated = 0;

        for(String codon: myMap.keySet())
        {
            repeated = myMap.get(codon);

            if(repeated >= start && repeated <= end)
            {
                System.out.println(codon + "\t" + repeated);
            }
        }
    }

    public void testCodonCount()
    {
        FileResource resource = new FileResource();

        String dna = resource.asString().toUpperCase().trim();

        System.out.println("\n\n----- Start from 0 ----- \n");
        buildCodonMap(0, dna);
        System.out.println("\nThe total number of unique codons: " + myMap.size());
        System.out.println("\nThe most common codon is: "          + getMostCommonCodon() + "\t" + myMap.get(getMostCommonCodon()));
        System.out.println("\nAll codons with their occurrence:\n");
        printCodonCounts(1, 100);

        System.out.println("\n\n----- Start from 1 ----- \n");
        buildCodonMap(1, dna);
        System.out.println("\nThe total number of unique codons: " + myMap.size());
        System.out.println("\nThe most common codon is: "          + getMostCommonCodon() + "\t" + myMap.get(getMostCommonCodon()));
        System.out.println("\nAll codons with their occurrence:\n");
        printCodonCounts(1, 100);

        System.out.println("\n\n----- Start from 2 ----- \n");
        buildCodonMap(2, dna);
        System.out.println("\nThe total number of unique codons: " + myMap.size());
        System.out.println("\nThe most common codon is: "          + getMostCommonCodon() + "\t" + myMap.get(getMostCommonCodon()));
        //System.out.println("\nAll codons with their occurrence:\n");
        //printCodonCounts(1, 100);
    }
}

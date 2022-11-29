package UppgiftA2;// SynonymUser.java

/****************************************************************

SynonymUser reads the synonym data from a given file. This data
is used and modified in various ways. Finally, the modified data
is written to a new file.

See:
thesaurus.com

Author: Fadil Galjic

****************************************************************/

import java.io.*;  // IOException
import static java.lang.System.out;

class SynonymUser
{
    public static void main (String[] args) throws IOException
    {
        String[] synonymData = synonymHandler.readSynonymData(
                "SynonymData1.txt");
        println(synonymData);
        String synonymLine = synonymHandler.getSynonymLine(
                synonymData, "beautiful");
        out.println(synonymLine + "\n");
        synonymLine =
                "glowing | luminous, vibrant, flaming, gleaming";
        synonymData = synonymHandler.addSynonymLine(
                synonymData, synonymLine);
        println(synonymData);
        synonymData = synonymHandler.removeSynonymLine(
                synonymData, "clever");
        println(synonymData);
        synonymHandler.addSynonym(synonymData, "powerful",
                "briliant");
        println(synonymData);
        synonymHandler.removeSynonym(synonymData, "beautiful",
                "appealing");
        println(synonymData);
        synonymHandler.sortSynonymData(synonymData);
        println(synonymData);
        synonymHandler.writeSynonymData(synonymData,
                "SynonymData2.txt");
    }

    public static void println (String[] synonymData)
    {
        for (String synonymLine : synonymData)
            out.println(synonymLine);
        out.println("");
	}
}
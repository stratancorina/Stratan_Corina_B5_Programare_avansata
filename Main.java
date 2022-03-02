import java.util.Random;
public class Main
{
    private static final Random rand = new Random();
    public static void main(String[] args)
    {
        parseInput(args);
        int n = Integer.parseInt(args[0]);
        int p = Integer.parseInt(args[1]);
        int lungAlfabet = args.length - 2;
        char[] litere = new char[lungAlfabet];
        for (int i = 0; i < lungAlfabet; i++)
        {
            litere[i] = args[i + 2].charAt(0);
        }

        String[] cuvinte = generareCuvinte(n, p, litere, lungAlfabet);

        for (String cuvant : cuvinte)
            System.out.println(cuvant);
    }

    public static void parseInput(String[] args) // Validarea argumentelor
    {
        if (args.length < 3)  // Verifica ca nr de arg sa fie mai mare decat 3
        {
            System.out.println("Nu sunt suficiente caractere'.");
            System.exit(-1);
        }
        try    //Verifica ca primele 2 argumente sa fie integer uri
        {
            Integer.parseInt(args[0]); //verifca primu arg sa fie int
            Integer.parseInt(args[1]); //verif pe al doilea
        } catch (NumberFormatException e)
        {
            System.out.println("Variabile incorecte.");
            System.exit(-1);
        }

        for (int i = 2; i < args.length; i ++)
        {
            if(args[i].length() != 1)
            {
                System.out.println("Nu este o lungime valida.");
                System.exit(-1);
            }
            if(!Character.isUpperCase(args[i].charAt(0)))
            {
                System.out.println("Nu sunt valide caractere.");
                System.exit(-1);
            }
        }
    }

    public static String[] generareCuvinte(int n, int p, char[] litere, int lungAlfabet)
    {
        String[] cuvinte = new String[n];
        for (int i = 0; i < n; i++) //n = 10 cuvinte
        {
            StringBuilder cuvant = new StringBuilder(); //strB
            for (int j = 0; j < p; j++)
            {
                int z = rand.nextInt(lungAlfabet);
                cuvant.append(litere[z]);
            }
            cuvinte[i] = cuvant.toString();
        }
        return cuvinte;
    }
}
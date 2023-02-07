import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int choice = 0;
        int toMove = 3;
        char offSet = 'a';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1 to encrypt or 2 to decrypt");
        choice = scanner.nextInt();
        if( choice == 1)
        {
            System.out.println("Enter the text to encrypt");
            String plainText = scanner.next();
            System.out.println("Enter offset character");
            offSet = scanner.next().charAt(0);

            encrypt(plainText, offSet);
        }
        else if (choice == 2)
        {
            System.out.println("Enter the text to decrypt");
            String encodedText = scanner.next();
            System.out.println("Enter offset character");
            offSet = scanner.next().charAt(0);
            decrypt(encodedText, offSet);
        }
        else
        {
            System.out.println("Invalid choice, exiting");
        }
    }


    public static void encrypt(String plainText, char offSet)
    {
        char[] charLibrary = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z','0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '(', ')','*','+', ',', '-', '.','/'};
        char[] charArray = plainText.toLowerCase().toCharArray();
        int toMove =0;
        for ( int k=0; k< charLibrary.length; k++)
        {
            if (offSet == charLibrary[k])
            {
                toMove = k+1;
            }
        }
        for( int i=0; i< charArray.length; i++)
        {
            for ( int j=0; j< charLibrary.length; j++)
            {
                if ( charArray[i] == charLibrary[j])
                {
                    if( j+toMove > charLibrary.length){
                        System.out.print(charLibrary[j+toMove - charLibrary.length]);

                    }
                    else
                    {
                        System.out.print(charLibrary[j+toMove] );
                    }
                }
            }
        }

    }

    public static void decrypt(String encodedText, char offSet)
    {
        char[] charLibrary = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z','0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '(', ')','*','+', ',', '-', '.','/'};
        char[] encodedArray = encodedText.toLowerCase().toCharArray();
        int toMove =0;

        for ( int k=0; k< charLibrary.length; k++)
        {
            if (offSet == charLibrary[k])
            {
                toMove = -(k+1);
            }
        }

        for( int i=0; i<encodedArray.length; i++)
        {
            for ( int j=0; j< charLibrary.length; j++)
            {
                if (encodedArray[i] == charLibrary[j])
                {
                    if( j+toMove < 0)
                    {
                        System.out.print(charLibrary[j+toMove + charLibrary.length]);
                    }
                    else
                    {
                    System.out.print(charLibrary[j+toMove]);
                    }
                }
            }
        }
    }
}
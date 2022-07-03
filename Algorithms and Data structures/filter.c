//sara 
//2020 uppgift 1

/*Write a simple filter to clean a text, i.e. to remove all characters that are not 
alphabetic, blank or newline - replacing every such character by a blank to keep the
 number of characters constant to the original text. Hint: this is easy to do in C using 
 the "isalpha()" function (to find out more about it on a unix/linux system type: man isalpha as a command to the shell)*/


#include <stdio.h>
#include <ctype.h>

int main(void)
{
    
    char c;
    //sålänge c inte i sluttet av filen
     while((c = getchar()) != EOF)           //char från stdin
    {
    	//is alpha kollar ifall charactaren är en bokstav.
    	//kollar om c är en bokstav, eller en new line, skriv ut det.
        if(isalpha(c) || c == '\n')
        
            putchar(c);
       //annars skriv ut blank
        else
            putchar(' ');
    }
}


//EOf tillstånd då inga fler data kan läses av från filen, (when the end of the stream is reached.)

//gcc filter.c -o filter
//./filter < text.txt








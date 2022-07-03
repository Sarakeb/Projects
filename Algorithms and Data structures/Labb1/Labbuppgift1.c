
/*ReadMe assignment question:

In C implement a recursive and an iterative version of a function which reads characters from stdin until a newline character is read
 and then prints them on stdout in reverse order. Hint: use getchar(), putchar() (or getc(), putc()). For the iterative version you may 
 assume a fixed max length of the input.

*/

//Sara Debebe Kebede

#include <stdio.h>
//reverse med recursion
void recursion(){
	//det ska köras sålänge vi inte hittar ett new line, dvs "/n"
	char x= getchar();   //få input från användaren
	if(x != '\n')   //base case, detta används då 
	{
		
		recursion();   //ropar på sig själv.
	}

	putchar(x);
	}
	/*if (x) input is a b c d, first it checks if there is a new line between a and b, there is not
	so it calls itself recursion, and stores a in stack. does the same thing to b, c and d. after d
	there is a new line, so it goes to putchar(x); and prints all info from the stack in lifo order.
	in that case the result is going to be reversed.*/






void iterative(){
    //om vi tänker max längd är 20 --> fixed max length.
	int i=0;
	char z = '\n';  //a new line
     char x= getchar();  //användarens input
      char array[20];
    while (x!= z){   //sålänge x inte är lycka med new line
        array [i] = x;
        i++;
       x=getchar();
    }
    
    int j;
	for(j=z-1; j>=0; j--){  //reverse order vi börjar från sista elementet i arrayen och skriver med hjälv av putchar.
	putchar(array[j]);

}
}



int main()
{
    printf("The charachter to be reversed:\n");
    recursion(); 
    iterative();
    putchar('\n');
}

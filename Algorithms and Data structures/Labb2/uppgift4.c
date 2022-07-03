
//Sara 2020
/*implement a function in C which takes an array of integers (both positive and negative) and orders the elements in 
the array so that all negative elements come before the positive.*/

#include <stdio.h>

void sortNr(int a[], int n) {
int x=0;  //markerar negativa tal som ska bli sorterad
int temporary;

//loop invariant i deta fall, för alla i, om det finns siffor på vänsta sidan av kommer de att vara negativa sifrror.


for(int i = 0; i < n; i++) {   //börja frn 0 och loppa igenom den.
  //om talet i arrayen är mindra än noll.
  if(a[i] < 0) {    //0 is pivot, om talet är mindre än 0. alltså negativt tal. 
    
    //Swapa värdet som är mindre än noll till x position. 
      temporary = a[i];   //spara negativa talet i variablen temporary
      a[i] = a[x];  //spara elementen som var i början där negativa talet var
      a[x] = temporary;  //spara den på x position, alltså i början. 
     x++; //x ökar varje gågn vi swappar
   }
 }
}

int main(void) {
  int allNr;
  printf("enter max amount of numbers in the array:" );
  scanf("%d", &allNr); 
  int totNr[allNr];
  printf("enter the elements in the array:\n");
 
  for(int i = 0; i < allNr; i++)
    scanf("%d", &totNr[i]);
    sortNr(totNr, allNr);
    printf("negetive values are collected first:\n");
    for(int i = 0; i < allNr; i++)  
    printf("%d ", totNr[i]);
}

//gcc uppgift4.c -o u

/*i loopen ska variablen i iterera sig igenom hela arrayen och genom if satsen kan man
använda 0 som någon slags pivot, där siffror som är mindre än 0 ska placeras på vänsta sidan, och tal som är större än 0 ska placeras på högra 
sidan av arrayen.*/
/*Library Management System*/

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
struct library
{
char book_name[30];
char publisher[30];
char author[30];
char sub[20];
int price;
int pages;
};

int main()
{
struct library b[100];
char pb_nm[30],bk_nm[30],ar_nm[30];
int i,j, keepcount;
i=j=keepcount = 0;

printf("\n\nLIBRARY MANAGEMENT SYSTEM \n");
while(j!=8)
{
printf("1. Add book information\n");
printf("2. Display all book information\n");
printf("3. Display information of book having highest price\n");
printf("4. Information about the books of a given publisher\n");
printf("5. Information about the books of a given author\n");
printf("6. List the count of books in the library\n");
printf("7. Information about the book as per the entered book name\n");
printf("8. Exit\n\n");

printf ("\n\nEnter one of the above : ");
scanf("%d",&j);

switch (j)
{
/* Add book information */
case 1:  
{
	printf ("Enter book name = ");
	scanf ("%s",b[i].book_name);
	
	printf ("\n Enter publisher name = ");
	scanf ("%s",b[i].publisher);

	printf ("\nEnter price = ");
	scanf ("%d",&b[i].price);

    printf ("\n Enter author name = ");
    scanf ("%s",b[i].author);

    printf ("\n Enter pages = ");
    scanf ("%d",&b[i].pages);


    printf ("\n Enter sub name = ");
    scanf ("%s",b[i].sub);
}
	keepcount++;

	break;

     /*Displaying all book information*/
    case 2:
printf("You have entered the following information\n");
for(i=0; i<keepcount; i++)
{
printf ("Book name = %s",b[i].book_name);

printf ("\n Author name = %s",b[i].author);

printf ("\n  Pages = %d",b[i].pages);

printf ("\n  Price = %d",b[i].price);

printf ("\n  Publisher name = %s",b[i].publisher);

printf ("\n Subject name = %s",b[i].sub);
}
break;

/*Book having highest price*/
case 3:
	printf ("Highest Price Book : ");
float temp = 0;
	for (i=0;i<keepcount;i++)
	{
	    if(temp < b[i].price)
	        temp = b[i].price;
	}
	printf("%f\n", temp);

    printf ("Book name = %s\n",b[i].book_name);

printf ("\n Author name = %s\n",b[i].author);

printf ("\n  Pages = %d",b[i].pages);

printf ("\n  Publisher name = %s\n",b[i].publisher);

printf ("\n Subject name = %s\n",b[i].sub);
	
	break;

/*Displaying books of a specific publisher*/
case 4:
printf ("Enter publisher name : ");
scanf ("%s",pb_nm);
for (i=0; i<keepcount; i++)
{
if (strcmp(pb_nm, b[i].publisher) == 0)
{
    printf ("Book name = %s",b[i].book_name);

printf ("\n Author name = %s",b[i].author);

printf ("\n  Pages = %d",b[i].pages);

printf ("\n  Price = %d",b[i].price);

printf ("\n Subject name = %s",b[i].sub);
	
}
}

break;
	
/*Displaying books of a specific author*/
case 5:
printf ("Enter author name : ");
scanf ("%s",ar_nm);
for (i=0; i<keepcount; i++)
{
if (strcmp(ar_nm, b[i].author) == 0)
{
    printf ("Book name = %s",b[i].book_name);

printf ("\n Publisher name = %s",b[i].publisher);

printf ("\n  Pages = %d",b[i].pages);

printf ("\n  Price = %d",b[i].price);

printf ("\n Subject name = %s",b[i].sub);
	
}
}
break;

/*Total number of books in library*/
case 6:
printf("\n No of books in library : %d", keepcount);
break;

/*Information about a specific book*/
case 7:
printf ("Enter book name : ");
scanf ("%s",bk_nm);
for (i=0; i<keepcount; i++)
{
if (strcmp(bk_nm, b[i].book_name) == 0)
{
    printf ("Publisher name = %s",b[i].publisher);

printf ("\n Author name = %s",b[i].author);

printf ("\n  Pages = %d",b[i].pages);

printf ("\n  Price = %d",b[i].price);

printf ("\n Subject name = %s",b[i].sub);
}
}
break;


case 8:
	exit (0); 
}
}
return 0;
}

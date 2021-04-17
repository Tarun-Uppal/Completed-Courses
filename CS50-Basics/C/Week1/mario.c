#include<stdio.h>
#include<cs50.h>
#include<string.h>

void concatenate(char [], char []);

int main(void)
{
    int size = 5;
    while (true)
    {
        size = get_int("Enter the size of the tower ");   
        if (size > 0 && size <= 8)
        {
            break;
        }
    }
    for (int i = 1; i != size + 1; i++)
    {
        
        for (int j = size - i; j != 0; j--)
        {
            printf(" ");
        }
        for (int j = i; j != 0; j--)
        {
            printf("#");
        }
        printf("  ");
        for (int j = i; j != 0; j--)
        {
            printf("#");
        }
        printf("\n");
    }
}